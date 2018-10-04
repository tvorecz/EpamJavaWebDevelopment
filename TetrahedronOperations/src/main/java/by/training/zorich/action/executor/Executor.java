package by.training.zorich.action.executor;

import by.training.zorich.domain.CoordinatePlane;
import by.training.zorich.domain.RegularTetrahedron;

public interface Executor {
	double totalSquare(RegularTetrahedron regularTetrahedron);
	double volume(RegularTetrahedron regularTetrahedron);
	double ratioDimensions(RegularTetrahedron regularTetrahedron, CoordinatePlane coordinatePlane);
	boolean isTetrahedron(RegularTetrahedron regularTetrahedron);
	boolean isBaseOnCoordinatePlane(RegularTetrahedron regularTetrahedron);
}
