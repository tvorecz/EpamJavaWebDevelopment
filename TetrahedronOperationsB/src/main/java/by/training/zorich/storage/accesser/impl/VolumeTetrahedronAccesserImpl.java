package by.training.zorich.storage.accesser.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.accesser.DoubleFieldTetrahedronAccesser;
import by.training.zorich.storage.register.TetrahedronRegister;

public class VolumeTetrahedronAccesserImpl implements DoubleFieldTetrahedronAccesser {
	TetrahedronRegister tetrahedronRegister;

	public VolumeTetrahedronAccesserImpl(TetrahedronRegister tetrahedronRegister) {
		this.tetrahedronRegister = tetrahedronRegister;
	}

	@Override
	public Double extractTetrahedronField(Tetrahedron tetrahedron) {
		return tetrahedronRegister.volume(tetrahedron.getId());
	}
}
