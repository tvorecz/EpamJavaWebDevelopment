package by.training.zorich.storage.criterion.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.impl.CoordinateXVertexTetrahedronAccessorImpl;
import by.training.zorich.storage.accessor.impl.impl.IdTetrahedronAccessorImpl;
import by.training.zorich.storage.accessor.impl.impl.NameTetrahedronAccessorImpl;
import by.training.zorich.storage.accessor.impl.impl.VertexATetrahedronTetrahedronAccessorImpl;
import by.training.zorich.storage.criterion.impl.impl.SingleDoubleTetrahedronCriterionImpl;
import by.training.zorich.storage.criterion.impl.impl.SingleIntegerTetrahedronCriterionImpl;
import by.training.zorich.storage.criterion.impl.impl.SingleStringTetrahedronCriterionImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SingleTetrahedronCriterionTest {
	private static Tetrahedron tetrahedron;
	private static final int tetrahedronId = 1;
	private static final String tetrahedronName = "Tetrahedron # %s";

	@BeforeTest
	public void createTestTetrahedron() {
		tetrahedron = new Tetrahedron(new Point(2, -1, 2),
				new Point(2, 1, 3),
				new Point(1, 0, 1),
				new Point(6, 4, 5));

		tetrahedron.setId(tetrahedronId);
		tetrahedron.setName(String.format(tetrahedronName, tetrahedronId));
	}

	@Test
	public void testSingleStringTetrahedronCriterionField() {
		SingleTetrahedronCriterion singleTetrahedronCriterion = new SingleStringTetrahedronCriterionImpl(new NameTetrahedronAccessorImpl(), String.format(tetrahedronName, tetrahedronId));

		String actual = (String) singleTetrahedronCriterion.extractTetrahedronField(tetrahedron);
		String expected = String.format(tetrahedronName, tetrahedronId);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testSingleStringTetrahedronCriterionValue() {
		SingleTetrahedronCriterion singleTetrahedronCriterion = new SingleStringTetrahedronCriterionImpl(new NameTetrahedronAccessorImpl(), String.format(tetrahedronName, tetrahedronId));

		String actual = (String) singleTetrahedronCriterion.criterionValue();
		String expected = String.format(tetrahedronName, tetrahedronId);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testSingleIntegerTetrahedronCriterionField() {
		SingleTetrahedronCriterion singleTetrahedronCriterion = new SingleIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(), tetrahedronId);

		Integer actual = (Integer) singleTetrahedronCriterion.extractTetrahedronField(tetrahedron);
		Integer expected = tetrahedronId;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testSingleIntegerTetrahedronCriterionValue() {
		SingleTetrahedronCriterion singleTetrahedronCriterion = new SingleIntegerTetrahedronCriterionImpl(new IdTetrahedronAccessorImpl(), tetrahedronId);

		Integer actual = (Integer) singleTetrahedronCriterion.criterionValue();
		Integer expected = tetrahedronId;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testSingleDoubleTetrahedronCriterionField() {
		SingleTetrahedronCriterion singleTetrahedronCriterion = new SingleDoubleTetrahedronCriterionImpl(new CoordinateXVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl()), 2.0);

		Double actual = (Double) singleTetrahedronCriterion.extractTetrahedronField(tetrahedron);
		Double expected = 2.0;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testSingleDoubleTetrahedronCriterionValue() {
		SingleTetrahedronCriterion singleTetrahedronCriterion = new SingleDoubleTetrahedronCriterionImpl(new CoordinateXVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl()), 2.0);

		Double actual = (Double) singleTetrahedronCriterion.criterionValue();
		Double expected = 2.0;

		Assert.assertEquals(actual, expected);
	}
}
