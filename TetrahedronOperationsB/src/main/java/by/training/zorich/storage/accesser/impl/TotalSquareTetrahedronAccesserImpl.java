package by.training.zorich.storage.accesser.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accesser.DoubleFieldTetrahedronAccesser;
import by.training.zorich.storage.register.TetrahedronRegister;

public class TotalSquareTetrahedronAccesserImpl implements DoubleFieldTetrahedronAccesser {
	TetrahedronRegister tetrahedronRegister;

	public TotalSquareTetrahedronAccesserImpl(TetrahedronRegister tetrahedronRegister) {
		this.tetrahedronRegister = tetrahedronRegister;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedronRegister.totalSquare(tetrahedron.getId());
	}
}
