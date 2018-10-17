package by.training.zorich.storage.accesser;

import by.training.zorich.domain.Tetrahedron;

public interface IntegerFieldTetrahedronAccesser extends TetrahedronFieldAccesser {
	Integer extractTetrahedronField(Tetrahedron tetrahedron);
}
