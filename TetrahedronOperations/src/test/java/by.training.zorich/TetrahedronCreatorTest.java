package by.training.zorich;

import by.training.zorich.action.creator.impl.TetrahedronCreatorException;
import by.training.zorich.action.creator.impl.TetrahedronCreatorImpl;
import by.training.zorich.action.parser.impl.CoordinatesTetrahedronParserImpl;
import by.training.zorich.action.reader.impl.TextFileReaderImpl;
import by.training.zorich.domain.Polyhedron;
import by.training.zorich.domain.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronCreatorTest {
	@Test
	public void testCreatePolyherdons() throws TetrahedronCreatorException {
		String uri = "repository/testData.txt";

		TetrahedronCreatorImpl tetrahedronCreator = new TetrahedronCreatorImpl(new TextFileReaderImpl(), new CoordinatesTetrahedronParserImpl(), uri);

		List<Polyhedron> expected = new ArrayList<>();

		double[][] firstCoordinates = {{2, -1, 2}, {2, 1, 3}, {1, 0, 1}, {6, 4, 5}};

		double[][] secondCoordinates = {{1, 3, 6}, {2, 2, 1}, {-1, 0, 1}, {-4, 6, -3}};

		Tetrahedron firstTetrahedron = new Tetrahedron(firstCoordinates);

		Tetrahedron secondTetragedron = new Tetrahedron(secondCoordinates);

		expected.add(firstTetrahedron);
		expected.add(secondTetragedron);

		List<Polyhedron> actual = tetrahedronCreator.createPolyherdons();

		Assert.assertEquals(actual, expected);
	}
}
