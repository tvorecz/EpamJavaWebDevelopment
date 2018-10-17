package by.training.zorich.storage.extractant;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;

public interface PointFieldTetrahedronExtractant extends TetrahedronFieldExtractant {
	Point extractTetrahedronField(Tetrahedron tetrahedron);
}
