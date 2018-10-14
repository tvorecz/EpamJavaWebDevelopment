package by.training.zorich.storage.repository.impl;

import by.training.zorich.storage.event.EventArg;
import by.training.zorich.storage.event.EventListener;
import by.training.zorich.storage.repository.TetrahedronRepository;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronRepositoryImpl implements TetrahedronRepository {
	private static TetrahedronRepositoryImpl tetrahedronRegisterImpl;
	private List<EventListener> eventListeners;

	private TetrahedronRepositoryImpl() {
		eventListeners = new ArrayList<EventListener>();
	}

	public static TetrahedronRepositoryImpl getInstance() {
		if(tetrahedronRegisterImpl == null) {
			tetrahedronRegisterImpl = new TetrahedronRepositoryImpl();
		}

		return tetrahedronRegisterImpl;
	}

	@Override
	public void subscribe(EventListener eventListener) {
		eventListeners.add(eventListener);
	}

	@Override
	public void unsubscribe(EventListener eventListener) {
		eventListeners.remove(eventListener);
	}

	@Override
	public void notifySubscribers(EventArg eventArg) {
		for (EventListener eventListener : eventListeners) {
			eventListener.updateTetrahedronCharacteristic(eventArg);
		}
	}
}
