package by.training.zorich.storage.specification.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.specification.TetrahedronSpecification;

public class TetrahedronNotSpecificationImpl extends TetrahedronCommonSpecificationImpl {
	TetrahedronSpecification specification;

	public TetrahedronNotSpecificationImpl(TetrahedronSpecification specificationpecification) {
		this.specification = specification;
	}

	@Override
	public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
		return !specification.isSatisfiedBy(tetrahedron);
	}
}

