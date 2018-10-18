package by.training.zorich.storage.updater.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.PointFieldTetrahedronAccessor;
import by.training.zorich.storage.updater.CalculateUpdatingValue;

public class TetrahedronXCoordinateUpdaterImpl extends TetrahedronCommonUpdaterImpl {
	PointFieldTetrahedronAccessor pointFieldTetrahedronAccessor;
	double variationValue;
	CalculateUpdatingValue calculateUpdatingValue;

	public TetrahedronXCoordinateUpdaterImpl(PointFieldTetrahedronAccessor pointFieldTetrahedronAccessor, double variationValue, CalculateUpdatingValue calculateUpdatingValue) {
		this.pointFieldTetrahedronAccessor = pointFieldTetrahedronAccessor;
		this.variationValue = variationValue;
		this.calculateUpdatingValue = calculateUpdatingValue;
	}

	@Override
	public void update(Tetrahedron tetrahedron) {
		Point point = pointFieldTetrahedronAccessor.extractTetrahedronField(tetrahedron);
		point.setCoordinateX(calculateUpdatingValue.updatingValue(point.getCoordinateX(), variationValue));
	}
}
