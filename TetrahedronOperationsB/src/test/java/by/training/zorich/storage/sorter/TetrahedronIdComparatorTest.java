package by.training.zorich.storage.sorter;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.sorter.impl.TetrahedronIdComparatorImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TetrahedronIdComparatorTest {
	@Test(dataProvider = "comparatorData", dataProviderClass = TetrahedronComparatorTestData.class)
	public void testCompare(Tetrahedron tetrahedronFirst, Tetrahedron tetrahedronSecond) {
		TetrahedronIdComparatorImpl tetrahedronIdComparatorImpl = new TetrahedronIdComparatorImpl();

		int actual = tetrahedronIdComparatorImpl.compare(tetrahedronFirst, tetrahedronSecond);
		int expected = -1;

		Assert.assertEquals(actual, expected);
	}
}
