package by.training.zorich.storage.extractant.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.extractant.StringFieldTetrahedronExtractant;

public class NameTetrahedronExtractantImpl implements StringFieldTetrahedronExtractant {
	@Override
	public String extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedron.getName();
	}
}
