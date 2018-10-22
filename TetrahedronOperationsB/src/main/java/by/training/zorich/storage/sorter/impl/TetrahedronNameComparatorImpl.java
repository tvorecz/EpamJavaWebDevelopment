package by.training.zorich.storage.sorter.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.sorter.TetrahedronComparator;

import java.util.Comparator;

public class TetrahedronNameComparatorImpl implements TetrahedronComparator {
	@Override
	public int compare(Tetrahedron o1, Tetrahedron o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
