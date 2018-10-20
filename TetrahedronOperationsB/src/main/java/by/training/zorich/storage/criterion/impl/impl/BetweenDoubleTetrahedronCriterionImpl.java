package by.training.zorich.storage.criterion.impl.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.impl.BetweenTetrahedronCriterion;
import by.training.zorich.storage.accessor.impl.DoubleFieldTetrahedronAccessor;

public class BetweenDoubleTetrahedronCriterionImpl implements BetweenTetrahedronCriterion {
	DoubleFieldTetrahedronAccessor doubleFieldTetrahedronExtractant;
	Double minCriterion;
	Double maxCriterion;

	public BetweenDoubleTetrahedronCriterionImpl(DoubleFieldTetrahedronAccessor doubleFieldTetrahedronExtractant, Double minCriterion, Double maxCriterion) {
		this.doubleFieldTetrahedronExtractant = doubleFieldTetrahedronExtractant;
		this.minCriterion = minCriterion;
		this.maxCriterion = maxCriterion;
	}

	@Override
	public Double criterionMinValue() {
		return minCriterion;
	}

	@Override
	public Double criterionMaxValue() {
		return maxCriterion;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return doubleFieldTetrahedronExtractant.extractTetrahedronField(tetrahedron);
	}
}
