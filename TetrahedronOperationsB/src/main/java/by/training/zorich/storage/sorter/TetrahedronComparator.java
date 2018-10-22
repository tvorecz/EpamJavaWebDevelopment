package by.training.zorich.storage.sorter;

import by.training.zorich.domain.Tetrahedron;

import java.util.Comparator;

public interface TetrahedronComparator extends Comparator<Tetrahedron> {
	int compare(Tetrahedron o1, Tetrahedron o2);
}
