package by.training.zorich.storage.repository.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.event.EventPublisher;
import by.training.zorich.storage.event.EventType;
import by.training.zorich.storage.event.arg.AdditionTetrahedronEventArg;
import by.training.zorich.storage.event.arg.ModificationTetrahedronEventArg;
import by.training.zorich.storage.event.arg.RemovalTetrahedronEventArg;
import by.training.zorich.storage.event.manager.TetrahedronEventManager;
import by.training.zorich.storage.register.impl.TetrahedronRegisterImpl;
import by.training.zorich.storage.repository.TetrahedronRepository;
import by.training.zorich.storage.specification.TetrahedronSpecification;
import by.training.zorich.storage.updater.TetrahedronUpdater;

import java.util.*;

public class TetrahedronRepositoryImpl implements TetrahedronRepository {
	private static TetrahedronRepositoryImpl tetrahedronRegisterImpl;

	private EventPublisher eventPublisher;
	private Map<Integer, Tetrahedron> tetrahedronsSource;
	IdGenerator idGenerator;

	private TetrahedronRepositoryImpl() {
		tetrahedronsSource = new HashMap<>();
		idGenerator = new IdGenerator();

		setSubscribers();
	}

	public static TetrahedronRepositoryImpl getInstance() {
		if (tetrahedronRegisterImpl == null) {
			tetrahedronRegisterImpl = new TetrahedronRepositoryImpl();
		}

		return tetrahedronRegisterImpl;
	}

	@Override
	public void addTetrahedrons(List<Tetrahedron> tetrahedrons, TetrahedronSpecification specification) {
		for (Tetrahedron tetrahedron : tetrahedrons) {
			if (specification.isSatisfiedBy(tetrahedron)) {
				tetrahedronsSource.put(idGenerator.nextId(), tetrahedron);
			}
		}
	}

	@Override
	public void removeTetrahedrons(TetrahedronSpecification specification) {
		Iterator<Tetrahedron> tetrahedronIterator = tetrahedronsSource.values().iterator();

		while (tetrahedronIterator.hasNext()) {
			Tetrahedron tetrahedron = tetrahedronIterator.next();

			if (specification.isSatisfiedBy(tetrahedron)) {
				tetrahedronIterator.remove();
			}
		}
	}

	@Override
	public void updateTetrahedrons(TetrahedronSpecification specification, TetrahedronUpdater tetrahedronUpdater) {
		Iterator<Tetrahedron> tetrahedronIterator = tetrahedronsSource.values().iterator();

		while (tetrahedronIterator.hasNext()) {
			Tetrahedron tetrahedron = tetrahedronIterator.next();

			if (specification.isSatisfiedBy(tetrahedron)) {
				tetrahedronUpdater.update(tetrahedron);
			}
		}
	}

	@Override
	public void addTetrahedron(Tetrahedron tetrahedron) {
		int id = idGenerator.nextId();

		Tetrahedron newTetrahedron = cloneTetrahedron(tetrahedron);
		newTetrahedron.setId(id);

		tetrahedronsSource.put(id, newTetrahedron);

		eventPublisher.notifySubscribers(new AdditionTetrahedronEventArg(newTetrahedron, EventType.ADD));
	}

	@Override
	public void updateTetrahedron(Tetrahedron tetrahedron) {
		Integer index = tetrahedron.getId();

		Tetrahedron updatedTetrahedron = cloneTetrahedron(tetrahedron);

		tetrahedronsSource.replace(index, updatedTetrahedron);

		eventPublisher.notifySubscribers(new ModificationTetrahedronEventArg(tetrahedron, EventType.UPDATE));
	}

	@Override
	public void removeTetrahedron(Tetrahedron tetrahedron) {
		tetrahedronsSource.remove(tetrahedron.getId());

		eventPublisher.notifySubscribers(new RemovalTetrahedronEventArg(tetrahedron, EventType.REMOVE));
	}

	@Override
	public List<Tetrahedron> query(TetrahedronSpecification specification) {
		List<Tetrahedron> tetrahedronList = new ArrayList<>();

		for (Tetrahedron tetrahedron : tetrahedronsSource.values()) {
			if (specification.isSatisfiedBy(tetrahedron)) {
				tetrahedronList.add(cloneTetrahedron(tetrahedron));
			}
		}

		return null;
	}

	private Tetrahedron cloneTetrahedron(Tetrahedron tetrahedron) {
		Tetrahedron clonedTetrahedron = new Tetrahedron();

		clonedTetrahedron.setId(tetrahedron.getId());

		clonedTetrahedron.setVertexA(clonePoint(tetrahedron.getVertexA()));
		clonedTetrahedron.setVertexB(clonePoint(tetrahedron.getVertexB()));
		clonedTetrahedron.setVertexC(clonePoint(tetrahedron.getVertexC()));
		clonedTetrahedron.setVertexD(clonePoint(tetrahedron.getVertexD()));

		return clonedTetrahedron;
	}

	private Point clonePoint(Point vertex) {
		Point clonedVertex = new Point();

		clonedVertex.setCoordinateX(vertex.getCoordinateX());
		clonedVertex.setCoordinateY(vertex.getCoordinateY());
		clonedVertex.setCoordinateZ(vertex.getCoordinateZ());

		return clonedVertex;
	}

	private void setSubscribers() {
		eventPublisher = TetrahedronEventManager.getInstance();
		eventPublisher.subscribe(TetrahedronRegisterImpl.getInstance(), EventType.ADD);
		eventPublisher.subscribe(TetrahedronRegisterImpl.getInstance(), EventType.UPDATE);
		eventPublisher.subscribe(TetrahedronRegisterImpl.getInstance(), EventType.REMOVE);
	}
}
