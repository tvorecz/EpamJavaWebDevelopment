package by.training.zorich.storage.accessor;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.*;
import by.training.zorich.storage.register.TetrahedronRegister;
import by.training.zorich.storage.register.impl.TetrahedronRegisterImpl;
import by.training.zorich.storage.repository.TetrahedronRepository;
import by.training.zorich.storage.repository.impl.TetrahedronRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TetrahedronFieldAccessorTest {
	private static Tetrahedron tetrahedron;
	private static Tetrahedron tetrahedronForTestSquare;
	private static Tetrahedron tetrahedronForTestVolume;
	private static final int tetrahedronId = 1;
	private static final String tetrahedronName = "Tetrahedron # %s";
	private TetrahedronRepository tetrahedronRepository = TetrahedronRepositoryImpl.getInstance();
	private TetrahedronRegister tetrahedronRegister = TetrahedronRegisterImpl.getInstance();

	@BeforeTest
	public void createTestTetrahedron() {
		tetrahedron = new Tetrahedron(new Point(2, -1, 2), new Point(2, 1, 3), new Point(1, 0, 1), new Point(6, 4, 5));

		tetrahedron.setId(tetrahedronId);
		tetrahedron.setName(String.format(tetrahedronName, tetrahedronId));

		tetrahedronForTestSquare = new Tetrahedron(new Point(0, 4, 5),
												   new Point(3, -2, 1),
												   new Point(4, 5, 6),
												   new Point(3, 3, 2));

		tetrahedronForTestSquare.setId(tetrahedronId + 1);
		tetrahedronForTestSquare.setName(String.format(tetrahedronName, tetrahedronId + 1));

		tetrahedronForTestVolume = new Tetrahedron(new Point(2, -1, 2),
												   new Point(2, 1, 3),
												   new Point(1, 0, 1),
												   new Point(6, 4, 5));

		tetrahedronForTestVolume.setId(tetrahedronId + 2);
		tetrahedronForTestVolume.setName(String.format(tetrahedronName, tetrahedronId + 2));

		tetrahedronRepository.addTetrahedron(tetrahedron);
		tetrahedronRepository.addTetrahedron(tetrahedronForTestSquare);
		tetrahedronRepository.addTetrahedron(tetrahedronForTestVolume);
	}

	@Test
	public void idTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new IdTetrahedronAccessorImpl();

		Integer actual = (Integer) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedron);
		Integer expected = tetrahedronId;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void nameTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new NameTetrahedronAccessorImpl();

		String actual = (String) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedron);
		String expected = String.format(tetrahedronName, tetrahedronId);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void vertexATetrahedronTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new VertexATetrahedronTetrahedronAccessorImpl();

		Point actual = (Point) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedron);
		Point expected = new Point(2, -1, 2);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void vertexBTetrahedronTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new VertexBTetrahedronTetrahedronAccessorImpl();

		Point actual = (Point) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedron);
		Point expected = new Point(2, 1, 3);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void vertexCTetrahedronTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new VertexCTetrahedronTetrahedronAccessorImpl();

		Point actual = (Point) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedron);
		Point expected = new Point(1, 0, 1);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void vertexDTetrahedronTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new VertexDTetrahedronTetrahedronAccessorImpl();

		Point actual = (Point) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedron);
		Point expected = new Point(6, 4, 5);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void coordinateXVertexTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new CoordinateXVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl());

		Double actual = (Double) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedron);
		Double expected = 2.0;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void coordinateYVertexTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new CoordinateYVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl());

		Double actual = (Double) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedron);
		Double expected = -1.0;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void coordinateZVertexTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new CoordinateZVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl());

		Double actual = (Double) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedron);
		Double expected = 2.0;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void perimeterTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new PerimeterTetrahedronAccessorImpl(tetrahedronRegister);

		Double actual = (Double) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedron);
		Double expected = 26.423675582122574;

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void totalSquareTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new TotalSquareTetrahedronAccessorImpl(tetrahedronRegister);

		Double expected = (0.5 * Math.sqrt(1094.0)) + (0.5 * Math.sqrt(430.0)) + (0.5 * Math.sqrt(278.0)) + (0.5 * Math.sqrt(
				350));

		Double actual = (Double) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedronForTestSquare);

		Assert.assertEquals(actual, expected);
	}

	@Test
	public void volumeTetrahedronAccessorTest() {
		TetrahedronFieldAccessor tetrahedronFieldAccessor = new VolumeTetrahedronAccessorImpl(tetrahedronRegister);

		Double expected = 11.0 / 6.0;

		Double actual = (Double) tetrahedronFieldAccessor.extractTetrahedronField(tetrahedronForTestVolume);

		Assert.assertEquals(actual, expected);
	}
}
