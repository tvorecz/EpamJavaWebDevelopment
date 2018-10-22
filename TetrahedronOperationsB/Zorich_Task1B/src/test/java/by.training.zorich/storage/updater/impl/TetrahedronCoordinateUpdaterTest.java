package by.training.zorich.storage.updater.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.VertexATetrahedronTetrahedronAccessorImpl;
import by.training.zorich.storage.updater.CalculateUpdatingValue;
import by.training.zorich.storage.updater.TetrahedronUpdater;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TetrahedronCoordinateUpdaterTest {
	private static Tetrahedron tetrahedron;
	private static final int tetrahedronId = 1;
	private static final String tetrahedronName = "Tetrahedron # %s";

	@BeforeTest
	public void createTestTetrahedron() {
		tetrahedron = new Tetrahedron(new Point(2, -1, 2), new Point(2, 1, 3), new Point(1, 0, 1), new Point(6, 4, 5));

		tetrahedron.setId(tetrahedronId);
		tetrahedron.setName(String.format(tetrahedronName, tetrahedronId));
	}

	@Test(priority = 1)
	public void TetrahedronXCoordinateUpdaterTest() {
		CalculateUpdatingValue calculateUpdatingValue = (double firstDoubleValue, double secondDoubleValue) -> {
			return firstDoubleValue + secondDoubleValue;
		};

		TetrahedronXCoordinateUpdaterImpl tetrahedronXCoordinateUpdater = new TetrahedronXCoordinateUpdaterImpl(new VertexATetrahedronTetrahedronAccessorImpl(),
																												2,
																												calculateUpdatingValue);
		tetrahedronXCoordinateUpdater.update(tetrahedron);


		double actual = tetrahedron.getVertexA().getCoordinateX();
		double expected = 4;

		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void TetrahedronYCoordinateUpdaterTest() {
		CalculateUpdatingValue calculateUpdatingValue = (double firstDoubleValue, double secondDoubleValue) -> {
			return firstDoubleValue + secondDoubleValue;
		};

		TetrahedronYCoordinateUpdaterImpl tetrahedronYCoordinateUpdater = new TetrahedronYCoordinateUpdaterImpl(new VertexATetrahedronTetrahedronAccessorImpl(),
																												2,
																												calculateUpdatingValue);
		tetrahedronYCoordinateUpdater.update(tetrahedron);


		double actual = tetrahedron.getVertexA().getCoordinateY();
		double expected = 1;

		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void TetrahedronZCoordinateUpdaterTest() {
		CalculateUpdatingValue calculateUpdatingValue = (double firstDoubleValue, double secondDoubleValue) -> {
			return firstDoubleValue + secondDoubleValue;
		};

		TetrahedronZCoordinateUpdaterImpl tetrahedronZCoordinateUpdater = new TetrahedronZCoordinateUpdaterImpl(new VertexATetrahedronTetrahedronAccessorImpl(),
																												2,
																												calculateUpdatingValue);
		tetrahedronZCoordinateUpdater.update(tetrahedron);


		double actual = tetrahedron.getVertexA().getCoordinateZ();
		double expected = 4;

		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void TetrahedronAndCoordinateUpdaterTest() {
		CalculateUpdatingValue calculateUpdatingValue = (double firstDoubleValue, double secondDoubleValue) -> {
			return firstDoubleValue * secondDoubleValue;
		};

		TetrahedronZCoordinateUpdaterImpl tetrahedronZCoordinateUpdater = new TetrahedronZCoordinateUpdaterImpl(new VertexATetrahedronTetrahedronAccessorImpl(),
																												2,
																												calculateUpdatingValue);
		TetrahedronUpdater tetrahedronUpdater = tetrahedronZCoordinateUpdater.and(new TetrahedronZCoordinateUpdaterImpl(
				new VertexATetrahedronTetrahedronAccessorImpl(),
				10,
				calculateUpdatingValue));
		tetrahedronUpdater.update(tetrahedron);

		double actual = tetrahedron.getVertexA().getCoordinateZ();
		double expected = 80;

		Assert.assertEquals(actual, expected);
	}
}
