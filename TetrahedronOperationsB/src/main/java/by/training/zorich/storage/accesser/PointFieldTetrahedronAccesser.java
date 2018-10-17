package by.training.zorich.storage.accesser;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;

public interface PointFieldTetrahedronAccesser extends TetrahedronFieldAccesser {
	Point extractTetrahedronField(Tetrahedron tetrahedron);
}
