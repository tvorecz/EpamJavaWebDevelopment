package by.training.zorich.action.validator.impl;

import by.training.zorich.action.validator.impl.VertexesTetrahedronValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VertexesTetrahedronValidatorTest {
	@Test
	public void testVertexesTetrahedronValidator() {
		VertexesTetrahedronValidatorImpl vertexesTetrahedronValidator = new VertexesTetrahedronValidatorImpl();

		double[][] vertexes = {{0, 0, 0}, {1, 2, 3}, {0, 0, 0}, {-10, 11, 4}};

		boolean actual = vertexesTetrahedronValidator.isValid(vertexes);

		boolean expected = false;

		Assert.assertEquals(actual, expected);
	}
}
