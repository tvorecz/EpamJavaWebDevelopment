package by.training.zorich.storage.accessor.impl.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.DoubleFieldTetrahedronAccessor;
import by.training.zorich.storage.accessor.impl.PointFieldTetrahedronAccessor;

public class CoordinateXVertexTetrahedronAccessorImpl implements DoubleFieldTetrahedronAccessor {
	PointFieldTetrahedronAccessor pointFieldTetrahedronAccessor;

	public CoordinateXVertexTetrahedronAccessorImpl(PointFieldTetrahedronAccessor pointFieldTetrahedronAccesser) {
		this.pointFieldTetrahedronAccessor = pointFieldTetrahedronAccesser;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return pointFieldTetrahedronAccessor.extractTetrahedronField(tetrahedron).getCoordinateX();
	}
}
