package by.training.zorich.storage.accessor.impl.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.StringFieldTetrahedronAccessor;

public class NameTetrahedronAccessorImpl implements StringFieldTetrahedronAccessor {
	@Override
	public String extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedron.getName();
	}
}
