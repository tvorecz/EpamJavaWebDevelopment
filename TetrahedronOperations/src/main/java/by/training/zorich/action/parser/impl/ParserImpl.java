package by.training.zorich.action.parser.impl;

import by.training.zorich.action.parser.Parser;
import by.training.zorich.action.validator.VertexesTetrahedronValidator;
import by.training.zorich.action.validator.impl.VertexesTetrahedronValidatorImpl;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
	private final static String VERTEX_ERROR = "Count of vertexes is incorrect: %s.";
	private final static String POINT_ERROR = "Count of points is incorrect: %s. In vertex: %s.";
	private final static String VERTEXES_SPLITER = "&";
	private final static String POINTS_SPLITER = "\\s+";
	private List<String> tetrahedronsParams;
	private VertexesTetrahedronValidator vertexesTetrahedronValidator;

	public ParserImpl(List<String> tetrahedronsParams) {
		this.tetrahedronsParams = tetrahedronsParams;
		vertexesTetrahedronValidator = new VertexesTetrahedronValidatorImpl();
	}

	@Override
	public List<Double[][]> getTetrahedronsParams() throws ParserException {
		List<Double[][]> result = new ArrayList<Double[][]>();

		for (String tetrahedronData: tetrahedronsParams) {
			Double[][] vertexesTetrahedron = extractTetrahedronVertexes(tetrahedronData);

			if (vertexesTetrahedronValidator.isValid(vertexesTetrahedron)) {
				result.add(vertexesTetrahedron);
			}
		}

		return result;
	}

	private Double[][] extractTetrahedronVertexes(String tetrahedronData) {
		String[] vertexes = tetrahedronData.split(VERTEXES_SPLITER);

		Double[][] vetrexesCoordinates = new Double[4][3];

		for (int i = 0; i < vetrexesCoordinates.length; i++) {
			vetrexesCoordinates[i] = extactVertexCoordinates(vertexes[i]);
		}

		return  vetrexesCoordinates;
	}

	private Double[] extactVertexCoordinates(String vetrexData) {
		String[] points = vetrexData.split(POINTS_SPLITER);

		Double[] coordinates = new Double[3];

		for (int i = 0; i < coordinates.length; i++) {
			coordinates[i] = Double.parseDouble(points[i]);
		}

		return coordinates;
	}
}

