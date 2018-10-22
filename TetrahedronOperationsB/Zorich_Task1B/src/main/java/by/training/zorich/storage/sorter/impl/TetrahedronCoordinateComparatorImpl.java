package by.training.zorich.storage.sorter.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.DoubleFieldTetrahedronAccessor;
import by.training.zorich.storage.sorter.TetrahedronComparator;

import java.util.Comparator;

public class TetrahedronCoordinateComparatorImpl implements TetrahedronComparator {
	private DoubleFieldTetrahedronAccessor doubleFieldTetrahedronAccessor;

	public TetrahedronCoordinateComparatorImpl(DoubleFieldTetrahedronAccessor doubleFieldTetrahedronAccessor) {
		this.doubleFieldTetrahedronAccessor = doubleFieldTetrahedronAccessor;
	}

	@Override
	public int compare(Tetrahedron o1, Tetrahedron o2) {
		return doubleFieldTetrahedronAccessor.extractTetrahedronField(o1)
											 .compareTo(doubleFieldTetrahedronAccessor.extractTetrahedronField(o2));
	}
}
