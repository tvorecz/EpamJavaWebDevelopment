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
	public double calculateTotalSquare(Tetrahedron tetrahedron) {
		double firstFace = calculateTriangleSquare(tetrahedron.getVertexD(), tetrahedron.getVertexA(), tetrahedron.getVertexB());
		double secondFace = calculateTriangleSquare(tetrahedron.getVertexD(), tetrahedron.getVertexA(), tetrahedron.getVertexC());
		double thirdFace = calculateTriangleSquare(tetrahedron.getVertexD(), tetrahedron.getVertexB(), tetrahedron.getVertexC());
		double fourthFace = calculateTriangleSquare(tetrahedron.getVertexA(), tetrahedron.getVertexB(), tetrahedron.getVertexC());

		double square = firstFace + secondFace + thirdFace + fourthFace;

		return square;
	}

	@Override
	public double calculateVolume(Tetrahedron tetrahedron) {
		double[][] vectorsMatrix = calculateVectorsMatrix(tetrahedron);

		double scalarTripleProduct = calculateScalarTripleProduct(vectorsMatrix);

		double volumeTetrahedron = (Math.abs(scalarTripleProduct)) * (1.0 / 6.0);

		return volumeTetrahedron;
	}

	@Override
	public double[] calculateRatiosOfVolumes(Tetrahedron tetrahedron, CuttingCoordinatePlane cuttingCoordinatePlane) {
		//создать грани тетраэдра
		Map<Edge, TetrahedronEdge> edges = createTetrahedronEdgesAsMap(tetrahedron);

		//для удобства перебора создает список точек пересечения
		List<Point> intersectionPoints = createListOfIntersectionPoints(cuttingCoordinatePlane);

		//определить, на каких гранях находятся пересечения с плоскостями
		Map<Point, TetrahedronEdge> intersectionsAndEdges = getIntersectionsAndEdges(edges, intersectionPoints);

		//определить общую вершину образованного секущей плоскостью тетраэдра
		Point vertex = getVertexOfNewTetrahedron(intersectionsAndEdges);

		Tetrahedron newTetrahedron = new Tetrahedron(cuttingCoordinatePlane.getIntersectionPointA(), cuttingCoordinatePlane.getIntersectionPointB(), cuttingCoordinatePlane.getIntersectionPointC(), vertex);

		double newTetrahedronVolume = calculateVolume(newTetrahedron);
		double tetrahedronVolume = calculateVolume(tetrahedron);
		double polyhedronVolume = tetrahedronVolume - newTetrahedronVolume;

		double[] ratio = new double[2];
		ratio[0] = newTetrahedronVolume / polyhedronVolume;
		ratio[1]= polyhedronVolume / newTetrahedronVolume;

		return ratio;
	}

	@Override
	public boolean isRegularTetrahedron(Tetrahedron tetrahedron) {
		List<TetrahedronEdge> tetrahedronEdges = createTetrahedronEdgesAsList(tetrahedron);

		double[] vectorCoodinates = calculateVectorCoodinates(tetrahedronEdges.get(0).getPointA(), tetrahedronEdges.get(0).getPointB());

		double firstEdge = calculateModulusOfVector(vectorCoodinates);

		for (int i = 1; i < tetrahedronEdges.size(); i++) {
			vectorCoodinates = calculateVectorCoodinates(tetrahedronEdges.get(0).getPointA(), tetrahedronEdges.get(0).getPointB());

			double otherEdge = calculateModulusOfVector(vectorCoodinates);

			//если длина двух граней не совпадает
			if(firstEdge != otherEdge)
				return false;
		}

		return true;
	}

	@Override
	public boolean isBaseOnCoordinatePlane(Tetrahedron tetrahedron) {
		double[][] matrixCoordinates = createMatrixCoordinates(tetrahedron.getVertexA(), tetrahedron.getVertexB(), tetrahedron.getVertexC(), tetrahedron.getVertexD());

		return hasThreePointsZero(matrixCoordinates);
	}

	/*для нахождения площади*/

	//находит площадь одной грани
	private double calculateTriangleSquare(Point startPoint, Point firstPoint, Point secondPoint) {
		double triangleSquare = 0.0;

		double[][] vectorMatrix = new double[2][3];

		vectorMatrix[0] = calculateVectorCoodinates(startPoint, firstPoint);
		vectorMatrix[1] = calculateVectorCoodinates(startPoint, secondPoint);

		double[] vectorProduct = calculateVectorProduct(vectorMatrix);

		triangleSquare = 0.5 * calculateModulusOfVector(vectorProduct);

		return triangleSquare;
	}

	//рассчитывает вектороное произведение
	private double[] calculateVectorProduct(double[][] vectorsMatrix) {
		double[] vectorProduct = new double[3];

		vectorProduct[0] = vectorsMatrix[0][1] * vectorsMatrix[1][2] - vectorsMatrix[1][1] * vectorsMatrix[0][2];
		vectorProduct[1] = vectorsMatrix[0][0] * vectorsMatrix[1][2] - vectorsMatrix[1][0] * vectorsMatrix[0][2];
		vectorProduct[2] = vectorsMatrix[0][0] * vectorsMatrix[1][1] - vectorsMatrix[1][0] * vectorsMatrix[0][1];

		return vectorProduct;
	}

	//находит модуль вектора (длина его отрезка)
	private double calculateModulusOfVector(double[] vector) {
		double scalarVector = Math.sqrt(Math.pow(vector[0], 2.0) + Math.pow(vector[1], 2.0) + Math.pow(vector[2], 2.0));
		return scalarVector;
	}

	/*для нахождения объема*/
	//создает матрицу векторов из одной вершины тетраэдра
	private double[][] calculateVectorsMatrix(Tetrahedron tetrahedron) {
		double[][] vectorsMatrix = new double[3][3];

		vectorsMatrix[0] = calculateVectorCoodinates(tetrahedron.getVertexA(), tetrahedron.getVertexB());
		vectorsMatrix[1] = calculateVectorCoodinates(tetrahedron.getVertexA(), tetrahedron.getVertexC());
		vectorsMatrix[2] = calculateVectorCoodinates(tetrahedron.getVertexA(), tetrahedron.getVertexD());

		return vectorsMatrix;
	}

	//нахождение векторов по координатам вершин
	private double[] calculateVectorCoodinates(Point firstPoint, Point secondPoint) {
		double[] vectorCoodinates = new double[3];

		vectorCoodinates[0] = secondPoint.getCoordinateX() - firstPoint.getCoordinateX();
		vectorCoodinates[1] = secondPoint.getCoordinateY() - firstPoint.getCoordinateY();
		vectorCoodinates[2] = secondPoint.getCoordinateZ() - firstPoint.getCoordinateZ();

		return vectorCoodinates;
	}

	//смешанное скалярное произведение векторов (равно определителю матрицы этих векторов)
	private double calculateScalarTripleProduct(double[][] vectorsMatrix) {
		double scalarTripleProduct = vectorsMatrix[0][0] * vectorsMatrix[1][1] * vectorsMatrix[2][2] - vectorsMatrix[0][0] * vectorsMatrix[1][2] * vectorsMatrix[2][1] - vectorsMatrix[0][1] * vectorsMatrix[1][0] * vectorsMatrix[2][2] + vectorsMatrix[0][1] * vectorsMatrix[1][2] * vectorsMatrix[2][0] + vectorsMatrix[0][2] * vectorsMatrix[1][0] * vectorsMatrix[2][1] - vectorsMatrix[0][2] * vectorsMatrix[1][1] * vectorsMatrix[2][0];

		return scalarTripleProduct;
	}

	/*для проверки основания фигуры*/

	private boolean hasThreePointsZero(double[][] matrixCoodninates) {
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

	private double[][] createMatrixCoordinates(Point... points) {
		double[][] matrixCoordinates = new double[4][3];

		for (int i = 0; i < 4; i++) {
			matrixCoordinates[i] = createArrayCoordinates(points[i]);
		}

		return matrixCoordinates;
	}

	private double[] createArrayCoordinates(Point point) {
		double[] coordinates = new double[3];

		coordinates[0] = point.getCoordinateX();
		coordinates[1] = point.getCoordinateY();
		coordinates[2] = point.getCoordinateZ();

		return coordinates;
	}

	/*Для определения объема фигур, получающихся при рассечении тетраэдра*/

	private boolean isPointOnTheEdge(Point point, TetrahedronEdge tetrahedronEdge) {
		double[] vector = calculateVectorCoodinates(tetrahedronEdge.getPointA(), tetrahedronEdge.getPointB());

		int count = calculateCountOfZeroCoordinates(vector);

		double firstResult = calculateEquationOfLine(point.getCoordinateX(), tetrahedronEdge.getPointA().getCoordinateX(), tetrahedronEdge.getPointB().getCoordinateX());
		double secondResult = calculateEquationOfLine(point.getCoordinateY(), tetrahedronEdge.getPointA().getCoordinateY(), tetrahedronEdge.getPointB().getCoordinateY());
		double thirdResult = calculateEquationOfLine(point.getCoordinateZ(), tetrahedronEdge.getPointA().getCoordinateZ(), tetrahedronEdge.getPointB().getCoordinateZ());

		//исключаем ноль в делитете
		if(count == 1) {
			return equationsOfLineWithZero(new double[]{firstResult, secondResult, thirdResult}, vector);
		} else if (count == 2) {
			return equationsOfLineWithTwoZero(new double[]{firstResult, secondResult, thirdResult}, vector);
		} else {
			return classicEquationsOfLine(firstResult, secondResult, thirdResult);
		}
	}

	//проверяем, если ли в координатах вектора нули
	private int calculateCountOfZeroCoordinates(double[] vector) {
		int count = 0;

		for (int i = 0; i < vector.length; i++) {
			if(vector[i] == 0.0)
				count++;
		}

		return count;
	}

	//классическое равенство уравнений прямой (все три уравнения равны)
	private boolean classicEquationsOfLine(double firstResult, double secondResult, double thirdResult) {
		boolean onEdge = false;

		onEdge = ((firstResult == secondResult) && (firstResult == thirdResult));

		return onEdge;
	}

	//уравнение прямой для одного измерения
	private double calculateEquationOfLine(double checkCoordinate, double firstCoordinate, double secondCoordinate) {
		double result = 0;

		if((secondCoordinate - firstCoordinate) != 0)
			result = (checkCoordinate - firstCoordinate) / (secondCoordinate - firstCoordinate);
		else
			result = checkCoordinate - firstCoordinate;

		return result;
	}

	//равенство уравнений прямой при одном нуле в векторе
	private boolean equationsOfLineWithZero(double[] resultsEquationOfLine, double[] vector) {
		boolean onEdge = false;

		boolean firstEquality = false;
		boolean secondEquality = false;

		for (int i = 0; i < vector.length; i++) {
			if(vector[i] == 0.0) {
				secondEquality = resultsEquationOfLine[i] == 0.0;
			}
		}

		for (int i = 0; i < vector.length; i++) {
			if(vector[i] != 0.0) {
				for (int j = i + 1; j < vector.length; j++) {
					if(vector[j] != 0.0) {
						firstEquality = resultsEquationOfLine[i] == resultsEquationOfLine[j];

						break;
					}
				}

				break;
			}
		}

		onEdge = firstEquality && secondEquality;

		return onEdge;
	}

	//равенство уравнений прямой при двух нулях в векторе
	private boolean equationsOfLineWithTwoZero(double[] resultsEquationOfLine, double[] vector) {
		boolean onEdge = false;

		boolean firstEquality = false;
		boolean secondEquality = false;

		for (int i = 0; i < vector.length; i++) {
			if(vector[i] == 0.0) {
				secondEquality = resultsEquationOfLine[i] == 0.0;
				for (int j = i + 1; j < vector.length; j++) {
					if(vector[j] == 0.0) {
						firstEquality = resultsEquationOfLine[j] == 0.0;

						break;
					}
				}

				break;
			}
		}

		onEdge = firstEquality && secondEquality;

		return onEdge;
	}

	private Map<Edge, TetrahedronEdge> createTetrahedronEdgesAsMap(Tetrahedron tetrahedron) {
		Map<Edge, TetrahedronEdge> edges = new HashMap<Edge, TetrahedronEdge>();

		edges.put(Edge.AB, new TetrahedronEdge(tetrahedron.getVertexA(), tetrahedron.getVertexB()));
		edges.put(Edge.AC, new TetrahedronEdge(tetrahedron.getVertexA(), tetrahedron.getVertexC()));
		edges.put(Edge.AD, new TetrahedronEdge(tetrahedron.getVertexA(), tetrahedron.getVertexD()));
		edges.put(Edge.BC, new TetrahedronEdge(tetrahedron.getVertexB(), tetrahedron.getVertexC()));
		edges.put(Edge.BD, new TetrahedronEdge(tetrahedron.getVertexB(), tetrahedron.getVertexD()));
		edges.put(Edge.CD, new TetrahedronEdge(tetrahedron.getVertexC(), tetrahedron.getVertexD()));

		return edges;
	}

	private List<TetrahedronEdge> createTetrahedronEdgesAsList(Tetrahedron tetrahedron) {
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
	private Map<Point, TetrahedronEdge> getIntersectionsAndEdges(Map<Edge, TetrahedronEdge> edges, List<Point> intersectionPoints) {
		Map<Point, TetrahedronEdge> intersectionsAndEdges = new HashMap<Point, TetrahedronEdge>();

		for (Point point : intersectionPoints) {
			for (Edge edge : Edge.values()) {
				if (isPointOnTheEdge(point, edges.get(edge))) {
					intersectionsAndEdges.put(point, intersectionsAndEdges.get(edge));
				}
			}
		}

		return intersectionsAndEdges;
	}

	private List<Point> createListOfIntersectionPoints(CuttingCoordinatePlane cuttingCoordinatePlane) {
		List<Point> intersectionPoints = new ArrayList<Point>();

		intersectionPoints.add(cuttingCoordinatePlane.getIntersectionPointA());
		intersectionPoints.add(cuttingCoordinatePlane.getIntersectionPointB());
		intersectionPoints.add(cuttingCoordinatePlane.getIntersectionPointC());

		return intersectionPoints;
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
