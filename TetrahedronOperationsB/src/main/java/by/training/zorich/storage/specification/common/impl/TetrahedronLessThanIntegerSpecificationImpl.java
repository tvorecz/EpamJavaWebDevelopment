package by.training.zorich.storage.specification.common.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.impl.SingleIntegerTetrahedronCriterionImpl;
import by.training.zorich.storage.specification.common.TetrahedronCommonSpecificationImpl;

public class TetrahedronLessThanIntegerSpecificationImpl extends TetrahedronCommonSpecificationImpl {
	SingleIntegerTetrahedronCriterionImpl singleIntegerTetrahedronCriterion;

	public TetrahedronLessThanIntegerSpecificationImpl(SingleIntegerTetrahedronCriterionImpl singleIntegerTetrahedronCriterion) {
		this.singleIntegerTetrahedronCriterion = singleIntegerTetrahedronCriterion;
	}

	@Override
	public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
		return singleIntegerTetrahedronCriterion.criterionValue() > singleIntegerTetrahedronCriterion.extractTetrahedronField(tetrahedron);
	}
}
