package by.training.zorich.storage.sorter.impl;

import by.training.zorich.domain.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TetrahedronNameComparatorTest {
	@Test(dataProvider = "comparatorData", dataProviderClass = TetrahedronComparatorTestData.class)
	public void testCompare(Tetrahedron tetrahedronFirst, Tetrahedron tetrahedronSecond) {
		TetrahedronNameComparator tetrahedronNameComparator = new TetrahedronNameComparator();

		int actual = tetrahedronNameComparator.compare(tetrahedronFirst, tetrahedronSecond);
		int expected = -1;

		Assert.assertEquals(actual, expected);
	}
}
