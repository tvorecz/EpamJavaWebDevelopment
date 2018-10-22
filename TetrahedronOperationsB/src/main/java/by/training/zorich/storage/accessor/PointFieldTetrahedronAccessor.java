package by.training.zorich.storage.accessor;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;

public interface PointFieldTetrahedronAccessor extends TetrahedronFieldAccessor {
	Point extractTetrahedronField(Tetrahedron tetrahedron);
}
