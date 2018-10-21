package by.training.zorich.storage.sorter.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.event.EventType;
import by.training.zorich.storage.event.impl.arg.EventArg;
import by.training.zorich.storage.register.impl.impl.TetrahedronRegisterImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TetrahedronIdComparatorTest {
	@Test(dataProvider = "comparatorData", dataProviderClass = TetrahedronComparatorTestData.class)
	public void testCompare(Tetrahedron tetrahedronFirst, Tetrahedron tetrahedronSecond) {
		TetrahedronIdComparator tetrahedronIdComparator = new TetrahedronIdComparator();

		int actual = tetrahedronIdComparator.compare(tetrahedronFirst, tetrahedronSecond);
		int expected = -1;

		Assert.assertEquals(actual, expected);
	}
}
