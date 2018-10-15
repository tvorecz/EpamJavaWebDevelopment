package by.training.zorich.storage.repository;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.specification.TetrahedronManipulator;
import by.training.zorich.storage.specification.TetrahedronSpecification;

import java.util.List;

public interface TetrahedronRepository {
	void addTetrahedron(Tetrahedron tetrahedron);

	void addTetrahedrons(List<Tetrahedron> tetrahedrons, TetrahedronSpecification specification);

	void removeTetrahedron(Tetrahedron tetrahedron);

	void removeTetrahedrons(TetrahedronSpecification specification);

	void updateTetrahedron(Tetrahedron tetrahedron);

	void updateTetrahedrons(TetrahedronSpecification specification, TetrahedronManipulator manipulator);

	List<Tetrahedron> query(TetrahedronSpecification specification);
}
