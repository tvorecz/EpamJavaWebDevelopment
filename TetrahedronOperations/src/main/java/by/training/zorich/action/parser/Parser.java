package by.training.zorich.action.parser;

import by.training.zorich.action.parser.impl.ParserException;

import java.util.List;

public interface Parser {
	List<Double[][]> getTetrahedronsParams() throws ParserException;
}
