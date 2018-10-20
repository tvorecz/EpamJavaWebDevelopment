package by.training.zorich.storage.event.impl.manager;

import by.training.zorich.storage.event.EventListener;
import by.training.zorich.storage.event.EventPublisher;
import by.training.zorich.storage.event.EventType;
import by.training.zorich.storage.event.impl.arg.EventArg;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronEventManager implements EventPublisher {
	private static TetrahedronEventManager tetrahedronEventManager;

	private List<EventListener> eventAdditionListeners;
	private List<EventListener> eventRemovalListeners;
	private List<EventListener> eventModificationListeners;

	private TetrahedronEventManager() {
		eventAdditionListeners = new ArrayList<EventListener>();
		eventRemovalListeners = new ArrayList<EventListener>();
		eventModificationListeners = new ArrayList<EventListener>();
	}

	public static TetrahedronEventManager getInstance() {
		if (tetrahedronEventManager == null) {
			tetrahedronEventManager = new TetrahedronEventManager();
		}

		return tetrahedronEventManager;
	}

	@Override
	public void subscribe(EventListener eventListener, EventType eventType) {
		List<EventListener> correctListenerList = correctListenersList(eventType);
		correctListenerList.add(eventListener);
	}

	@Override
	public void unsubscribe(EventListener eventListener, EventType eventType) {
		List<EventListener> correctListenerList = correctListenersList(eventType);
		correctListenerList.remove(eventListener);
	}

	@Override
	public void notifySubscribers(EventArg eventArg) {
		List<EventListener> correctListenerList = correctListenersList(eventArg.getEventType());

		if (eventArg.getEventType() == EventType.ADD) {
			for (EventListener eventListener : correctListenerList) {
				eventListener.addTetrahedron(eventArg);
			}
		} else if (eventArg.getEventType() == EventType.REMOVE) {
			for (EventListener eventListener : correctListenerList) {
				eventListener.deleteTetrahedron(eventArg);
			}
		} else {//if(eventArg.getEventType() == EventType.UPDATE) {
			for (EventListener eventListener : correctListenerList) {
				eventListener.updateTetrahedron(eventArg);
			}
		}
	}

	private List<EventListener> correctListenersList(EventType eventType) {
		if (eventType == EventType.ADD) {
			return eventAdditionListeners;
		} else if (eventType == EventType.REMOVE) {
			return eventRemovalListeners;
		} else {//if(eventType == EventType.UPDATE) {
			return eventModificationListeners;
		}
	}
}
