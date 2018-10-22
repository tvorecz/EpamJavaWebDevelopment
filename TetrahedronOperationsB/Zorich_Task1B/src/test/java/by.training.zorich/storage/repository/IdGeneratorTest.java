package by.training.zorich.storage.repository;

import by.training.zorich.storage.repository.impl.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IdGeneratorTest {
	@Test
	public void testIdGenerator() {
		IdGenerator idGenerator = new IdGenerator(3);

		idGenerator.nextId();
		idGenerator.nextId();
		idGenerator.nextId();

		int actual = idGenerator.nextId();
		int expected = 6;

		Assert.assertEquals(actual, expected);
	}

}
