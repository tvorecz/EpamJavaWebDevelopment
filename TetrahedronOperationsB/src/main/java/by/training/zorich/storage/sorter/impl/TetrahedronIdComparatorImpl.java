package by.training.zorich.storage.sorter.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.sorter.TetrahedronComparator;

import java.util.Comparator;

public class TetrahedronIdComparatorImpl implements TetrahedronComparator {
	@Override
	public int compare(Tetrahedron o1, Tetrahedron o2) {
		return (new Integer(o1.getId()).compareTo(new Integer(o2.getId())));
	}
}
