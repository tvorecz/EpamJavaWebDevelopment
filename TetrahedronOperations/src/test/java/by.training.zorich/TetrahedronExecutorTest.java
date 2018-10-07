package by.training.zorich;

import by.training.zorich.action.executor.impl.TetrahedronExecutorImpl;
import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TetrahedronExecutorTest {
	@Test
	public void testCalculateVolume() {
		TetrahedronExecutorImpl tetrahedronExecutor = new TetrahedronExecutorImpl();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(2,-1,2), new Point(2,1,3), new Point(1,0,1), new Point(6,4,5));

		double expected = 11.0/6.0;
		double actual = tetrahedronExecutor.calculateVolume(tetrahedron);

		Assert.assertEquals(actual, expected);
	}
}
