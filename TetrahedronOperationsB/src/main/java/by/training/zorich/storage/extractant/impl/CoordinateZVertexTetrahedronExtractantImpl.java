package by.training.zorich.storage.extractant.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.extractant.DoubleFieldTetrahedronExtractant;
import by.training.zorich.storage.extractant.PointFieldTetrahedronExtractant;

public class CoordinateZVertexTetrahedronExtractantImpl implements DoubleFieldTetrahedronExtractant {
	PointFieldTetrahedronExtractant pointTetrahedronCriterion;

	public CoordinateZVertexTetrahedronExtractantImpl(PointFieldTetrahedronExtractant pointTetrahedronCriterion) {
		this.pointTetrahedronCriterion = pointTetrahedronCriterion;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return pointTetrahedronCriterion.extractTetrahedronField(tetrahedron).getCoordinateZ();
	}
}
