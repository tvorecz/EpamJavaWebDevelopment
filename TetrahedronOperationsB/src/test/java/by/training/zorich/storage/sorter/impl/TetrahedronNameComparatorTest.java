package by.training.zorich.storage.sorter.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TetrahedronNameComparatorTest {
	private static Tetrahedron tetrahedronFirst;
	private static Tetrahedron tetrahedronSecond;
	private static final int tetrahedronId = 1;
	private static final String tetrahedronName = "Tetrahedron # %s";

	@BeforeTest
	public void createTestTetrahedron() {
		tetrahedronFirst = new Tetrahedron(new Point(2, -1, 2),
				new Point(2, 1, 3),
				new Point(1, 0, 1),
				new Point(6, 4, 5));

		tetrahedronFirst.setId(tetrahedronId);
		tetrahedronFirst.setName(String.format(tetrahedronName, tetrahedronId));

		tetrahedronSecond = new Tetrahedron(new Point(0, 4, 5),
				new Point(3, -2, 1),
				new Point(4, 5, 6),
				new Point(3, 3, 2));

		tetrahedronSecond.setId(tetrahedronId + 1);
		tetrahedronSecond.setName(String.format(tetrahedronName, tetrahedronId + 1));
	}

	@Test
	public void testCompare() {
		TetrahedronNameComparator tetrahedronNameComparator = new TetrahedronNameComparator();

		int actual = tetrahedronNameComparator.compare(tetrahedronFirst, tetrahedronSecond);
		int expected = -1;

		Assert.assertEquals(actual, expected);
	}
}
