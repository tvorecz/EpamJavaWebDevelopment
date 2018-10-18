package by.training.zorich.storage.accessor.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.DoubleFieldTetrahedronAccessor;
import by.training.zorich.storage.accessor.PointFieldTetrahedronAccessor;

public class CoordinateYVertexTetrahedronAccessorImpl implements DoubleFieldTetrahedronAccessor {
	PointFieldTetrahedronAccessor pointFieldTetrahedronAccesser;

	public CoordinateYVertexTetrahedronAccessorImpl(PointFieldTetrahedronAccessor pointFieldTetrahedronAccesser) {
		this.pointFieldTetrahedronAccesser = pointFieldTetrahedronAccesser;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return pointFieldTetrahedronAccesser.extractTetrahedronField(tetrahedron).getCoordinateY();
	}
}
