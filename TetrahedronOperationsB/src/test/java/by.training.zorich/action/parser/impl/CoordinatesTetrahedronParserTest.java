package by.training.zorich.action.parser.impl;

import by.training.zorich.action.parser.CoordinatesTetrahedronParserExсeption;
import by.training.zorich.action.parser.impl.CoordinatesTetrahedronParserImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesTetrahedronParserTest {
	private final static String FIRST = "2 -1 2&2 1 3&1 0 1&6 4 5";
	private final static String SECOND = "1 3 6&2 2 1&-1                0 1&-4 6 -3";

	@Test
	public void testCoordinatesTetrahedronParser() throws CoordinatesTetrahedronParserExсeption {
		//TODO
		CoordinatesTetrahedronParserImpl coordinatesTetrahedronParser = new CoordinatesTetrahedronParserImpl();

		List<String> forTest = new ArrayList<>();
		forTest.add(FIRST);
		forTest.add(SECOND);

		List<double[][]> expected = new ArrayList<>();

		double[][] firstDoubleForTest = {{2.0, -1.0, 2.0}, {2.0, 1.0, 3.0}, {1.0, 0.0, 1.0}, {6.0, 4.0, 5.0}};
		expected.add(firstDoubleForTest);

		double[][] secondDoubleForTest = {{1.0, 3.0, 6.0}, {2.0, 2.0, 1.0}, {-1.0, 0.0, 1.0}, {-4.0, 6.0, -3.0}};
		expected.add(secondDoubleForTest);

		List<double[][]> actual = coordinatesTetrahedronParser.parseTetrahedronsVertexesCoordinates(forTest);

		Assert.assertEquals(actual.toArray(), expected.toArray());
	}
}
