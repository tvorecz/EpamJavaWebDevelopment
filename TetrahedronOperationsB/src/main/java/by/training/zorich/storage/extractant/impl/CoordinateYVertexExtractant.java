package by.training.zorich.storage.extractant.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.extractant.CoordinateExtractant;
import by.training.zorich.storage.extractant.PointExtractant;

public class CoordinateYVertexExtractant implements CoordinateExtractant {
	PointExtractant pointExtractant;

	public CoordinateYVertexExtractant(PointExtractant pointExtractant) {
		this.pointExtractant = pointExtractant;
	}

	@Override
	public double getValue(Tetrahedron tetrahedron) {
		return pointExtractant.getValue(tetrahedron).getCoordinateY();
	}
}
