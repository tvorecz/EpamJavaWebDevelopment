package by.training.zorich.storage.accessor.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;

public interface PointFieldTetrahedronAccessor extends TetrahedronFieldAccessor {
	Point extractTetrahedronField(Tetrahedron tetrahedron);
}
