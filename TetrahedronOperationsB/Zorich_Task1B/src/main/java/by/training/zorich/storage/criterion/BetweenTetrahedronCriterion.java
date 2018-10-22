package by.training.zorich.storage.criterion;

import by.training.zorich.domain.Tetrahedron;

public interface BetweenTetrahedronCriterion {
	Object criterionMinValue();

	Object criterionMaxValue();

	Object extractTetrahedronField(Tetrahedron tetrahedron);
}
