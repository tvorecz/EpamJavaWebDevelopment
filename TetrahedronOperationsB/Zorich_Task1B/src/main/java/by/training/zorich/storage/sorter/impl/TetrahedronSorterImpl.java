package by.training.zorich.storage.sorter.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.sorter.TetrahedronComparator;
import by.training.zorich.storage.sorter.TetrahedronSorter;

import java.util.Collections;
import java.util.List;

public class TetrahedronSorterImpl implements TetrahedronSorter {

	@Override
	public void sort(List<Tetrahedron> tetrahedrons, TetrahedronComparator comparator) {
		Collections.sort(tetrahedrons, comparator);
	}
}
