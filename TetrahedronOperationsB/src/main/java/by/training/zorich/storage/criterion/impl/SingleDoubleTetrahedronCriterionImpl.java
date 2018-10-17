package by.training.zorich.storage.criterion.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.SingleTetrahedronCriterion;
import by.training.zorich.storage.extractant.DoubleFieldTetrahedronExtractant;

public class SingleDoubleTetrahedronCriterionImpl implements SingleTetrahedronCriterion {
	DoubleFieldTetrahedronExtractant doubleFieldTetrahedronExtractant;
	Double criterion;

	public SingleDoubleTetrahedronCriterionImpl(DoubleFieldTetrahedronExtractant doubleFieldTetrahedronExtractant, Double criterion) {
		this.doubleFieldTetrahedronExtractant = doubleFieldTetrahedronExtractant;
		this.criterion = criterion;
	}

	@Override
	public Double criterionValue() {
		return criterion;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return doubleFieldTetrahedronExtractant.extractTetrahedronField(tetrahedron);
	}
}
