package by.training.zorich.storage.event.impl.arg;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.event.EventType;

public class EventArg {
	private Tetrahedron changedTetrahedron;
	EventType eventType;

	public EventArg(Tetrahedron changedTetrahedron, EventType eventType) {
		this.changedTetrahedron = changedTetrahedron;
		this.eventType = eventType;
	}

	public Tetrahedron getChangedTetrahedron() {
		return changedTetrahedron;
	}

	public EventType getEventType() {
		return eventType;
	}
}
