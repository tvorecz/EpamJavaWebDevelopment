package by.training.zorich.storage.extractant.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.extractant.DoubleFieldTetrahedronExtractant;
import by.training.zorich.storage.extractant.PointFieldTetrahedronExtractant;

public class CoordinateXVertexTetrahedronExtractantImpl implements DoubleFieldTetrahedronExtractant {
	PointFieldTetrahedronExtractant pointTetrahedronCriterion;

	public CoordinateXVertexTetrahedronExtractantImpl(PointFieldTetrahedronExtractant pointTetrahedronCriterion) {
		this.pointTetrahedronCriterion = pointTetrahedronCriterion;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return pointTetrahedronCriterion.extractTetrahedronField(tetrahedron).getCoordinateX();
	}
}
