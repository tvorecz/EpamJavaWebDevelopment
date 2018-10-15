package by.training.zorich.storage.sorter;

import by.training.zorich.domain.Tetrahedron;

import java.util.Comparator;

public class TetrahedronIdComparator implements Comparator<Tetrahedron> {
	@Override
	public int compare(Tetrahedron o1, Tetrahedron o2) {
		return (new Integer(o1.getId()).compareTo(new Integer(o2.getId())));
	}
}
