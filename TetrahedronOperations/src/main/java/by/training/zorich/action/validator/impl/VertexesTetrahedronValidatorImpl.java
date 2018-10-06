package by.training.zorich.action.validator.impl;

import by.training.zorich.action.validator.VertexesTetrahedronValidator;

public class VertexesTetrahedronValidatorImpl implements VertexesTetrahedronValidator {

	//	метод проверяет, нет ли одинаковых точек в наборе
	//	если хотя бы две точки совпадают, то тетраэдр построить нельзя
	@Override
	public boolean isValid(Double[][] tetrahedronVertexesCoordinates) {
		boolean result = true;

		for (int i = 0; i < 3; i++) {
			for (int j = i; j < 4; j++) {
				if (isEqualPoints(tetrahedronVertexesCoordinates[i], tetrahedronVertexesCoordinates[j])) {
					return false;
				}
			}
		}

		return true;
	}

	//	проверка двух точек на совпадение координат
	private boolean isEqualPoints(Double[] firstPoint, Double[] secondPoint) {
		for (int i = 0; i < firstPoint.length; i++) {
			if (firstPoint[i].equals(secondPoint[i])) {
				return true;
			}
		}

		return false;
	}
}
