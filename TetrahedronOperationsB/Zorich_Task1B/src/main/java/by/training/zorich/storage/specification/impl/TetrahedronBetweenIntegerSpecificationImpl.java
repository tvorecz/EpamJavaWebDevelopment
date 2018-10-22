package by.training.zorich.storage.specification.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.impl.BetweenIntegerTetrahedronCriterionImpl;

public class TetrahedronBetweenIntegerSpecificationImpl extends TetrahedronCommonSpecificationImpl {
	BetweenIntegerTetrahedronCriterionImpl betweenIntegerTetrahedronCriterionImpl;

	public TetrahedronBetweenIntegerSpecificationImpl(BetweenIntegerTetrahedronCriterionImpl betweenIntegerTetrahedronCriterionImpl) {
		this.betweenIntegerTetrahedronCriterionImpl = betweenIntegerTetrahedronCriterionImpl;
	}

	@Override
	public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
		return (betweenIntegerTetrahedronCriterionImpl.criterionMinValue() <= betweenIntegerTetrahedronCriterionImpl.extractTetrahedronField(
				tetrahedron)) && (betweenIntegerTetrahedronCriterionImpl.extractTetrahedronField(tetrahedron) <= betweenIntegerTetrahedronCriterionImpl
				.criterionMaxValue());
	}
}
