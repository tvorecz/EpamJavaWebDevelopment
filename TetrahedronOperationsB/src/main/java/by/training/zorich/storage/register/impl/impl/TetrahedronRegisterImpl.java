package by.training.zorich.storage.register.impl.impl;

import by.training.zorich.action.executor.TetrahedronExecutor;
import by.training.zorich.action.executor.impl.TetrahedronExecutorImpl;
import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.domain.TetrahedronCharacteristic;
import by.training.zorich.storage.event.EventListener;
import by.training.zorich.storage.event.impl.arg.EventArg;
import by.training.zorich.storage.register.impl.TetrahedronRegister;

import java.util.HashMap;
import java.util.Map;

public class TetrahedronRegisterImpl implements TetrahedronRegister, EventListener {
	private static TetrahedronRegisterImpl tetrahedronRegisterImpl;

	private Map<Integer, TetrahedronCharacteristic> tetrahedronsCharacteristicsMap;
	private TetrahedronExecutor tetrahedronExecutor;

	private TetrahedronRegisterImpl() {
		tetrahedronsCharacteristicsMap = new HashMap<>();
		tetrahedronExecutor = new TetrahedronExecutorImpl();
	}

	public static TetrahedronRegisterImpl getInstance() {
		if (tetrahedronRegisterImpl == null) {
			tetrahedronRegisterImpl = new TetrahedronRegisterImpl();
		}

		return tetrahedronRegisterImpl;
	}

	@Override
	public void addTetrahedron(EventArg eventArg) {
		TetrahedronCharacteristic tetrahedronCharacteristic = calculateTetraheronCharacteristic(eventArg.getChangedTetrahedron());
		tetrahedronsCharacteristicsMap.put(eventArg.getChangedTetrahedron().getId(), tetrahedronCharacteristic);
	}

	@Override
	public void updateTetrahedron(EventArg eventArg) {
		TetrahedronCharacteristic tetrahedronCharacteristic = calculateTetraheronCharacteristic(eventArg.getChangedTetrahedron());
		tetrahedronsCharacteristicsMap.replace(eventArg.getChangedTetrahedron().getId(), tetrahedronCharacteristic);
	}

	@Override
	public void deleteTetrahedron(EventArg eventArg) {
		tetrahedronsCharacteristicsMap.remove(eventArg.getChangedTetrahedron().getId());
	}

	@Override
	public double perimeter(int tetrahedronId) {
		return tetrahedronsCharacteristicsMap.get(tetrahedronId).getPerimeter();
	}

	@Override
	public double volume(int tetrahedronId) {
		return tetrahedronsCharacteristicsMap.get(tetrahedronId).getVolume();
	}

	@Override
	public double totalSquare(int tetrahedronId) {
		return tetrahedronsCharacteristicsMap.get(tetrahedronId).getSquare();
	}

	private TetrahedronCharacteristic calculateTetraheronCharacteristic(Tetrahedron tetrahedron) {
		TetrahedronCharacteristic tetrahedronCharacteristic = new TetrahedronCharacteristic();

		tetrahedronCharacteristic.setVolume(tetrahedronExecutor.calculateVolume(tetrahedron));
		tetrahedronCharacteristic.setSquare(tetrahedronExecutor.calculateTotalSquare(tetrahedron));
		tetrahedronCharacteristic.setPerimeter(tetrahedronExecutor.calculatePerimeter(tetrahedron));

		return tetrahedronCharacteristic;
	}
}
