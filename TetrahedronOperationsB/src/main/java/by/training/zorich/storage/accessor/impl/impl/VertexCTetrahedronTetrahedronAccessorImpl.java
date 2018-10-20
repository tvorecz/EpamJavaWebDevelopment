package by.training.zorich.storage.accessor.impl.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.PointFieldTetrahedronAccessor;

public class VertexCTetrahedronTetrahedronAccessorImpl implements PointFieldTetrahedronAccessor {
	@Override
	public Point extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedron.getVertexC();
	}
}
