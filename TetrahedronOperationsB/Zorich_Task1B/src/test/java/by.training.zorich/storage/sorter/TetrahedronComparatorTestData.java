package by.training.zorich.storage.sorter;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import org.testng.annotations.*;

public class TetrahedronComparatorTestData {
	private static Tetrahedron tetrahedronFirst;
	private static Tetrahedron tetrahedronSecond;
	private static Tetrahedron tetrahedronThird;
	private static Tetrahedron tetrahedronFourth;
	private static final int tetrahedronId = 1;
	private static final String tetrahedronName = "Tetrahedron # %s";

	@DataProvider(name = "comparatorData")
	public static Object[][] comparatorData() {
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

		Object[][] objectsData = new Object[1][2];
		objectsData[0][0] = tetrahedronFirst;
		objectsData[0][1] = tetrahedronSecond;

		return objectsData;
	}

	@DataProvider(name = "comparatorDataSorter")
	public static Object[][] comparatorDataSorter() {
		tetrahedronFirst = new Tetrahedron(new Point(12, -1, 12),
										   new Point(22, 10, 32),
										   new Point(11, 0, 11),
										   new Point(6, 4, 15));

		tetrahedronFirst.setId(tetrahedronId);
		tetrahedronFirst.setName(String.format(tetrahedronName, tetrahedronId));

		tetrahedronSecond = new Tetrahedron(new Point(10, 4, 15),
											new Point(13, -21, 11),
											new Point(14, 51, 16),
											new Point(13, 31, 12));

		tetrahedronSecond.setId(tetrahedronId + 1);
		tetrahedronSecond.setName(String.format(tetrahedronName, tetrahedronId + 1));

		tetrahedronThird = new Tetrahedron(new Point(4, 3, 2),
										   new Point(3, -7, 5),
										   new Point(11, 6, 6),
										   new Point(3, 2, 1));

		tetrahedronThird.setId(tetrahedronId + 2);
		tetrahedronThird.setName(String.format(tetrahedronName, tetrahedronId + 2));

		tetrahedronFourth = new Tetrahedron(new Point(3, 2, 1),
											new Point(32, -22, 11),
											new Point(9, 4, 2),
											new Point(9, 31, 12));

		tetrahedronFourth.setId(tetrahedronId + 3);
		tetrahedronFourth.setName(String.format(tetrahedronName, tetrahedronId + 3));

		Object[][] objectsData = new Object[1][4];
		objectsData[0][0] = tetrahedronFirst;
		objectsData[0][1] = tetrahedronSecond;

		objectsData[0][2] = tetrahedronThird;
		objectsData[0][3] = tetrahedronFourth;

		return objectsData;
	}
}
