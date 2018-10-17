package by.training.zorich.storage.extractant.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.extractant.DoubleFieldTetrahedronExtractant;
import by.training.zorich.storage.extractant.PointFieldTetrahedronExtractant;

public class CoordinateYVertexTetrahedronExtractantImpl implements DoubleFieldTetrahedronExtractant {
	PointFieldTetrahedronExtractant pointTetrahedronCriterion;

	public CoordinateYVertexTetrahedronExtractantImpl(PointFieldTetrahedronExtractant pointTetrahedronCriterion) {
		this.pointTetrahedronCriterion = pointTetrahedronCriterion;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return pointTetrahedronCriterion.extractTetrahedronField(tetrahedron).getCoordinateY();
	}
}
