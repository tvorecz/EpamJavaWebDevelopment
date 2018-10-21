package by.training.zorich.storage.repository.impl;

import by.training.zorich.domain.Point;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.DoubleFieldTetrahedronAccessor;
import by.training.zorich.storage.accessor.impl.impl.*;
import by.training.zorich.storage.criterion.impl.impl.BetweenDoubleTetrahedronCriterionImpl;
import by.training.zorich.storage.criterion.impl.impl.SingleDoubleTetrahedronCriterionImpl;
import by.training.zorich.storage.criterion.impl.impl.SingleIntegerTetrahedronCriterionImpl;
import by.training.zorich.storage.criterion.impl.impl.SingleStringTetrahedronCriterionImpl;
import by.training.zorich.storage.register.impl.impl.TetrahedronRegisterImpl;
import by.training.zorich.storage.repository.impl.impl.TetrahedronRepositoryImpl;
import by.training.zorich.storage.specification.impl.TetrahedronSpecification;
import by.training.zorich.storage.specification.impl.impl.TetrahedronBetweenDoubleSpecificationImpl;
import by.training.zorich.storage.specification.impl.impl.TetrahedronEqualToSpecificationImpl;
import by.training.zorich.storage.specification.impl.impl.TetrahedronMoreThanDoubleSpecificationImpl;
import by.training.zorich.storage.specification.impl.impl.TetrahedronMoreThanIntegerSpecificationImpl;
import by.training.zorich.storage.updater.CalculateUpdatingValue;
import by.training.zorich.storage.updater.impl.TetrahedronZCoordinateUpdaterImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronRepositoryImplTest {
	private static Tetrahedron tetrahedronFirst;
	private static Tetrahedron tetrahedronSecond;
	private static Tetrahedron tetrahedronThird;
	private static Tetrahedron tetrahedronFourth;
	private static Tetrahedron tetrahedronFifth;
	private static Tetrahedron tetrahedronSixth;
	private static final int tetrahedronId = 1;
	private static final String tetrahedronName = "Tetrahedron # %s";
	private static TetrahedronRepositoryImpl tetrahedronRepository;

	@BeforeTest
	public void createTestData() {
		tetrahedronFirst = new Tetrahedron(new Point(2, -1, 2), new Point(2, 1, 3), new Point(1, 0, 1), new Point(6, 4, 5));

		tetrahedronFirst.setId(tetrahedronId);
		tetrahedronFirst.setName(String.format(tetrahedronName, tetrahedronId));

		tetrahedronSecond = new Tetrahedron(new Point(0, 4, 5), new Point(3, -2, 1), new Point(4, 5, 6), new Point(3, 3, 2));

		tetrahedronSecond.setId(tetrahedronId + 1);
		tetrahedronSecond.setName(String.format(tetrahedronName, tetrahedronId + 1));

		tetrahedronThird = new Tetrahedron(new Point(1, 2, 3), new Point(2, -6, 4), new Point(4, 2, -6), new Point(9, 9, -2));

		tetrahedronThird.setId(tetrahedronId + 2);
		tetrahedronThird.setName(String.format(tetrahedronName, tetrahedronId + 2));

		tetrahedronFourth = new Tetrahedron(new Point(0, 0, 0), new Point(2, 0, 0), new Point(0, 3, 8), new Point(1, 9, 9));

		tetrahedronFourth.setId(tetrahedronId + 3);
		tetrahedronFourth.setName(String.format(tetrahedronName, tetrahedronId + 3));

		tetrahedronFifth = new Tetrahedron(new Point(3, 3, 0), new Point(-2, 1, 0), new Point(6, 5, 11), new Point(0, 1, 9));

		tetrahedronFifth.setId(tetrahedronId + 4);
		tetrahedronFifth.setName(String.format(tetrahedronName, tetrahedronId + 4));

		tetrahedronSixth = new Tetrahedron(new Point(3, 3, 3), new Point(2, 1, 10), new Point(6, 5, 11), new Point(10, 1, 9));

		tetrahedronSixth.setId(tetrahedronId + 10);
		tetrahedronSixth.setName(String.format(tetrahedronName, tetrahedronId + 10));

		tetrahedronRepository = TetrahedronRepositoryImpl.getInstance();
	}

	@Test(priority = 1)
	public void addTetrahedronsTest() {
		List<Tetrahedron> tetrahedronList = new ArrayList<>();
		tetrahedronList.add(tetrahedronFirst);
		tetrahedronList.add(tetrahedronSecond);
		tetrahedronList.add(tetrahedronThird);
		tetrahedronList.add(tetrahedronFifth);

		DoubleFieldTetrahedronAccessor doubleFieldTetrahedronAccessor = new CoordinateZVertexTetrahedronAccessorImpl(new VertexATetrahedronTetrahedronAccessorImpl());
		BetweenDoubleTetrahedronCriterionImpl betweenDoubleTetrahedronCriterion = new BetweenDoubleTetrahedronCriterionImpl(doubleFieldTetrahedronAccessor, 1.0, 6.0);
		TetrahedronSpecification tetrahedronSpecification = new TetrahedronBetweenDoubleSpecificationImpl(betweenDoubleTetrahedronCriterion);

		tetrahedronRepository.addTetrahedrons(tetrahedronList, tetrahedronSpecification);

		tetrahedronList.remove(tetrahedronFifth);

		List<Tetrahedron> expected = tetrahedronList;
		List<Tetrahedron> actual = tetrahedronRepository.allTetrahedrons();

		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void addTetrahedronTest() {
		List<Tetrahedron> expected = new ArrayList<>();
		expected.add(tetrahedronFirst);
		expected.add(tetrahedronSecond);
		expected.add(tetrahedronThird);
		expected.add(tetrahedronFifth);

		tetrahedronRepository.addTetrahedron(tetrahedronFifth);

		List<Tetrahedron> actual = tetrahedronRepository.allTetrahedrons();

		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void removeTetrahedronsTest() {
		List<Tetrahedron> expected = new ArrayList<>();
		expected.add(tetrahedronFirst);

		IdTetrahedronAccessorImpl idTetrahedronAccessor = new IdTetrahedronAccessorImpl();
		SingleIntegerTetrahedronCriterionImpl singleIntegerTetrahedronCriterion = new SingleIntegerTetrahedronCriterionImpl(idTetrahedronAccessor, 1);
		TetrahedronSpecification tetrahedronSpecification = new TetrahedronMoreThanIntegerSpecificationImpl(singleIntegerTetrahedronCriterion);

		tetrahedronRepository.removeTetrahedrons(tetrahedronSpecification);

		List<Tetrahedron> actual = tetrahedronRepository.allTetrahedrons();

		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	public void removeTetrahedronTest() {
		List<Tetrahedron> expected = new ArrayList<>();

		tetrahedronRepository.removeTetrahedron(tetrahedronFirst);

		List<Tetrahedron> actual = tetrahedronRepository.allTetrahedrons();

		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void updateTetrahedronsTest() {
		List<Tetrahedron> tetrahedronList = new ArrayList<>();
		tetrahedronList.add(tetrahedronFirst);
		tetrahedronList.add(tetrahedronSecond);
		tetrahedronList.add(tetrahedronThird);
		tetrahedronList.add(tetrahedronFifth);
		tetrahedronList.add(tetrahedronFifth);

		int idOffset = 4;
		tetrahedronFirst.setId(tetrahedronId + idOffset++);
		tetrahedronSecond.setId(tetrahedronId + idOffset++);
		tetrahedronThird.setId(tetrahedronId + idOffset++);
		tetrahedronFourth.setId(tetrahedronId + idOffset++);
		tetrahedronFifth.setId(tetrahedronId + idOffset++);

		tetrahedronRepository.addTetrahedron(tetrahedronFirst);
		tetrahedronRepository.addTetrahedron(tetrahedronSecond);
		tetrahedronRepository.addTetrahedron(tetrahedronThird);
		tetrahedronRepository.addTetrahedron(tetrahedronFourth);
		tetrahedronRepository.addTetrahedron(tetrahedronFifth);

		IdTetrahedronAccessorImpl idTetrahedronAccessor = new IdTetrahedronAccessorImpl();
		SingleIntegerTetrahedronCriterionImpl singleIntegerTetrahedronCriterion = new SingleIntegerTetrahedronCriterionImpl(idTetrahedronAccessor, 5);
		TetrahedronSpecification tetrahedronSpecification = new TetrahedronEqualToSpecificationImpl(singleIntegerTetrahedronCriterion);

		CalculateUpdatingValue calculateUpdatingValue = (double x, double y) -> {
			return x * y;
		};

		TetrahedronZCoordinateUpdaterImpl tetrahedronZCoordinateUpdater = new TetrahedronZCoordinateUpdaterImpl(new VertexDTetrahedronTetrahedronAccessorImpl(), 10.0, calculateUpdatingValue);

		tetrahedronRepository.updateTetrahedrons(tetrahedronSpecification, tetrahedronZCoordinateUpdater);

		tetrahedronFirst.getVertexD().setCoordinateZ(50);

		Tetrahedron actual = tetrahedronRepository.tetrahedron(5);

		Tetrahedron expected = tetrahedronFirst;

		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 6)
	public void updateTetrahedronTest() {
		tetrahedronSecond.getVertexA().setCoordinateX(121.0);

		tetrahedronRepository.updateTetrahedron(tetrahedronSecond);

		Tetrahedron actual = tetrahedronRepository.tetrahedron(tetrahedronSecond.getId());

		Tetrahedron expected = tetrahedronSecond;

		Assert.assertEquals(actual, expected);
	}

	//find by id
	@Test(priority = 7)
	public void queryTestById() {
		IdTetrahedronAccessorImpl idTetrahedronAccessor = new IdTetrahedronAccessorImpl();
		SingleIntegerTetrahedronCriterionImpl singleIntegerTetrahedronCriterion = new SingleIntegerTetrahedronCriterionImpl(idTetrahedronAccessor, 7);
		TetrahedronSpecification tetrahedronSpecification = new TetrahedronEqualToSpecificationImpl(singleIntegerTetrahedronCriterion);

		List<Tetrahedron> actual = tetrahedronRepository.query(tetrahedronSpecification);
		List<Tetrahedron> expected = new ArrayList<>();
		expected.add(tetrahedronThird);

		Assert.assertEquals(actual, expected);
	}

	//find by name
	@Test(priority = 8)
	public void queryTestByName() {
		NameTetrahedronAccessorImpl nameTetrahedronAccessor = new NameTetrahedronAccessorImpl();
		SingleStringTetrahedronCriterionImpl singleStringTetrahedronCriterion = new SingleStringTetrahedronCriterionImpl(nameTetrahedronAccessor, tetrahedronThird.getName());
		TetrahedronSpecification tetrahedronSpecification = new TetrahedronEqualToSpecificationImpl(singleStringTetrahedronCriterion);

		List<Tetrahedron> actual = tetrahedronRepository.query(tetrahedronSpecification);
		List<Tetrahedron> expected = new ArrayList<>();
		expected.add(tetrahedronThird);

		Assert.assertEquals(actual, expected);
	}


	//find by first quadrant
	@Test(priority = 9)
	public void queryTestByCoordinatesQuadrant() {
		VertexATetrahedronTetrahedronAccessorImpl vertexATetrahedronTetrahedronAccessor = new VertexATetrahedronTetrahedronAccessorImpl();
		VertexBTetrahedronTetrahedronAccessorImpl vertexBTetrahedronTetrahedronAccessor = new VertexBTetrahedronTetrahedronAccessorImpl();
		VertexCTetrahedronTetrahedronAccessorImpl vertexCTetrahedronTetrahedronAccessor = new VertexCTetrahedronTetrahedronAccessorImpl();
		VertexDTetrahedronTetrahedronAccessorImpl vertexDTetrahedronTetrahedronAccessor = new VertexDTetrahedronTetrahedronAccessorImpl();

		//point A
		CoordinateXVertexTetrahedronAccessorImpl coordinateXVertexTetrahedronAccessor = new CoordinateXVertexTetrahedronAccessorImpl(vertexATetrahedronTetrahedronAccessor);
		CoordinateYVertexTetrahedronAccessorImpl coordinateYVertexTetrahedronAccessor = new CoordinateYVertexTetrahedronAccessorImpl(vertexATetrahedronTetrahedronAccessor);
		CoordinateZVertexTetrahedronAccessorImpl coordinateZVertexTetrahedronAccessor = new CoordinateZVertexTetrahedronAccessorImpl(vertexATetrahedronTetrahedronAccessor);


		TetrahedronSpecification tetrahedronSpecification = new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateXVertexTetrahedronAccessor, 0.0)).
				and(new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateYVertexTetrahedronAccessor, 0.0))).
				and(new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateZVertexTetrahedronAccessor, 0.0)));

		//point B
		coordinateXVertexTetrahedronAccessor = new CoordinateXVertexTetrahedronAccessorImpl(vertexBTetrahedronTetrahedronAccessor);
		coordinateYVertexTetrahedronAccessor = new CoordinateYVertexTetrahedronAccessorImpl(vertexBTetrahedronTetrahedronAccessor);
		coordinateZVertexTetrahedronAccessor = new CoordinateZVertexTetrahedronAccessorImpl(vertexBTetrahedronTetrahedronAccessor);

		tetrahedronSpecification = tetrahedronSpecification.and(new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateXVertexTetrahedronAccessor, 0.0)).
				and(new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateYVertexTetrahedronAccessor, 0.0))).
				and(new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateZVertexTetrahedronAccessor, 0.0))));

		//point C
		coordinateXVertexTetrahedronAccessor = new CoordinateXVertexTetrahedronAccessorImpl(vertexCTetrahedronTetrahedronAccessor);
		coordinateYVertexTetrahedronAccessor = new CoordinateYVertexTetrahedronAccessorImpl(vertexCTetrahedronTetrahedronAccessor);
		coordinateZVertexTetrahedronAccessor = new CoordinateZVertexTetrahedronAccessorImpl(vertexCTetrahedronTetrahedronAccessor);

		tetrahedronSpecification = tetrahedronSpecification.and(new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateXVertexTetrahedronAccessor, 0.0)).
				and(new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateYVertexTetrahedronAccessor, 0.0))).
				and(new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateZVertexTetrahedronAccessor, 0.0))));


		//point D
		coordinateXVertexTetrahedronAccessor = new CoordinateXVertexTetrahedronAccessorImpl(vertexDTetrahedronTetrahedronAccessor);
		coordinateYVertexTetrahedronAccessor = new CoordinateYVertexTetrahedronAccessorImpl(vertexDTetrahedronTetrahedronAccessor);
		coordinateZVertexTetrahedronAccessor = new CoordinateZVertexTetrahedronAccessorImpl(vertexDTetrahedronTetrahedronAccessor);

		tetrahedronSpecification = tetrahedronSpecification.and(new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateXVertexTetrahedronAccessor, 0.0)).
				and(new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateYVertexTetrahedronAccessor, 0.0))).
				and(new TetrahedronMoreThanDoubleSpecificationImpl(new SingleDoubleTetrahedronCriterionImpl(coordinateZVertexTetrahedronAccessor, 0.0))));

		tetrahedronRepository.addTetrahedron(tetrahedronSixth);
		List<Tetrahedron> actual = tetrahedronRepository.query(tetrahedronSpecification);
		List<Tetrahedron> expected = new ArrayList<>();
		expected.add(tetrahedronSixth);

		Assert.assertEquals(actual, expected);
	}


	//find by square range
	@Test(priority = 10)
	public void queryTestBySquareRange() {
		TotalSquareTetrahedronAccessorImpl totalSquareTetrahedronAccessor = new TotalSquareTetrahedronAccessorImpl(TetrahedronRegisterImpl.getInstance());
		BetweenDoubleTetrahedronCriterionImpl betweenDoubleTetrahedronCriterion = new BetweenDoubleTetrahedronCriterionImpl(totalSquareTetrahedronAccessor, 10.0, 20.0);


		TetrahedronSpecification tetrahedronSpecification = new TetrahedronBetweenDoubleSpecificationImpl(betweenDoubleTetrahedronCriterion);

		List<Tetrahedron> actual = tetrahedronRepository.query(tetrahedronSpecification);
		List<Tetrahedron> expected = new ArrayList<>();
		expected.add(tetrahedronFirst);

		Assert.assertEquals(actual, expected);
	}


	//find by distance
	@Test(priority = 11)
	public void queryTestByCoordinatesDistance() {
		VertexATetrahedronTetrahedronAccessorImpl vertexATetrahedronTetrahedronAccessor = new VertexATetrahedronTetrahedronAccessorImpl();
		VertexBTetrahedronTetrahedronAccessorImpl vertexBTetrahedronTetrahedronAccessor = new VertexBTetrahedronTetrahedronAccessorImpl();
		VertexCTetrahedronTetrahedronAccessorImpl vertexCTetrahedronTetrahedronAccessor = new VertexCTetrahedronTetrahedronAccessorImpl();
		VertexDTetrahedronTetrahedronAccessorImpl vertexDTetrahedronTetrahedronAccessor = new VertexDTetrahedronTetrahedronAccessorImpl();

		//point A
		CoordinateXVertexTetrahedronAccessorImpl coordinateXVertexTetrahedronAccessor = new CoordinateXVertexTetrahedronAccessorImpl(vertexATetrahedronTetrahedronAccessor);
		CoordinateYVertexTetrahedronAccessorImpl coordinateYVertexTetrahedronAccessor = new CoordinateYVertexTetrahedronAccessorImpl(vertexATetrahedronTetrahedronAccessor);
		CoordinateZVertexTetrahedronAccessorImpl coordinateZVertexTetrahedronAccessor = new CoordinateZVertexTetrahedronAccessorImpl(vertexATetrahedronTetrahedronAccessor);

		TetrahedronSpecification tetrahedronSpecification = new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateXVertexTetrahedronAccessor, 0.0, 11.0)).
				and(new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateYVertexTetrahedronAccessor, 0.0, 11.0))).
				and(new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateZVertexTetrahedronAccessor, 0.0, 11.0)));

		//point B
		coordinateXVertexTetrahedronAccessor = new CoordinateXVertexTetrahedronAccessorImpl(vertexBTetrahedronTetrahedronAccessor);
		coordinateYVertexTetrahedronAccessor = new CoordinateYVertexTetrahedronAccessorImpl(vertexBTetrahedronTetrahedronAccessor);
		coordinateZVertexTetrahedronAccessor = new CoordinateZVertexTetrahedronAccessorImpl(vertexBTetrahedronTetrahedronAccessor);

		tetrahedronSpecification = tetrahedronSpecification.and(new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateXVertexTetrahedronAccessor, 0.0, 11.0)).
				and(new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateYVertexTetrahedronAccessor, 0.0, 11.0))).
				and(new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateZVertexTetrahedronAccessor, 0.0, 11.0))));

		//point C
		coordinateXVertexTetrahedronAccessor = new CoordinateXVertexTetrahedronAccessorImpl(vertexCTetrahedronTetrahedronAccessor);
		coordinateYVertexTetrahedronAccessor = new CoordinateYVertexTetrahedronAccessorImpl(vertexCTetrahedronTetrahedronAccessor);
		coordinateZVertexTetrahedronAccessor = new CoordinateZVertexTetrahedronAccessorImpl(vertexCTetrahedronTetrahedronAccessor);

		tetrahedronSpecification = tetrahedronSpecification.and(new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateXVertexTetrahedronAccessor, 0.0, 11.0)).
				and(new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateYVertexTetrahedronAccessor, 0.0, 11.0))).
				and(new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateZVertexTetrahedronAccessor, 0.0, 11.0))));

		//point D
		coordinateXVertexTetrahedronAccessor = new CoordinateXVertexTetrahedronAccessorImpl(vertexDTetrahedronTetrahedronAccessor);
		coordinateYVertexTetrahedronAccessor = new CoordinateYVertexTetrahedronAccessorImpl(vertexDTetrahedronTetrahedronAccessor);
		coordinateZVertexTetrahedronAccessor = new CoordinateZVertexTetrahedronAccessorImpl(vertexDTetrahedronTetrahedronAccessor);

		tetrahedronSpecification = tetrahedronSpecification.and(new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateXVertexTetrahedronAccessor, 0.0, 11.0)).
				and(new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateYVertexTetrahedronAccessor, 0.0, 11.0))).
				and(new TetrahedronBetweenDoubleSpecificationImpl(new BetweenDoubleTetrahedronCriterionImpl(coordinateZVertexTetrahedronAccessor, 0.0, 11.0))));

		List<Tetrahedron> actual = tetrahedronRepository.query(tetrahedronSpecification);

		List<Tetrahedron> expected = new ArrayList<>();
		expected.add(tetrahedronFourth);
		expected.add(tetrahedronSixth);

		Assert.assertEquals(actual, expected);
	}
}
