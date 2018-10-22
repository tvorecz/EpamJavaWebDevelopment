package by.training.zorich.storage.updater;

import by.training.zorich.domain.Tetrahedron;

public interface TetrahedronUpdater {
	void update(Tetrahedron tetrahedron);

	TetrahedronUpdater and(TetrahedronUpdater otherTetrahedronUpdater);
}
