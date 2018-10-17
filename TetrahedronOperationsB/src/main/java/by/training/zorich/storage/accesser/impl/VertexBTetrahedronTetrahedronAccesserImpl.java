package by.training.zorich.storage.accesser.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accesser.PointFieldTetrahedronAccesser;

public class VertexBTetrahedronTetrahedronAccesserImpl implements PointFieldTetrahedronAccesser {
	@Override
	public Point extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedron.getVertexB();
	}
}
