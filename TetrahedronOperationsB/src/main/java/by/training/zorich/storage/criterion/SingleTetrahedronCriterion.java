package by.training.zorich.storage.criterion;

import by.training.zorich.domain.Tetrahedron;

public interface SingleTetrahedronCriterion {
	Object criterionValue();
	Object extractTetrahedronField(Tetrahedron tetrahedron);
}
