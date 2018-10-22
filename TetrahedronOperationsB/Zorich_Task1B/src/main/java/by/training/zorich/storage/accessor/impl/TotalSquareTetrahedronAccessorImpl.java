package by.training.zorich.storage.accessor.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.DoubleFieldTetrahedronAccessor;
import by.training.zorich.storage.register.TetrahedronRegister;

public class TotalSquareTetrahedronAccessorImpl implements DoubleFieldTetrahedronAccessor {
	TetrahedronRegister tetrahedronRegister;

	public TotalSquareTetrahedronAccessorImpl(TetrahedronRegister tetrahedronRegister) {
		this.tetrahedronRegister = tetrahedronRegister;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedronRegister.totalSquare(tetrahedron.getId());
	}
}
