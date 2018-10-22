package by.training.zorich.storage.sorter;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.CoordinateYVertexTetrahedronAccessorImpl;
import by.training.zorich.storage.accessor.impl.VertexATetrahedronTetrahedronAccessorImpl;
import by.training.zorich.storage.sorter.impl.TetrahedronCoordinateComparatorImpl;
import by.training.zorich.storage.sorter.impl.TetrahedronSorterImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronSorterTest {
	@Test(dataProvider = "comparatorDataSorter", dataProviderClass = TetrahedronComparatorTestData.class)
	public void tetrahedronSorterTest(Tetrahedron tetrahedronFirst,
									  Tetrahedron tetrahedronSecond,
									  Tetrahedron tetrahedronThird,
									  Tetrahedron tetrahedronFourth) {
		List<Tetrahedron> actual = new ArrayList<>();
		actual.add(tetrahedronFirst);
		actual.add(tetrahedronSecond);
		actual.add(tetrahedronThird);
		actual.add(tetrahedronFourth);

		TetrahedronSorter tetrahedronSorter = new TetrahedronSorterImpl();
		tetrahedronSorter.sort(actual,
							   new TetrahedronCoordinateComparatorImpl(new CoordinateYVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl())));

		List<Tetrahedron> expected = new ArrayList<>();
		expected.add(tetrahedronFirst);
		expected.add(tetrahedronFourth);
		expected.add(tetrahedronThird);
		expected.add(tetrahedronSecond);

		Assert.assertEquals(actual, expected);
	}
}
