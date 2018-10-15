package by.training.zorich.storage.sorter;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.extractant.CoordinateExtractant;

import java.util.Comparator;

public class TetrahedronCoordinateComparator implements Comparator<Tetrahedron> {
	private CoordinateExtractant coordinateExtractant;

	public TetrahedronCoordinateComparator(CoordinateExtractant coordinateExtractant) {
		this.coordinateExtractant = coordinateExtractant;
	}

	@Override
	public int compare(Tetrahedron o1, Tetrahedron o2) {
		if(coordinateExtractant.getValue(o1) > coordinateExtractant.getValue(o2)) {
			return 1;
		} else if( coordinateExtractant.getValue(o1) < coordinateExtractant.getValue(o2)) {
			return -1;
		} else {
			return 0;
		}
	}
}
