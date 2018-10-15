package by.training.zorich.storage.extractant.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.extractant.PointExtractant;

public class VertexBTetrahedronExtractant implements PointExtractant {
	@Override
	public Point getValue(Tetrahedron tetrahedron) {
		return tetrahedron.getVertexB();
	}
}
