package by.training.zorich.storage.register.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.event.EventType;
import by.training.zorich.storage.event.impl.arg.EventArg;
import by.training.zorich.storage.register.impl.impl.TetrahedronRegisterImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TetrahedronRegisterTest {
	private static Tetrahedron tetrahedronFirst;
	private static Tetrahedron tetrahedronSecond;
	private static Tetrahedron tetrahedronThird;
	private static final int tetrahedronId = 1;
	private static final String tetrahedronName = "Tetrahedron # %s";
	private TetrahedronRegisterImpl tetrahedronRegister = TetrahedronRegisterImpl.getInstance();
	private static final Double expectedPerimeter = 26.423675582122574;
	private static final Double expectedTotalSquare = (0.5 * Math.sqrt(1094.0)) + (0.5 * Math.sqrt(430.0)) + (0.5 * Math.sqrt(278.0)) + (0.5 * Math.sqrt(350));
	private static final Double expectedVolume = 11.0 / 6.0;

	@BeforeTest
	public void createTestTetrahedron() {
		tetrahedronFirst = new Tetrahedron(new Point(2, -1, 2),
				new Point(2, 1, 3),
				new Point(1, 0, 1),
				new Point(6, 4, 5));

		tetrahedronFirst.setId(tetrahedronId);
		tetrahedronFirst.setName(String.format(tetrahedronName, tetrahedronId));

		tetrahedronSecond = new Tetrahedron(new Point(0, 4, 5),
				new Point(3, -2, 1),
				new Point(4, 5, 6),
				new Point(3, 3, 2));

		tetrahedronSecond.setId(tetrahedronId + 1);
		tetrahedronSecond.setName(String.format(tetrahedronName, tetrahedronId + 1));

		tetrahedronThird = new Tetrahedron(new Point(2, -1, 2),
				new Point(2, 1, 3),
				new Point(1, 0, 1),
				new Point(6, 4, 5));

		tetrahedronThird.setId(tetrahedronId + 2);
		tetrahedronThird.setName(String.format(tetrahedronName, tetrahedronId + 2));

		tetrahedronRegister.addTetrahedron(new EventArg(tetrahedronFirst, EventType.ADD));
		tetrahedronRegister.addTetrahedron(new EventArg(tetrahedronSecond, EventType.ADD));
		tetrahedronRegister.addTetrahedron(new EventArg(tetrahedronThird, EventType.ADD));
	}

	@Test
	public void perimeterTest() {
		Double actual = tetrahedronRegister.perimeter(tetrahedronFirst.getId());
		Double expected = expectedPerimeter;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void totalSquareTest() {
		Double actual = tetrahedronRegister.totalSquare(tetrahedronSecond.getId());
		Double expected = expectedTotalSquare;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void volumeTest() {
		Double actual = tetrahedronRegister.volume(tetrahedronThird.getId());
		Double expected = expectedVolume;

		Assert.assertEquals(actual, expected);
	}
}
