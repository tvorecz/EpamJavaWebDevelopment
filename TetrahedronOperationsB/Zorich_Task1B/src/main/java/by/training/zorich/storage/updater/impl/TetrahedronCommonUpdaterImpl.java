package by.training.zorich.storage.updater.impl;

import by.training.zorich.storage.updater.TetrahedronUpdater;

public abstract class TetrahedronCommonUpdaterImpl implements TetrahedronUpdater {
	public TetrahedronUpdater and(TetrahedronUpdater otherTetrahedronUpdater) {
		return new TetrahedronAndUpdaterImpl(this, otherTetrahedronUpdater);
	}

}
