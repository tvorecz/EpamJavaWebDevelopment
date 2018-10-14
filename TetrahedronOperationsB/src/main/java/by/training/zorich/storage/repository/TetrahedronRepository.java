package by.training.zorich.storage.repository;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.specification.TetrahedronQuerySpecification;

import java.util.List;

public interface TetrahedronRepository {
	void addTetrahedron(Tetrahedron tetrahedron);

	void removeTetrahedron(Tetrahedron tetrahedron);

	void updateTetrahedron(Tetrahedron tetrahedron);

	List<Tetrahedron> query(TetrahedronQuerySpecification specification);
}
