package by.training.zorich.storage.extractant;

import by.training.zorich.domain.Tetrahedron;

public interface DoubleFieldTetrahedronExtractant extends TetrahedronFieldExtractant {
	Double extractTetrahedronField(Tetrahedron tetrahedron);
}
