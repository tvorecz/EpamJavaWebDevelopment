package by.training.zorich.storage.specification.impl.impl;

import by.training.zorich.storage.specification.impl.TetrahedronSpecification;

public abstract class TetrahedronCommonSpecificationImpl implements TetrahedronSpecification {
	public TetrahedronCommonSpecificationImpl() {
	}

	@Override
	public TetrahedronSpecification and(TetrahedronSpecification otherSpecification) {
		return new TetrahedronAndSpecificationImpl(this, otherSpecification);
	}

	@Override
	public TetrahedronSpecification or(TetrahedronSpecification otherSpecification) {
		return new TetrahedronOrSpecificationImpl(this, otherSpecification);
	}

	@Override
	public TetrahedronSpecification not() {
		return new TetrahedronNotSpecificationImpl(this);
	}
}
