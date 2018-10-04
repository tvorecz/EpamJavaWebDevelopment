package by.training.zorich.action.parser.impl;

import by.training.zorich.action.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
	private final static String VERTEX_ERROR = "Count of vertexes is incorrect: %s.";
	private final static String POINT_ERROR = "Count of points is incorrect: %s. In vertex: %s.";
	private final static String VERTEXES_SPLITER = "&";
	private final static String POINTS_SPLITER = "\\s+";
	private List<String> tetrahedronsParams;

	public ParserImpl(List<String> tetrahedronsParams) {
		this.tetrahedronsParams = tetrahedronsParams;
	}

	@Override
	public List<Double[][]> getTetrahedronsParams() throws ParserException {
		List<Double[][]> result = new ArrayList<Double[][]>();

		for (String tetrahedronData: tetrahedronsParams) {
			String[] vertexes = tetrahedronData.split(VERTEXES_SPLITER);

			if(vertexes.length != 4) {
				throw new ParserException(String.format(VERTEX_ERROR, tetrahedronData));
			}

			Double[][] params = new Double[4][];

			int i = 0;
			for (String vertex:	vertexes) {
				String[] points = vertex.split(POINTS_SPLITER);

				if(points.length != 3) {
					throw new ParserException(String.format(POINT_ERROR, vertex, tetrahedronData));
				}

				params[i] = new Double[3];
				int j = 0;
				for (String coordinate:
					 points) {
					params[i][j] = Double.parseDouble(coordinate);
				}
			}

			result.add(params);
		}

		return result;
	}
}

//TODO
//извлечь из строки данные о вершинах
//распарсить вершины в массив чисел-вершин
//провалидировать вершины
//добавить в массив

