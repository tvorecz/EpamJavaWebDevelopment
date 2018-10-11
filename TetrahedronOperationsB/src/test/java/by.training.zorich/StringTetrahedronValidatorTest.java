package by.training.zorich;

import by.training.zorich.action.validator.impl.StringTetrahedronValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringTetrahedronValidatorTest {
	@Test
	public void stringValidatorTest() {
		StringTetrahedronValidatorImpl stringTetrahedronValidator = new StringTetrahedronValidatorImpl();

		boolean actual = stringTetrahedronValidator.isValid("1 3 6&2 3 1&-1 0 1&-4 6 -3");
		boolean expected = true;

		Assert.assertEquals(actual, expected);
	}
}
