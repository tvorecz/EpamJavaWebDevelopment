package by.training.zorich.storage.criterion.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.BetweenTetrahedronCriterion;
import by.training.zorich.storage.accesser.IntegerFieldTetrahedronAccesser;

public class BetweenIntegerTetrahedronCriterion implements BetweenTetrahedronCriterion{
	IntegerFieldTetrahedronAccesser integerFieldTetrahedronExtractant;
	Integer minCriterion;
	Integer maxCriterion;

	public BetweenIntegerTetrahedronCriterion(IntegerFieldTetrahedronAccesser integerFieldTetrahedronExtractant, Integer minCriterion, Integer maxCriterion) {
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