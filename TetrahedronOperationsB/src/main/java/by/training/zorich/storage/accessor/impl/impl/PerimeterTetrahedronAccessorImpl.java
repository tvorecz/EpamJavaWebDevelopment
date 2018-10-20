package by.training.zorich.storage.accessor.impl.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accessor.impl.DoubleFieldTetrahedronAccessor;
import by.training.zorich.storage.register.impl.TetrahedronRegister;

public class PerimeterTetrahedronAccessorImpl implements DoubleFieldTetrahedronAccessor {
	TetrahedronRegister tetrahedronRegister;

	public PerimeterTetrahedronAccessorImpl(TetrahedronRegister tetrahedronRegister) {
		this.tetrahedronRegister = tetrahedronRegister;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedronRegister.perimeter(tetrahedron.getId());
	}
}
