package by.training.zorich.storage.event;

import by.training.zorich.domain.Tetrahedron;

public class EventArg {
	private Tetrahedron updatingTetrahedron;
	EventType eventType;

	public EventArg(Tetrahedron updatingTetrahedron, EventType eventType) {
		this.updatingTetrahedron = updatingTetrahedron;
		this.eventType = eventType;
	}

	public Tetrahedron getUpdatingTetrahedron() {
		return updatingTetrahedron;
	}

	public EventType getEventType() {
		return eventType;
	}
}
