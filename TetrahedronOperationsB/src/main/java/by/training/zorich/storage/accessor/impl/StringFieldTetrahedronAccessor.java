package by.training.zorich.storage.accessor.impl;

import by.training.zorich.domain.Tetrahedron;

public interface StringFieldTetrahedronAccessor extends TetrahedronFieldAccessor {
	String extractTetrahedronField(Tetrahedron tetrahedron);
}
