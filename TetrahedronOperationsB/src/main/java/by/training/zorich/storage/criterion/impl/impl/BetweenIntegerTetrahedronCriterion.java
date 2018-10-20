package by.training.zorich.storage.criterion.impl.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.impl.BetweenTetrahedronCriterion;
import by.training.zorich.storage.accessor.impl.IntegerFieldTetrahedronAccessor;

public class BetweenIntegerTetrahedronCriterion implements BetweenTetrahedronCriterion {
	IntegerFieldTetrahedronAccessor integerFieldTetrahedronExtractant;
	Integer minCriterion;
	Integer maxCriterion;

	public BetweenIntegerTetrahedronCriterion(IntegerFieldTetrahedronAccessor integerFieldTetrahedronExtractant, Integer minCriterion, Integer maxCriterion) {
		this.integerFieldTetrahedronExtractant = integerFieldTetrahedronExtractant;
		this.minCriterion = minCriterion;
		this.maxCriterion = maxCriterion;
	}

	@Override
	public Integer criterionMinValue() {
		return minCriterion;
	}

	@Override
	public Integer criterionMaxValue() {
		return maxCriterion;
	}

	@Override
	public Integer extractTetrahedronField(Tetrahedron tetrahedron) {
		return integerFieldTetrahedronExtractant.extractTetrahedronField(tetrahedron);
	}
}