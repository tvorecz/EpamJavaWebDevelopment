package by.training.zorich.storage.specification.common.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.impl.SingleDoubleTetrahedronCriterionImpl;
import by.training.zorich.storage.specification.common.TetrahedronCommonSpecificationImpl;

public class TetrahedronLessThanDoubleSpecificationImpl extends TetrahedronCommonSpecificationImpl {
	SingleDoubleTetrahedronCriterionImpl singleDoubleTetrahedronCriterion;

	public TetrahedronLessThanDoubleSpecificationImpl(SingleDoubleTetrahedronCriterionImpl singleDoubleTetrahedronCriterion) {
		this.singleDoubleTetrahedronCriterion = singleDoubleTetrahedronCriterion;
	}

	@Override
	public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
		return singleDoubleTetrahedronCriterion.criterionValue() > singleDoubleTetrahedronCriterion.extractTetrahedronField(tetrahedron) ;
	}
}
