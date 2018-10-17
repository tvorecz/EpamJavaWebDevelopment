package by.training.zorich.storage.criterion.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.SingleTetrahedronCriterion;
import by.training.zorich.storage.accesser.StringFieldTetrahedronAccesser;

public class SingleStringTetrahedronCriterionImpl implements SingleTetrahedronCriterion {
	StringFieldTetrahedronAccesser stringFieldTetrahedronExtractant;
	String criterion;

	public SingleStringTetrahedronCriterionImpl(StringFieldTetrahedronAccesser stringFieldTetrahedronExtractant, String criterion) {
		this.stringFieldTetrahedronExtractant = stringFieldTetrahedronExtractant;
		this.criterion = criterion;
	}

	@Override
	public String criterionValue() {
		return criterion;
	}

	@Override
	public String extractTetrahedronField(Tetrahedron tetrahedron) {
		return stringFieldTetrahedronExtractant.extractTetrahedronField(tetrahedron);
	}
}
