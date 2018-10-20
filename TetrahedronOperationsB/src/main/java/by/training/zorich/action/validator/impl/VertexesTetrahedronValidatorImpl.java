package by.training.zorich.action.validator.impl;

import by.training.zorich.action.validator.VertexesTetrahedronValidator;

public class VertexesTetrahedronValidatorImpl implements VertexesTetrahedronValidator {

	//	if two or more vertexes have the same coordinates, tetrahedron doesn't exists
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

	//	check two points do they have the same coordinates
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
