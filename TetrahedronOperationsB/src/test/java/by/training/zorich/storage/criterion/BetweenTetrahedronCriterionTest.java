package by.training.zorich.storage.criterion;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.CoordinateXVertexTetrahedronAccessorImpl;
import by.training.zorich.storage.accessor.impl.IdTetrahedronAccessorImpl;
import by.training.zorich.storage.accessor.impl.VertexATetrahedronTetrahedronAccessorImpl;
import by.training.zorich.storage.criterion.impl.BetweenDoubleTetrahedronCriterionImpl;
import by.training.zorich.storage.criterion.impl.BetweenIntegerTetrahedronCriterionImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BetweenTetrahedronCriterionTest {
	private static Tetrahedron tetrahedron;
	private static final int tetrahedronId = 1;
	private static final String tetrahedronName = "Tetrahedron # %s";
	private static final double minDouble = 0.0;
	private static final double maxDouble = 10.0;
	private static final Integer minInteger = 0;
	private static final Integer maxInteger = 10;
	private static final double coordinate = 2.0;

	@BeforeTest
	public void createTestTetrahedron() {
		tetrahedron = new Tetrahedron(new Point(coordinate, -1, 2),
									  new Point(2, 1, 3),
									  new Point(1, 0, 1),
									  new Point(6, 4, 5));

		tetrahedron.setId(tetrahedronId);
		tetrahedron.setName(String.format(tetrahedronName, tetrahedronId));
	}

	@Test
	public void testBetweenIntegerTetrahedronCriterionField() {
		BetweenTetrahedronCriterion betweenTetrahedronCriterion = new BetweenIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(),
																											 minInteger,
																											 maxInteger);

		Integer actual = (Integer) betweenTetrahedronCriterion.extractTetrahedronField(tetrahedron);
		Integer expected = tetrahedronId;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testBetweenIntegerTetrahedronCriterionMinValue() {
		BetweenTetrahedronCriterion betweenTetrahedronCriterion = new BetweenIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(),
																											 minInteger,
																											 maxInteger);

		Integer actual = (Integer) betweenTetrahedronCriterion.criterionMinValue();
		Integer expected = minInteger;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testBetweenIntegerTetrahedronCriterionMaxValue() {
		BetweenTetrahedronCriterion betweenTetrahedronCriterion = new BetweenIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(),
																											 minInteger,
																											 maxInteger);

		Integer actual = (Integer) betweenTetrahedronCriterion.criterionMaxValue();
		Integer expected = maxInteger;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testBetweenDoubleTetrahedronCriterionField() {
		BetweenTetrahedronCriterion betweenTetrahedronCriterion = new BetweenDoubleTetrahedronCriterionImpl(new CoordinateXVertexTetrahedronAccessorImpl(
				new VertexATetrahedronTetrahedronAccessorImpl()), minDouble, maxDouble);

		Double actual = (Double) betweenTetrahedronCriterion.extractTetrahedronField(tetrahedron);
		Double expected = coordinate;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testBetweenDoubleTetrahedronCriterionMinValue() {
		BetweenTetrahedronCriterion betweenTetrahedronCriterion = new BetweenDoubleTetrahedronCriterionImpl(new CoordinateXVertexTetrahedronAccessorImpl(
				new VertexATetrahedronTetrahedronAccessorImpl()), minDouble, maxDouble);

		Double actual = (Double) betweenTetrahedronCriterion.criterionMinValue();
		Double expected = minDouble;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testBetweenDoubleTetrahedronCriterionMaxValue() {
		BetweenTetrahedronCriterion betweenTetrahedronCriterion = new BetweenDoubleTetrahedronCriterionImpl(new CoordinateXVertexTetrahedronAccessorImpl(
				new VertexATetrahedronTetrahedronAccessorImpl()), minDouble, maxDouble);

		Double actual = (Double) betweenTetrahedronCriterion.criterionMaxValue();
		Double expected = maxDouble;

		Assert.assertEquals(actual, expected);
	}
}
