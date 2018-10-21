package by.training.zorich.storage.specification.impl.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.specification.impl.TetrahedronSpecification;

public class TetrahedronAndSpecificationImpl extends TetrahedronCommonSpecificationImpl {
	TetrahedronSpecification firstSpecification;
	TetrahedronSpecification secondSpecification;

	public TetrahedronAndSpecificationImpl(TetrahedronSpecification firstSpecification, TetrahedronSpecification secondSpecification) {
		this.firstSpecification = firstSpecification;
		this.secondSpecification = secondSpecification;
	}

	@Override
	public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
		return firstSpecification.isSatisfiedBy(tetrahedron) && secondSpecification.isSatisfiedBy(tetrahedron);
	}
}
