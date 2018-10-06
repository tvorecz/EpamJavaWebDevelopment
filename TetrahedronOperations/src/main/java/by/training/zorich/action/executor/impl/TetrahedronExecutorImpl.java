package by.training.zorich.action.executor.impl;

import by.training.zorich.action.executor.TetrahedronExecutor;
import by.training.zorich.domain.CuttingCoordinatePlane;
import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.domain.TetrahedronEdge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public double[] ratioDimensions(Tetrahedron tetrahedron, CuttingCoordinatePlane cuttingCoordinatePlane) {
		//создать грани тетраэдра
		Map<Edge, TetrahedronEdge> edges = getTetrahedronEdges(tetrahedron);

		//для удобства перебора создает список точек пересечения
		List<Point> pointsOfPlane = createPointsOfPlate(cuttingCoordinatePlane);

		//определить, на каких гранях находятся пересечения с плоскостями
		Map<Point, TetrahedronEdge> intersectionsAndEdges = getIntersectionsAndEdges(edges, pointsOfPlane);

		//определить общую вершину образованного секущей плоскостью тетраэдра
		Point vertex = getVertexOfNewTetrahedron(intersectionsAndEdges);

		Tetrahedron newTetrahedron = new Tetrahedron(cuttingCoordinatePlane.getIntersectionPointA(), cuttingCoordinatePlane.getIntersectionPointB(), cuttingCoordinatePlane.getIntersectionPointC(), vertex);

		double newTetrahedronVolume = volume(newTetrahedron);
		double tetrahedronVolume = volume(tetrahedron);
		double polyhedronVolume = tetrahedronVolume - newTetrahedronVolume;

		double[] ratio = new double[2];
		ratio[0] = newTetrahedronVolume / polyhedronVolume;
		ratio[1]= polyhedronVolume / newTetrahedronVolume;

		return ratio;
	}

	@Override
	public boolean isRegularTetrahedron(Tetrahedron tetrahedron) {
		List<TetrahedronEdge> tetrahedronEdges = getTetrahedronEdgesAsList(tetrahedron);

		Double[] vectorCoodinates = calculateVectorCoodinates(tetrahedronEdges.get(0).getPointA(), tetrahedronEdges.get(0).getPointB());

		double firstEdge = calculateScalarVector(vectorCoodinates);

		for (int i = 1; i < tetrahedronEdges.size(); i++) {
			vectorCoodinates = calculateVectorCoodinates(tetrahedronEdges.get(0).getPointA(), tetrahedronEdges.get(0).getPointB());

			double otherEdge = calculateScalarVector(vectorCoodinates);

			if(firstEdge != otherEdge)
				return false;
		}

		return true;
	}

	@Override
	public boolean isBaseOnCoordinatePlane(Tetrahedron tetrahedron) {
		Double[][] matrixCoordinates = createMatrixCoordinates(tetrahedron.getVertexA(), tetrahedron.getVertexB(), tetrahedron.getVertexC(), tetrahedron.getVertexD());

		return hasThreePointsZero(matrixCoordinates);
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

	//TODO: это модуль вектора (длина его отрезка), а не скалярное произведение
	private Double calculateScalarVector(Double[] vector) {
		Double scalarVector = Math.sqrt(Math.pow(vector[0], 2.0) + Math.pow(vector[1], 2.0) + Math.pow(vector[2], 2.0));
		return scalarVector;
	}

	/*для проверки основания фигуры*/

	private boolean hasThreePointsZero(Double[][] matrixCoodninates) {
		for (int i = 0; i < matrixCoodninates[0].length; i++) {
			boolean checkStop = false;
			int countZero = 0;

			for (int j = 0; j < matrixCoodninates.length; j++) {
				if (matrixCoodninates[j][i] == 0) {
					countZero++;
				}
			}

			if (countZero == 3) {
				return true;
			}
		}

		return false;
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

	/*Для определения объема фигур, получающихся при рассечении тетраэдра*/

	private boolean isPointOnTheEdge(Point point, TetrahedronEdge tetrahedronEdge) {
		boolean onEdge = false;

		double firstResult = calculateEquationOfLine(point.getCoordinateX(), tetrahedronEdge.getPointA().getCoordinateX(), tetrahedronEdge.getPointB().getCoordinateX());
		double secondResult = calculateEquationOfLine(point.getCoordinateY(), tetrahedronEdge.getPointA().getCoordinateY(), tetrahedronEdge.getPointB().getCoordinateY());
		double thirdResult = calculateEquationOfLine(point.getCoordinateZ(), tetrahedronEdge.getPointA().getCoordinateZ(), tetrahedronEdge.getPointB().getCoordinateZ());

		onEdge = ((firstResult == secondResult) && (firstResult == thirdResult));

		return onEdge;
	}

	//	уравнение прямой
	private double calculateEquationOfLine(double checkCoordinate, double firstCoordinate, double secondCoordinate) {
		//		TODO: проверить на ноль в делителе
		double result = (checkCoordinate - firstCoordinate) / (secondCoordinate - firstCoordinate);

		return result;
	}

	private Map<Edge, TetrahedronEdge> getTetrahedronEdges(Tetrahedron tetrahedron) {
		Map<Edge, TetrahedronEdge> edges = new HashMap<Edge, TetrahedronEdge>();

		edges.put(Edge.AB, new TetrahedronEdge(tetrahedron.getVertexA(), tetrahedron.getVertexB()));
		edges.put(Edge.AC, new TetrahedronEdge(tetrahedron.getVertexA(), tetrahedron.getVertexC()));
		edges.put(Edge.AD, new TetrahedronEdge(tetrahedron.getVertexA(), tetrahedron.getVertexD()));
		edges.put(Edge.BC, new TetrahedronEdge(tetrahedron.getVertexB(), tetrahedron.getVertexC()));
		edges.put(Edge.BD, new TetrahedronEdge(tetrahedron.getVertexB(), tetrahedron.getVertexD()));
		edges.put(Edge.CD, new TetrahedronEdge(tetrahedron.getVertexC(), tetrahedron.getVertexD()));

		return edges;
	}

	private List<TetrahedronEdge> getTetrahedronEdgesAsList(Tetrahedron tetrahedron) {
		List<TetrahedronEdge> edges = new ArrayList<TetrahedronEdge>();

		edges.add(new TetrahedronEdge(tetrahedron.getVertexA(), tetrahedron.getVertexB()));
		edges.add(new TetrahedronEdge(tetrahedron.getVertexA(), tetrahedron.getVertexC()));
		edges.add(new TetrahedronEdge(tetrahedron.getVertexA(), tetrahedron.getVertexD()));
		edges.add(new TetrahedronEdge(tetrahedron.getVertexB(), tetrahedron.getVertexC()));
		edges.add(new TetrahedronEdge(tetrahedron.getVertexB(), tetrahedron.getVertexD()));
		edges.add(new TetrahedronEdge(tetrahedron.getVertexC(), tetrahedron.getVertexD()));

		return edges;
	}

	//найти на каких гранях лежат точки пересекающей плоскости
	private Map<Point, TetrahedronEdge> getIntersectionsAndEdges(Map<Edge, TetrahedronEdge> edges, List<Point> pointsOfPlane) {
		Map<Point, TetrahedronEdge> intersectionsAndEdges = new HashMap<Point, TetrahedronEdge>();

		for (Point point : pointsOfPlane) {
			for (Edge edge : Edge.values()) {
				if (isPointOnTheEdge(point, intersectionsAndEdges.get(edge))) {
					intersectionsAndEdges.put(point, intersectionsAndEdges.get(edge));
				}
			}
		}

		return intersectionsAndEdges;
	}

	private List<Point> createPointsOfPlate(CuttingCoordinatePlane cuttingCoordinatePlane) {
		List<Point> pointsOfPlane = new ArrayList<Point>();

		pointsOfPlane.add(cuttingCoordinatePlane.getIntersectionPointA());
		pointsOfPlane.add(cuttingCoordinatePlane.getIntersectionPointB());
		pointsOfPlane.add(cuttingCoordinatePlane.getIntersectionPointC());

		return pointsOfPlane;
	}

	//находит вершину тетраэдра, образованного пересекающей плоскостью
	private Point getVertexOfNewTetrahedron(Map<Point, TetrahedronEdge> intersectionsAndEdges) {
		List<Point> points = createListOfPoints(intersectionsAndEdges);

		Point vertex = null;

		for (int i = 0; i < points.size() - 1; i++) {
			int count = 0;
			vertex = points.get(0);

			for (int j = i + 1; j < points.size(); j++) {
				Point nextVertex = points.get(j);

				if(vertex.equals(nextVertex)) {
					count++;
				}
			}

			if(count == 2) {
				break;
			}
		}

		return vertex;
	}

	private List<Point> createListOfPoints(Map<Point, TetrahedronEdge> intersectionsAndEdges) {
		List<Point> points = new ArrayList<Point>();

		for (TetrahedronEdge tetrahedronEdge : intersectionsAndEdges.values()) {
			points.add(tetrahedronEdge.getPointA());
			points.add(tetrahedronEdge.getPointB());
		}

		return points;
	}
}
