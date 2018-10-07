package by.training.zorich;

import by.training.zorich.action.parser.impl.CoordinatesTetrahedronParserExсeption;
import by.training.zorich.action.parser.impl.CoordinatesTetrahedronParserImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CoordinatesTetrahedronParserTest {
	@Test
	public void testCoordinatesTetrahedronParser() throws CoordinatesTetrahedronParserExсeption{
		CoordinatesTetrahedronParserImpl coordinatesTetrahedronParser = new CoordinatesTetrahedronParserImpl();

		List<String> forTest = new ArrayList<>();
		forTest.add("2 -1 2&2 1 3&1 0 1&6 4 5");
		forTest.add("1 3 6&2 2 1&-1                0 1&-4 6 -3");

		List<double[][]> expected = new ArrayList<>();

		double[][] firstDoubleForTest = {{2.0, -1.0, 2.0}, {2.0, 1.0, 3.0}, {1.0, 0.0, 1.0}, {6.0, 4.0, 5.0}};
		expected.add(firstDoubleForTest);

		double[][] secondDoubleForTest = {{1.0, 3.0, 6.0}, {2.0, 2.0, 1.0}, {-1.0, 0.0, 1.0}, {-4.0, 6.0, -3.0}};
		expected.add(secondDoubleForTest);

		List<double[][]> actual = coordinatesTetrahedronParser.getTetrahedronsCoordinates(forTest);

		Assert.assertEquals(actual, expected);
	}
}
