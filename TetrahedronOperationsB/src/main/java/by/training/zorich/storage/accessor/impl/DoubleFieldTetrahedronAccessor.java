package by.training.zorich.storage.accessor.impl;

import by.training.zorich.domain.Tetrahedron;

public interface DoubleFieldTetrahedronAccessor extends TetrahedronFieldAccessor {
	Double extractTetrahedronField(Tetrahedron tetrahedron);
}
