package by.training.zorich.storage.criterion.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.SingleTetrahedronCriterion;
import by.training.zorich.storage.accessor.IntegerFieldTetrahedronAccessor;

public class SingleIntegerTetrahedronCriterionImpl implements SingleTetrahedronCriterion {
	IntegerFieldTetrahedronAccessor integerFieldTetrahedronExtractant;
	Integer criterion;

	public SingleIntegerTetrahedronCriterionImpl(IntegerFieldTetrahedronAccessor integerFieldTetrahedronExtractant, Integer criterion) {
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
