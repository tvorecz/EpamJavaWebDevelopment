package by.training.zorich.action.executor;

import by.training.zorich.domain.CuttingCoordinatePlane;
import by.training.zorich.domain.Tetrahedron;

public interface TetrahedronExecutor {
	double totalSquare(Tetrahedron tetrahedron);
	double volume(Tetrahedron tetrahedron);
	double[] ratioDimensions(Tetrahedron tetrahedron, CuttingCoordinatePlane cuttingCoordinatePlane);
	boolean isRegularTetrahedron(Tetrahedron tetrahedron);
	boolean isBaseOnCoordinatePlane(Tetrahedron tetrahedron);
}
