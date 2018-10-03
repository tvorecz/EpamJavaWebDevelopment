package by.training.zorich.action.executor;

import by.training.zorich.domain.CoordinatePlane;
import by.training.zorich.domain.Tetrahedron;

public interface Executor {
	double totalSquare(Tetrahedron tetrahedron);
	double volume(Tetrahedron tetrahedron);
	double ratioDimensions(Tetrahedron tetrahedron, CoordinatePlane coordinatePlane);
	boolean isTetrahedron(Tetrahedron tetrahedron);
	boolean isBaseOnCoordinatePlane(Tetrahedron tetrahedron);
}
