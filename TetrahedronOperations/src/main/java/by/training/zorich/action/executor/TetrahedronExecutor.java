package by.training.zorich.action.executor;

import by.training.zorich.domain.CuttingCoordinatePlane;
import by.training.zorich.domain.Tetrahedron;

public interface TetrahedronExecutor {
	double calculateTotalSquare(Tetrahedron tetrahedron);
	double calculateVolume(Tetrahedron tetrahedron);
	double[] calculateRatiosOfVolumes(Tetrahedron tetrahedron, CuttingCoordinatePlane cuttingCoordinatePlane);
	boolean isRegularTetrahedron(Tetrahedron tetrahedron);
	boolean isBaseOnCoordinatePlane(Tetrahedron tetrahedron);
}
