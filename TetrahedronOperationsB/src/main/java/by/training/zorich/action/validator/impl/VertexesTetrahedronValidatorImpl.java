package by.training.zorich.action.validator.impl;

import by.training.zorich.action.validator.VertexesTetrahedronValidator;

public class VertexesTetrahedronValidatorImpl implements VertexesTetrahedronValidator {

	//	метод проверяет, нет ли одинаковых точек в наборе
	//	если хотя бы две точки совпадают, то тетраэдр построить нельзя
	@Override
	public boolean isValid(double[][] tetrahedronVertexesCoordinates) {
		boolean result = true;

		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 4; j++) {
				if (isEqualPoints(tetrahedronVertexesCoordinates[i], tetrahedronVertexesCoordinates[j])) {
					return false;
				}
			}
		}

		return true;
	}

	//	проверка двух точек на совпадение координат
	private boolean isEqualPoints(double[] firstPointCoordinates, double[] secondPointCoordinates) {
		int countOfMatches = 0;

		for (int i = 0; i < firstPointCoordinates.length; i++) {
			if (firstPointCoordinates[i] == secondPointCoordinates[i]) {
				countOfMatches++;
			}
		}

		if (countOfMatches == 3) {
			return true;
		}

		return false;
	}
}
