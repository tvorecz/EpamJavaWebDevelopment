package by.training.zorich.storage.specification.common;

import by.training.zorich.storage.specification.TetrahedronSpecification;

public abstract class TetrahedronCommonSpecificationImpl implements TetrahedronSpecification {
	public TetrahedronCommonSpecificationImpl() {
	}

	@Override
	public TetrahedronSpecification And(TetrahedronSpecification otherSpecification) {
		return new TetrahedronAndSpecificationImpl(this, otherSpecification);
	}

	@Override
	public TetrahedronSpecification Or(TetrahedronSpecification otherSpecification) {
		return new TetrahedronOrSpecificationImpl(this, otherSpecification);
	}

	@Override
	public TetrahedronSpecification Not() {
		return new TetrahedronNotSpecificationImpl(this);
	}
}
