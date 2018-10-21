package by.training.zorich.storage.specification.impl.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.impl.impl.SingleDoubleTetrahedronCriterionImpl;

public class TetrahedronMoreThanDoubleSpecificationImpl extends TetrahedronCommonSpecificationImpl {
	SingleDoubleTetrahedronCriterionImpl singleDoubleTetrahedronCriterion;

	public TetrahedronMoreThanDoubleSpecificationImpl(SingleDoubleTetrahedronCriterionImpl singleDoubleTetrahedronCriterion) {
		this.singleDoubleTetrahedronCriterion = singleDoubleTetrahedronCriterion;
	}

	@Override
	public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
		return singleDoubleTetrahedronCriterion.criterionValue() < singleDoubleTetrahedronCriterion.extractTetrahedronField(tetrahedron);
	}
}
