package by.training.zorich.storage.accessor.impl.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.DoubleFieldTetrahedronAccessor;
import by.training.zorich.storage.accessor.impl.PointFieldTetrahedronAccessor;

public class CoordinateYVertexTetrahedronAccessorImpl implements DoubleFieldTetrahedronAccessor {
	PointFieldTetrahedronAccessor pointFieldTetrahedronAccessor;

	public CoordinateYVertexTetrahedronAccessorImpl(PointFieldTetrahedronAccessor pointFieldTetrahedronAccessor) {
		this.pointFieldTetrahedronAccessor = pointFieldTetrahedronAccessor;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return pointFieldTetrahedronAccessor.extractTetrahedronField(tetrahedron).getCoordinateY();
	}
}
