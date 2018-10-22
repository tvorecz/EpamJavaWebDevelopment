package by.training.zorich.action.parser;

import java.util.List;

public interface CoordinatesTetrahedronParser {
	List<double[][]> parseTetrahedronsVertexesCoordinates(List<String> linesWithTetrahedronCoordinates) throws
																										CoordinatesTetrahedronParserExсeption;
}
