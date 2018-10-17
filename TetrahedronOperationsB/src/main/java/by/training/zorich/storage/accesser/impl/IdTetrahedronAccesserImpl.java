package by.training.zorich.storage.accesser.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accesser.IntegerFieldTetrahedronAccesser;

public class IdTetrahedronAccesserImpl implements IntegerFieldTetrahedronAccesser {

	@Override
	public Integer extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedron.getId();
	}
}
