package by.training.zorich.storage.sorter;

import by.training.zorich.domain.Tetrahedron;

import java.util.List;

public interface TetrahedronSorter {
	void sort(List<Tetrahedron> tetrahedrons, TetrahedronComparator comparator);
}
