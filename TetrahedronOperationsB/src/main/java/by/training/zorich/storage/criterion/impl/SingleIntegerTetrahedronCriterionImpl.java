package by.training.zorich.storage.criterion.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.SingleTetrahedronCriterion;
import by.training.zorich.storage.extractant.IntegerFieldTetrahedronExtractant;

public class SingleIntegerTetrahedronCriterionImpl implements SingleTetrahedronCriterion {
	IntegerFieldTetrahedronExtractant integerFieldTetrahedronExtractant;
	Integer criterion;

	public SingleIntegerTetrahedronCriterionImpl(IntegerFieldTetrahedronExtractant integerFieldTetrahedronExtractant, Integer criterion) {
		this.integerFieldTetrahedronExtractant = integerFieldTetrahedronExtractant;
		this.criterion = criterion;
	}

	@Override
	public Integer criterionValue() {
		return criterion;
	}

	@Override
	public Integer extractTetrahedronField(Tetrahedron tetrahedron) {
		return integerFieldTetrahedronExtractant.extractTetrahedronField(tetrahedron);
	}
}
