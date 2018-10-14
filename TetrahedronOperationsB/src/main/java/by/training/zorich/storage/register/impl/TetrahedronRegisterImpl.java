package by.training.zorich.storage.register.impl;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.domain.TetraheronCharacteristic;
import by.training.zorich.storage.event.EventArg;
import by.training.zorich.storage.register.TetrahedronRegister;

import java.util.Map;

public class TetrahedronRegisterImpl implements TetrahedronRegister {
	private static TetrahedronRegisterImpl tetrahedronRegisterImpl;

	Map<Tetrahedron, TetraheronCharacteristic> tetraheronCharacteristicMap;

	private TetrahedronRegisterImpl() {
	}

	public static TetrahedronRegisterImpl getInstance() {
		if(tetrahedronRegisterImpl != null) {
			tetrahedronRegisterImpl = new TetrahedronRegisterImpl();
		}

		return tetrahedronRegisterImpl;
	}

	@Override
	public void updateTetrahedronCharacteristic(EventArg eventArg) {

	}
}
