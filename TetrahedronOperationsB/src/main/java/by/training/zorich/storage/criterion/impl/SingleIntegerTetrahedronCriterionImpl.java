package by.training.zorich.storage.criterion.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.SingleTetrahedronCriterion;
import by.training.zorich.storage.accesser.IntegerFieldTetrahedronAccesser;

public class SingleIntegerTetrahedronCriterionImpl implements SingleTetrahedronCriterion {
	IntegerFieldTetrahedronAccesser integerFieldTetrahedronExtractant;
	Integer criterion;

	public SingleIntegerTetrahedronCriterionImpl(IntegerFieldTetrahedronAccesser integerFieldTetrahedronExtractant, Integer criterion) {
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
