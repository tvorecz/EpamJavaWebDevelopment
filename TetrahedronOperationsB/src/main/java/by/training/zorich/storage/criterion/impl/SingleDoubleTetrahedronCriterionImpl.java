package by.training.zorich.storage.criterion.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.SingleTetrahedronCriterion;
import by.training.zorich.storage.accessor.DoubleFieldTetrahedronAccessor;

public class SingleDoubleTetrahedronCriterionImpl implements SingleTetrahedronCriterion {
	DoubleFieldTetrahedronAccessor doubleFieldTetrahedronExtractant;
	Double criterion;

	public SingleDoubleTetrahedronCriterionImpl(DoubleFieldTetrahedronAccessor doubleFieldTetrahedronExtractant,
												Double criterion) {
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
