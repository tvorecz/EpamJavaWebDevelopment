package by.training.zorich.storage.extractant;

import by.training.zorich.domain.Tetrahedron;

public interface IntegerFieldTetrahedronExtractant extends TetrahedronFieldExtractant {
	Integer extractTetrahedronField(Tetrahedron tetrahedron);
}
