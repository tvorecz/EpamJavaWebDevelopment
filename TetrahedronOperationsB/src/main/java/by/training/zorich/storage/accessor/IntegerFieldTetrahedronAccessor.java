package by.training.zorich.storage.accessor;

import by.training.zorich.domain.Tetrahedron;

public interface IntegerFieldTetrahedronAccessor extends TetrahedronFieldAccessor {
	Integer extractTetrahedronField(Tetrahedron tetrahedron);
}
