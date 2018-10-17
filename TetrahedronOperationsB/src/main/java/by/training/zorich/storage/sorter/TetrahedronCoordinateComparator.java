package by.training.zorich.storage.sorter;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accesser.DoubleFieldTetrahedronAccesser;

import java.util.Comparator;

public class TetrahedronCoordinateComparator implements Comparator<Tetrahedron> {
	private DoubleFieldTetrahedronAccesser coordinateTetrahedronCriterion;

	public TetrahedronCoordinateComparator(DoubleFieldTetrahedronAccesser coordinateTetrahedronCriterion) {
		this.coordinateTetrahedronCriterion = coordinateTetrahedronCriterion;
	}

	@Override
	public int compare(Tetrahedron o1, Tetrahedron o2) {
		return coordinateTetrahedronCriterion.extractTetrahedronField(o1).compareTo(coordinateTetrahedronCriterion.extractTetrahedronField(o2));
	}
}
