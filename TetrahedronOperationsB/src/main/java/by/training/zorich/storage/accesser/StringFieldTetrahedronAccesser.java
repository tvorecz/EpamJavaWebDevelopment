package by.training.zorich.storage.accesser;

import by.training.zorich.domain.Tetrahedron;

public interface StringFieldTetrahedronAccesser extends TetrahedronFieldAccesser {
	String extractTetrahedronField(Tetrahedron tetrahedron);
}
