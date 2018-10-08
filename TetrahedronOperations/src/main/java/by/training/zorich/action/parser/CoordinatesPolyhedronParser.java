package by.training.zorich.action.parser;

import by.training.zorich.action.parser.impl.CoordinatesTetrahedronParserExсeption;
import by.training.zorich.domain.Polyhedron;

import java.util.List;

public interface CoordinatesPolyhedronParser {
	List<double[][]> parseTetrahedronsVertexesCoordinates(List<String> linesWithTetrahedronCoordinates) throws CoordinatesTetrahedronParserExсeption;
}
