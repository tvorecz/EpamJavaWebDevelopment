package by.training.zorich.action.executor.impl;

import by.training.zorich.action.executor.impl.TetrahedronExecutorImpl;
import by.training.zorich.domain.CuttingCoordinatePlane;
import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TetrahedronExecutorTest {
	@Test
	public void testCalculateVolume() {
		TetrahedronExecutorImpl tetrahedronExecutor = new TetrahedronExecutorImpl();

		Point A = new Point(2, -1, 2);
		Point B = new Point(2, 1, 3);
		Point C = new Point(1, 0, 1);
		Point D = new Point(6, 4, 5);

		Tetrahedron tetrahedron = new Tetrahedron(A, B, C, D);

		double expected = 11.0 / 6.0;
		double actual = tetrahedronExecutor.calculateVolume(tetrahedron);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testCalculateTotalSquare() {
		TetrahedronExecutorImpl tetrahedronExecutor = new TetrahedronExecutorImpl();

		Point A = new Point(0, 4, 5);
		Point B = new Point(3, -2, 1);
		Point C = new Point(4, 5, 6);
		Point D = new Point(3, 3, 2);

		Tetrahedron tetrahedron = new Tetrahedron(A, B, C, D);

		double expected = (0.5 * Math.sqrt(1094.0)) + (0.5 * Math.sqrt(430.0)) + (0.5 * Math.sqrt(278.0)) + (0.5 * Math.sqrt(350));

		double actual = tetrahedronExecutor.calculateTotalSquare(tetrahedron);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testIsRegularTetrahedron() {
		TetrahedronExecutorImpl tetrahedronExecutor = new TetrahedronExecutorImpl();

		Point A = new Point(0, 0, 0);
		Point B = new Point(1, 0, 0);
		Point C = new Point(0.5, Math.sqrt(3.0 / 4.0), 0);
		Point D = new Point(0.5, Math.sqrt(3.0) / 6.0, Math.sqrt(6.0) / 3.0);

		Tetrahedron tetrahedron = new Tetrahedron(A, B, C, D);

		boolean expected = true;
		boolean actual = tetrahedronExecutor.isRegularTetrahedron(tetrahedron);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testIsBasedOnCoordinatePlate() {
		TetrahedronExecutorImpl tetrahedronExecutor = new TetrahedronExecutorImpl();

		Point A = new Point(0, 0, 0);
		Point B = new Point(1, 0, 0);
		Point C = new Point(0.5, Math.sqrt(3.0 / 4.0), 0);
		Point D = new Point(0.5, Math.sqrt(3.0) / 6.0, Math.sqrt(6.0) / 3.0);

		Tetrahedron tetrahedron = new Tetrahedron(A, B, C, D);

		boolean expected = true;
		boolean actual = tetrahedronExecutor.isBaseOnCoordinatePlane(tetrahedron);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testCalculateRatiosOfVolumes() {
		TetrahedronExecutorImpl tetrahedronExecutor = new TetrahedronExecutorImpl();

		Point A = new Point(0, 0, 0);
		Point B = new Point(1, 0, 0);
		Point C = new Point(0.5, Math.sqrt(3.0 / 4.0), 0);
		Point D = new Point(0.5, Math.sqrt(3.0) / 6.0, Math.sqrt(6.0) / 3.0);

		Tetrahedron tetrahedron = new Tetrahedron(A, B, C, D);

		Point X = new Point(0.5, Math.sqrt(3.0 / 4.0), 0);
		Point Z = new Point(0.5, Math.sqrt(3.0) / 6.0, Math.sqrt(6.0) / 3.0);
		Point Y = new Point(0.5, 0, 0);

		CuttingCoordinatePlane cuttingCoordinatePlane = new CuttingCoordinatePlane(X, Y, Z);

		double[] actual = tetrahedronExecutor.calculateRatiosOfVolumes(tetrahedron, cuttingCoordinatePlane);
		double[] expected = {1.0, 1.0};

		Assert.assertEquals(actual, expected);
	}
}
