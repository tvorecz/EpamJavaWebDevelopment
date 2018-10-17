package by.training.zorich.storage.extractant.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.extractant.IntegerFieldTetrahedronExtractant;

public class IdTetrahedronExtractantImpl implements IntegerFieldTetrahedronExtractant {

	@Override
	public Integer extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedron.getId();
	}
}
