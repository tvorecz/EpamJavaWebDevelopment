package by.training.zorich.storage.specification;

import by.training.zorich.domain.Tetrahedron;

public interface TetrahedronSpecification {
	boolean isSatisfiedBy(Tetrahedron tetrahedron);

	TetrahedronSpecification and(TetrahedronSpecification otherSpecification);

	TetrahedronSpecification or(TetrahedronSpecification otherSpecification);

	TetrahedronSpecification not();
}
