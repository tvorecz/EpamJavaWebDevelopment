package by.training.zorich.action.validator.impl;

import by.training.zorich.action.validator.impl.StringTetrahedronValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringTetrahedronValidatorTest {
	private final static String FIRST = "1 3 6&2 3 1&-1 0 1&-4 6 -3";

	@Test
	public void stringValidatorTest() {
		StringTetrahedronValidatorImpl stringTetrahedronValidator = new StringTetrahedronValidatorImpl();

		boolean actual = stringTetrahedronValidator.isValid(FIRST);
		boolean expected = true;

		Assert.assertEquals(actual, expected);
	}
}
