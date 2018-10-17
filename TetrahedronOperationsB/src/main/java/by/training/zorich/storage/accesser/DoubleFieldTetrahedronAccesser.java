package by.training.zorich.storage.accesser;

import by.training.zorich.domain.Tetrahedron;

public interface DoubleFieldTetrahedronAccesser extends TetrahedronFieldAccesser {
	Double extractTetrahedronField(Tetrahedron tetrahedron);
}
