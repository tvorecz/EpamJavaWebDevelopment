package by.training.zorich.storage.updater.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.updater.TetrahedronUpdater;

public class TetrahedronAndUpdaterImpl extends TetrahedronCommonUpdaterImpl {
	TetrahedronUpdater firstTetrahedronUpdater;
	TetrahedronUpdater secondTetrahedronUpdater;

	public TetrahedronAndUpdaterImpl(TetrahedronUpdater firstTetrahedronUpdater,
									 TetrahedronUpdater secondTetrahedronUpdater) {
		this.firstTetrahedronUpdater = firstTetrahedronUpdater;
		this.secondTetrahedronUpdater = secondTetrahedronUpdater;
	}

	@Override
	public void update(Tetrahedron tetrahedron) {
		firstTetrahedronUpdater.update(tetrahedron);
		secondTetrahedronUpdater.update(tetrahedron);
	}
}
