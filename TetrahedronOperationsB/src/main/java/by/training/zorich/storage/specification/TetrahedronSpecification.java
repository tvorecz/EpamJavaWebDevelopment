package by.training.zorich.storage.specification;

import by.training.zorich.domain.Tetrahedron;

public interface TetrahedronSpecification {
	boolean isSatisfiedBy(Tetrahedron tetrahedron);

	TetrahedronSpecification And(TetrahedronSpecification otherSpecification);

	TetrahedronSpecification Or(TetrahedronSpecification otherSpecification);

	TetrahedronSpecification Not();
}
