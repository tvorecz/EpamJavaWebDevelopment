package by.training.zorich.storage.accessor.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.IntegerFieldTetrahedronAccessor;

public class IdTetrahedronAccessorImpl implements IntegerFieldTetrahedronAccessor {

	@Override
	public Integer extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedron.getId();
	}
}
