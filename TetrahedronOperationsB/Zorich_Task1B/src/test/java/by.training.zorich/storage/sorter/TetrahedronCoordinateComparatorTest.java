package by.training.zorich.storage.sorter;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.CoordinateXVertexTetrahedronAccessorImpl;
import by.training.zorich.storage.accessor.impl.VertexATetrahedronTetrahedronAccessorImpl;
import by.training.zorich.storage.sorter.impl.TetrahedronCoordinateComparatorImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TetrahedronCoordinateComparatorTest {
	@Test(dataProvider = "comparatorData", dataProviderClass = TetrahedronComparatorTestData.class)
	public void testCompare(Tetrahedron tetrahedronFirst, Tetrahedron tetrahedronSecond) {
		TetrahedronCoordinateComparatorImpl tetrahedronCoordinateComparatorImpl = new TetrahedronCoordinateComparatorImpl(
				new CoordinateXVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl()));

		int actual = tetrahedronCoordinateComparatorImpl.compare(tetrahedronFirst, tetrahedronSecond);
		int expected = 1;

		Assert.assertEquals(actual, expected);
	}
}
