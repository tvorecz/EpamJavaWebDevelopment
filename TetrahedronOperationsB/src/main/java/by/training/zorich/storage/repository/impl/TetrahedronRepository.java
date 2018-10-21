package by.training.zorich.storage.repository.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.specification.impl.TetrahedronSpecification;
import by.training.zorich.storage.updater.TetrahedronUpdater;

import java.util.List;

public interface TetrahedronRepository {
	void addTetrahedron(Tetrahedron tetrahedron);

	void addTetrahedrons(List<Tetrahedron> tetrahedrons, TetrahedronSpecification specification);

	void removeTetrahedron(Tetrahedron tetrahedron);

	void removeTetrahedrons(TetrahedronSpecification specification);

	void updateTetrahedron(Tetrahedron tetrahedron);

	void updateTetrahedrons(TetrahedronSpecification specification, TetrahedronUpdater tetrahedronUpdater);

	List<Tetrahedron> allTetrahedrons();

	Tetrahedron tetrahedron(int id);

	List<Tetrahedron> query(TetrahedronSpecification specification);
}
