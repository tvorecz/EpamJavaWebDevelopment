package by.training.zorich.storage.specification.common.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.impl.BetweenDoubleTetrahedronCriterionImpl;
import by.training.zorich.storage.specification.common.TetrahedronCommonSpecificationImpl;

public class TetrahedronBetweenDoubleSpecificationImpl extends TetrahedronCommonSpecificationImpl {
	BetweenDoubleTetrahedronCriterionImpl betweenDoubleTetrahedronCriterion;

	public TetrahedronBetweenDoubleSpecificationImpl(BetweenDoubleTetrahedronCriterionImpl betweenDoubleTetrahedronCriterion) {
		this.betweenDoubleTetrahedronCriterion = betweenDoubleTetrahedronCriterion;
	}

	@Override
	public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
		return (betweenDoubleTetrahedronCriterion.criterionMinValue() < betweenDoubleTetrahedronCriterion.extractTetrahedronField(tetrahedron)) && (betweenDoubleTetrahedronCriterion.extractTetrahedronField(tetrahedron) < betweenDoubleTetrahedronCriterion.criterionMaxValue());
	}
}
