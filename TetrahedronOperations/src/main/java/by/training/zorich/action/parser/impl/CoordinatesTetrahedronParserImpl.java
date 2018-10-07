package by.training.zorich.action.parser.impl;

import by.training.zorich.action.parser.CoordinatesPolyhedronParser;
import by.training.zorich.action.validator.VertexesTetrahedronValidator;
import by.training.zorich.action.validator.impl.VertexesTetrahedronValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesTetrahedronParserImpl implements CoordinatesPolyhedronParser {
	private final static String VERTEXES_SPLITER = "&";
	private final static String POINTS_SPLITER = "\\s+";
	private final static Logger parserlogger = LogManager.getLogger(CoordinatesTetrahedronParserImpl.class);

	private VertexesTetrahedronValidator vertexesTetrahedronValidator;

	public CoordinatesTetrahedronParserImpl() {
		vertexesTetrahedronValidator = new VertexesTetrahedronValidatorImpl();
	}

	@Override
	public List<double[][]> getTetrahedronsCoordinates(List<String> linesWithTetrahedronCoordinates) throws CoordinatesTetrahedronParserExсeption{
		List<double[][]> tetrahedronsCoordinates = new ArrayList<>();

		for (String tetrahedronData: linesWithTetrahedronCoordinates) {

			try {
				double[][] vertexesTetrahedron = extractTetrahedronVertexes(tetrahedronData);

				if (vertexesTetrahedronValidator.isValid(vertexesTetrahedron)) {
					tetrahedronsCoordinates.add(vertexesTetrahedron);
				}
			} catch (NumberFormatException ex) {
				parserlogger.error(ex.getStackTrace().toString());
				throw new CoordinatesTetrahedronParserExсeption("Converting String to Double is faild!", ex);
			}
		}

		return tetrahedronsCoordinates;
	}

	private double[][] extractTetrahedronVertexes(String tetrahedronData) throws NumberFormatException{
		String[] vertexes = tetrahedronData.split(VERTEXES_SPLITER);

		double[][] vetrexesCoordinates = new double[4][3];

		for (int i = 0; i < vetrexesCoordinates.length; i++) {
			vetrexesCoordinates[i] = extactVertexCoordinates(vertexes[i]);
		}

		return  vetrexesCoordinates;
	}

	private double[] extactVertexCoordinates(String vetrexData) throws NumberFormatException{
		String[] points = vetrexData.split(POINTS_SPLITER);

		double[] coordinates = new double[3];

		for (int i = 0; i < coordinates.length; i++) {
			coordinates[i] = Double.parseDouble(points[i]);
		}

		return coordinates;
	}
}

