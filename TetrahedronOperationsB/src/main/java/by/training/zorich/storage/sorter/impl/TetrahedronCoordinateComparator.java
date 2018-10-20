package by.training.zorich.storage.sorter.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.DoubleFieldTetrahedronAccessor;

import java.util.Comparator;

public class TetrahedronCoordinateComparator implements Comparator<Tetrahedron> {
	private DoubleFieldTetrahedronAccessor coordinateTetrahedronCriterion;

	public TetrahedronCoordinateComparator(DoubleFieldTetrahedronAccessor coordinateTetrahedronCriterion) {
		this.coordinateTetrahedronCriterion = coordinateTetrahedronCriterion;
	}

	@Override
	public int compare(Tetrahedron o1, Tetrahedron o2) {
		return coordinateTetrahedronCriterion.extractTetrahedronField(o1).compareTo(coordinateTetrahedronCriterion.extractTetrahedronField(o2));
	}
}
