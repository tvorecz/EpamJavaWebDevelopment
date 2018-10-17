package by.training.zorich.storage.accesser.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accesser.StringFieldTetrahedronAccesser;

public class NameTetrahedronAccesserImpl implements StringFieldTetrahedronAccesser {
	@Override
	public String extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedron.getName();
	}
}
