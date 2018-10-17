package by.training.zorich.storage.accesser.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accesser.DoubleFieldTetrahedronAccesser;
import by.training.zorich.storage.accesser.PointFieldTetrahedronAccesser;

public class CoordinateYVertexTetrahedronAccesserImpl implements DoubleFieldTetrahedronAccesser {
	PointFieldTetrahedronAccesser pointFieldTetrahedronAccesser;

	public CoordinateYVertexTetrahedronAccesserImpl(PointFieldTetrahedronAccesser pointFieldTetrahedronAccesser) {
		this.pointFieldTetrahedronAccesser = pointFieldTetrahedronAccesser;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return pointFieldTetrahedronAccesser.extractTetrahedronField(tetrahedron).getCoordinateY();
	}
}
