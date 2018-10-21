package by.training.zorich.storage.sorter.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.DoubleFieldTetrahedronAccessor;
import by.training.zorich.storage.accessor.impl.impl.CoordinateXVertexTetrahedronAccessorImpl;
import by.training.zorich.storage.accessor.impl.impl.VertexATetrahedronTetrahedronAccessorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TetrahedronCoordinateComparatorTest {
	@Test(dataProvider = "comparatorData", dataProviderClass = TetrahedronComparatorTestData.class)
	public void testCompare(Tetrahedron tetrahedronFirst, Tetrahedron tetrahedronSecond) {
		TetrahedronCoordinateComparator tetrahedronCoordinateComparator = new TetrahedronCoordinateComparator(new CoordinateXVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl()));

		int actual = tetrahedronCoordinateComparator.compare(tetrahedronFirst, tetrahedronSecond);
		int expected = 1;

		Assert.assertEquals(actual, expected);
	}
}
