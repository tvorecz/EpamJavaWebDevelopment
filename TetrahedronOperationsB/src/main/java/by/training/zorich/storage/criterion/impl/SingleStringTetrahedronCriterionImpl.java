package by.training.zorich.storage.criterion.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.criterion.SingleTetrahedronCriterion;
import by.training.zorich.storage.accessor.StringFieldTetrahedronAccessor;

public class SingleStringTetrahedronCriterionImpl implements SingleTetrahedronCriterion {
	StringFieldTetrahedronAccessor stringFieldTetrahedronExtractant;
	String criterion;

	public SingleStringTetrahedronCriterionImpl(StringFieldTetrahedronAccessor stringFieldTetrahedronExtractant, String criterion) {
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
