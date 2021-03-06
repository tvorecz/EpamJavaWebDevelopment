package by.training.zorich.storage.accessor.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.PointFieldTetrahedronAccessor;

public class VertexATetrahedronTetrahedronAccessorImpl implements PointFieldTetrahedronAccessor {
	@Override
	public Point extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedron.getVertexA();
	}
}
