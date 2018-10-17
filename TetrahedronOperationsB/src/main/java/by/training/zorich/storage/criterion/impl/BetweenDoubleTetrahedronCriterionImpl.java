package by.training.zorich.storage.criterion.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.BetweenTetrahedronCriterion;
import by.training.zorich.storage.accesser.DoubleFieldTetrahedronAccesser;

public class BetweenDoubleTetrahedronCriterionImpl implements BetweenTetrahedronCriterion{
	DoubleFieldTetrahedronAccesser doubleFieldTetrahedronExtractant;
	Double minCriterion;
	Double maxCriterion;

	public BetweenDoubleTetrahedronCriterionImpl(DoubleFieldTetrahedronAccesser doubleFieldTetrahedronExtractant, Double minCriterion, Double maxCriterion) {
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
