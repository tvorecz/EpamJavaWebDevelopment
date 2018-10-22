package by.training.zorich.storage.specification;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.CoordinateXVertexTetrahedronAccessorImpl;
import by.training.zorich.storage.accessor.impl.IdTetrahedronAccessorImpl;
import by.training.zorich.storage.accessor.impl.VertexATetrahedronTetrahedronAccessorImpl;
import by.training.zorich.storage.criterion.impl.BetweenDoubleTetrahedronCriterionImpl;
import by.training.zorich.storage.criterion.impl.BetweenIntegerTetrahedronCriterionImpl;
import by.training.zorich.storage.criterion.impl.SingleDoubleTetrahedronCriterionImpl;
import by.training.zorich.storage.criterion.impl.SingleIntegerTetrahedronCriterionImpl;
import by.training.zorich.storage.specification.impl.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TetrahedronSpecificationTest {
	private static Tetrahedron tetrahedron;
	private static final int tetrahedronId = 1;
	private static final String tetrahedronName = "Tetrahedron # %s";

	@BeforeTest
	public void createTestTetrahedron() {
		tetrahedron = new Tetrahedron(new Point(2, -1, 2), new Point(2, 1, 3), new Point(1, 0, 1), new Point(6, 4, 5));

		tetrahedron.setId(tetrahedronId);
		tetrahedron.setName(String.format(tetrahedronName, tetrahedronId));
	}

	@Test
	public void TetrahedronEqualToSpecificationTest() {
		TetrahedronEqualToSpecificationImpl tetrahedronEqualToSpecification = new TetrahedronEqualToSpecificationImpl(
				new SingleIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(), 10));

		boolean actual = tetrahedronEqualToSpecification.isSatisfiedBy(tetrahedron);
		boolean expected = false;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void TetrahedronLessThanDoubleSpecificationTest() {
		TetrahedronLessThanDoubleSpecificationImpl tetrahedronLessThanDoubleSpecification = new TetrahedronLessThanDoubleSpecificationImpl(
				new SingleDoubleTetrahedronCriterionImpl(new CoordinateXVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl()),
														 4.0));

		boolean actual = tetrahedronLessThanDoubleSpecification.isSatisfiedBy(tetrahedron);
		boolean expected = true;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void TetrahedronMoreThanDoubleSpecificationTest() {
		TetrahedronMoreThanDoubleSpecificationImpl tetrahedronMoreThanDoubleSpecification = new TetrahedronMoreThanDoubleSpecificationImpl(
				new SingleDoubleTetrahedronCriterionImpl(new CoordinateXVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl()),
														 4.0));

		boolean actual = tetrahedronMoreThanDoubleSpecification.isSatisfiedBy(tetrahedron);
		boolean expected = false;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void TetrahedronLessThanIntegerSpecificationTest() {
		TetrahedronLessThanIntegerSpecificationImpl tetrahedronLessThanIntegerSpecification = new TetrahedronLessThanIntegerSpecificationImpl(
				new SingleIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(), 11));

		boolean actual = tetrahedronLessThanIntegerSpecification.isSatisfiedBy(tetrahedron);
		boolean expected = true;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void TetrahedronMoreThanIntegerSpecificationTest() {
		TetrahedronMoreThanIntegerSpecificationImpl tetrahedronMoreThanIntegerSpecification = new TetrahedronMoreThanIntegerSpecificationImpl(
				new SingleIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(), 0));

		boolean actual = tetrahedronMoreThanIntegerSpecification.isSatisfiedBy(tetrahedron);
		boolean expected = true;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void TetrahedronBetweenDoubleSpecificationTest() {
		TetrahedronBetweenDoubleSpecificationImpl tetrahedronBetweenDoubleSpecification = new TetrahedronBetweenDoubleSpecificationImpl(
				new BetweenDoubleTetrahedronCriterionImpl(new CoordinateXVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl()),
														  4.0,
														  6.0));

		boolean actual = tetrahedronBetweenDoubleSpecification.isSatisfiedBy(tetrahedron);
		boolean expected = false;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void TetrahedronBetweenIntegerSpecificationTest() {
		TetrahedronBetweenIntegerSpecificationImpl tetrahedronBetweenIntegerSpecification = new TetrahedronBetweenIntegerSpecificationImpl(
				new BetweenIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(), 1, 5));

		boolean actual = tetrahedronBetweenIntegerSpecification.isSatisfiedBy(tetrahedron);
		boolean expected = true;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void TetrahedronAndSpecificationTest() {
		TetrahedronLessThanIntegerSpecificationImpl tetrahedronLessThanIntegerSpecification = new TetrahedronLessThanIntegerSpecificationImpl(
				new SingleIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(), 11));
		TetrahedronMoreThanIntegerSpecificationImpl tetrahedronMoreThanIntegerSpecification = new TetrahedronMoreThanIntegerSpecificationImpl(
				new SingleIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(), 0));

		TetrahedronSpecification tetrahedronSpecification = tetrahedronLessThanIntegerSpecification.and(
				tetrahedronMoreThanIntegerSpecification);

		boolean actual = tetrahedronSpecification.isSatisfiedBy(tetrahedron);
		boolean expected = true;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void TetrahedronOrSpecificationTest() {
		TetrahedronMoreThanDoubleSpecificationImpl tetrahedronMoreThanDoubleSpecification = new TetrahedronMoreThanDoubleSpecificationImpl(
				new SingleDoubleTetrahedronCriterionImpl(new CoordinateXVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl()),
														 4.0));
		TetrahedronMoreThanIntegerSpecificationImpl tetrahedronMoreThanIntegerSpecification = new TetrahedronMoreThanIntegerSpecificationImpl(
				new SingleIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(), 0));

		TetrahedronSpecification tetrahedronSpecification = tetrahedronMoreThanDoubleSpecification.or(
				tetrahedronMoreThanIntegerSpecification);

		boolean actual = tetrahedronSpecification.isSatisfiedBy(tetrahedron);
		boolean expected = true;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void TetrahedronNotSpecificationTest() {
		TetrahedronBetweenDoubleSpecificationImpl tetrahedronBetweenDoubleSpecification = new TetrahedronBetweenDoubleSpecificationImpl(
				new BetweenDoubleTetrahedronCriterionImpl(new CoordinateXVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl()),
														  4.0,
														  6.0));

		TetrahedronSpecification tetrahedronSpecification = tetrahedronBetweenDoubleSpecification.not();

		boolean actual = tetrahedronSpecification.isSatisfiedBy(tetrahedron);
		boolean expected = true;

		Assert.assertEquals(actual, expected);
	}
}
