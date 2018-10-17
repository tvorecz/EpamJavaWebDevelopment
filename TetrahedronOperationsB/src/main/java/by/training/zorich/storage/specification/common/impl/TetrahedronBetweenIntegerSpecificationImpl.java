package by.training.zorich.storage.specification.common.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.impl.BetweenIntegerTetrahedronCriterion;
import by.training.zorich.storage.specification.common.TetrahedronCommonSpecificationImpl;

public class TetrahedronBetweenIntegerSpecificationImpl extends TetrahedronCommonSpecificationImpl {
	BetweenIntegerTetrahedronCriterion betweenIntegerTetrahedronCriterion;

	public TetrahedronBetweenIntegerSpecificationImpl(BetweenIntegerTetrahedronCriterion betweenIntegerTetrahedronCriterion) {
		this.betweenIntegerTetrahedronCriterion = betweenIntegerTetrahedronCriterion;
	}

	@Override
	public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
		return (betweenIntegerTetrahedronCriterion.criterionMinValue() < betweenIntegerTetrahedronCriterion.extractTetrahedronField(tetrahedron)) && (betweenIntegerTetrahedronCriterion.extractTetrahedronField(tetrahedron) < betweenIntegerTetrahedronCriterion.criterionMaxValue());
	}
}
