package by.training.zorich.storage.extractant.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.extractant.PointFieldTetrahedronExtractant;

public class VertexCTetrahedronTetrahedronExtractantImpl implements PointFieldTetrahedronExtractant {
	@Override
	public Point extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedron.getVertexC();
	}
}
