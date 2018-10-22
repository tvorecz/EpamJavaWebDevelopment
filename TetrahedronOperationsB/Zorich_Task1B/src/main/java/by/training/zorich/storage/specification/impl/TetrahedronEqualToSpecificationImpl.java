package by.training.zorich.storage.specification.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.SingleTetrahedronCriterion;

public class TetrahedronEqualToSpecificationImpl extends TetrahedronCommonSpecificationImpl {
	SingleTetrahedronCriterion singleTetrahedronCriterion;

	public TetrahedronEqualToSpecificationImpl(SingleTetrahedronCriterion singleTetrahedronCriterion) {
		this.singleTetrahedronCriterion = singleTetrahedronCriterion;
	}

	@Override
	public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
		return singleTetrahedronCriterion.extractTetrahedronField(tetrahedron)
										 .equals(singleTetrahedronCriterion.criterionValue());
	}
}
