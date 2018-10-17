package by.training.zorich.storage.extractant;

import by.training.zorich.domain.Tetrahedron;

public interface StringFieldTetrahedronExtractant extends TetrahedronFieldExtractant {
	String extractTetrahedronField(Tetrahedron tetrahedron);
}
