package by.training.zorich.storage.sorter;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.sorter.impl.TetrahedronNameComparatorImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TetrahedronNameComparatorTest {
	@Test(dataProvider = "comparatorData", dataProviderClass = TetrahedronComparatorTestData.class)
	public void testCompare(Tetrahedron tetrahedronFirst, Tetrahedron tetrahedronSecond) {
		TetrahedronNameComparatorImpl tetrahedronNameComparatorImpl = new TetrahedronNameComparatorImpl();

		int actual = tetrahedronNameComparatorImpl.compare(tetrahedronFirst, tetrahedronSecond);
		int expected = -1;

		Assert.assertEquals(actual, expected);
	}
}
