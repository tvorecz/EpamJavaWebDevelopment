package by.training.zorich.action.creator.impl;

import by.training.zorich.action.parser.impl.CoordinatesTetrahedronParserImpl;
import by.training.zorich.action.reader.impl.TextFileReaderImpl;
import by.training.zorich.domain.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TetrahedronCreatorTest {
	private static String uri;

	@BeforeTest
	public void createPath() {
//		uri = TetrahedronCreatorImpl.class.getClassLoader().getResource("testData.txt").getPath();
		uri = "C:\\Users\\tvore\\Documents\\EpamJavaWebDevelopment\\TetrahedronOperationsB\\target\\test-classes\\testData.txt";
	}

	@Test
	public void testCreatePolyherdons() {
		TetrahedronCreatorImpl tetrahedronCreator = new TetrahedronCreatorImpl(new TextFileReaderImpl(), new CoordinatesTetrahedronParserImpl(), uri);

		List<Tetrahedron> expected = new ArrayList<>();

		double[][] firstCoordinates = {{2, -1, 2}, {2, 1, 3}, {1, 0, 1}, {6, 4, 5}};

		double[][] secondCoordinates = {{1, 3, 6}, {2, 2, 1}, {-1, 0, 1}, {-4, 6, -3}};

		Tetrahedron firstTetrahedron = new Tetrahedron(firstCoordinates);

		Tetrahedron secondTetragedron = new Tetrahedron(secondCoordinates);

		expected.add(firstTetrahedron);
		expected.add(secondTetragedron);

		List<Tetrahedron> actual = tetrahedronCreator.createTetraherdons();

		Assert.assertEquals(actual, expected);
	}
}
