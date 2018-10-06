package by.training.zorich.action.executor.impl;

import by.training.zorich.action.executor.TetrahedronExecutor;
import by.training.zorich.domain.CoordinatePlane;
import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;

public class TetrahedronExecutorImpl implements TetrahedronExecutor {
	@Override
	public double totalSquare(Tetrahedron tetrahedron) {
		double firstFace = calculateSquareTetrahedronFace(tetrahedron.getVertexD(), tetrahedron.getVertexA(), tetrahedron.getVertexB());
		double secondFace = calculateSquareTetrahedronFace(tetrahedron.getVertexD(), tetrahedron.getVertexA(), tetrahedron.getVertexC());
		double thirdFace = calculateSquareTetrahedronFace(tetrahedron.getVertexD(), tetrahedron.getVertexB(), tetrahedron.getVertexC());
		double fourthFace = calculateSquareTetrahedronFace(tetrahedron.getVertexA(), tetrahedron.getVertexB(), tetrahedron.getVertexC());

		double square = firstFace + secondFace + thirdFace + fourthFace;

		return square;
	}

	@Override
	public double volume(Tetrahedron tetrahedron) {
		Double[][] vectorsMatrix = calculateVectorsMatrix(tetrahedron);
		double scalarTripleProduct = calculateScalarTripleProduct(vectorsMatrix);
		double volumeTetrahedron = 1 / 6 * Math.abs(scalarTripleProduct);

		return volumeTetrahedron;
	}

	@Override
	public double ratioDimensions(Tetrahedron tetrahedron, CoordinatePlane coordinatePlane) {
		return 0;
	}

	@Override
	public boolean isRegularTetrahedron(Tetrahedron tetrahedron) {
		return false;
	}

	@Override
	public boolean isBaseOnCoordinatePlane(Tetrahedron tetrahedron) {
		for (int i = 0; i < 3; i++) {
			if(tetrahedron.getVertexA().)
		}

		return false;
	}

	/*для нахождения объема*/
	private Double[][] calculateVectorsMatrix(Tetrahedron tetrahedron) {
		Double[][] vectorsMatrix = new Double[3][3];

		vectorsMatrix[0] = calculateVectorCoodinates(tetrahedron.getVertexA(), tetrahedron.getVertexB());
		vectorsMatrix[1] = calculateVectorCoodinates(tetrahedron.getVertexA(), tetrahedron.getVertexC());
		vectorsMatrix[2] = calculateVectorCoodinates(tetrahedron.getVertexA(), tetrahedron.getVertexD());

		return vectorsMatrix;
	}

	private Double[] calculateVectorCoodinates(Point firstPoint, Point secondPoint) {
		Double[] vectorCoodinates = new Double[3];

		vectorCoodinates[0] = secondPoint.getCoordinateX() - firstPoint.getCoordinateX();
		vectorCoodinates[1] = secondPoint.getCoordinateY() - secondPoint.getCoordinateY();
		vectorCoodinates[2] = secondPoint.getCoordinateZ() - secondPoint.getCoordinateZ();

		return vectorCoodinates;
	}

	private Double calculateScalarTripleProduct(Double[][] vectorsMatrix) {
		Double scalarTripleProduct = vectorsMatrix[0][0] * vectorsMatrix[1][1] * vectorsMatrix[2][2] - vectorsMatrix[0][0] * vectorsMatrix[1][2] * vectorsMatrix[2][1] - vectorsMatrix[0][1] * vectorsMatrix[1][0] * vectorsMatrix[2][2] + vectorsMatrix[0][1] * vectorsMatrix[1][2] * vectorsMatrix[2][0] + vectorsMatrix[0][2] * vectorsMatrix[1][0] * vectorsMatrix[2][1] - vectorsMatrix[0][2] * vectorsMatrix[1][1] * vectorsMatrix[2][0];

		return scalarTripleProduct;
	}

	/*для нахождения площади*/

	private Double calculateSquareTetrahedronFace(Point startPoint, Point firstPoint, Point secondPoint) {
		Double squareTetrahedronFace = 0.0;

		Double[][] vectorMatrix = new Double[2][3];

		vectorMatrix[0] = calculateVectorCoodinates(startPoint, firstPoint);
		vectorMatrix[1] = calculateVectorCoodinates(startPoint, secondPoint);

		Double[] vectorProduct = calculateVectorProduct(vectorMatrix);

		squareTetrahedronFace = 0.5 * calculateScalarVector(vectorProduct);

		return squareTetrahedronFace;
	}

	private Double[] calculateVectorProduct(Double[][] vectorsMatrix) {
		Double[] vectorProduct = new Double[3];

		vectorProduct[0] = vectorsMatrix[0][1] * vectorsMatrix[1][2] - vectorsMatrix[1][1] * vectorsMatrix[0][2];
		vectorProduct[1] = vectorsMatrix[0][0] * vectorsMatrix[1][2] - vectorsMatrix[1][0] * vectorsMatrix[0][2];
		vectorProduct[2] = vectorsMatrix[0][0] * vectorsMatrix[1][1] - vectorsMatrix[1][0] * vectorsMatrix[0][1];

		return vectorProduct;
	}

	private Double calculateScalarVector(Double[] vector) {
		Double scalarVector = Math.sqrt(Math.pow(vector[0], 2.0) + Math.pow(vector[1], 2.0) + Math.pow(vector[2], 2.0));
		return scalarVector;
	}

	/*для проверки основания фигуры*/

	private boolean isThreePointsHasZero(Double[][] matrixCoodninates) {
		for (int i = 0; i < matrixCoodninates[0].length; i++) {
			if(matrixCoodninates[0][i] == 0) {
				boolean checkStop = false;
				int countZero = 1;
				int countCheck = 0;

				for (int j = 1; j < matrixCoodninates.length; j++) {
					if()

				}
			}
		}
	}

	private Double[][] createMatrixCoordinates(Point... points) {
		Double[][] matrixCoordinates = new Double[4][3];

		for (int i = 0; i < 4; i++) {
			matrixCoordinates[i] = createArrayCoordinates(points[i]);
		}

		return matrixCoordinates;
	}

	private Double[] createArrayCoordinates(Point point) {
		Double[] coordinates = new Double[3];

		coordinates[0] = point.getCoordinateX();
		coordinates[1] = point.getCoordinateY();
		coordinates[2] = point.getCoordinateZ();

		return coordinates;
	}


}
