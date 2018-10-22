package by.training.zorich.storage.event.impl.arg;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.event.EventType;

public class AdditionTetrahedronEventArg extends EventArg {
	public AdditionTetrahedronEventArg(Tetrahedron addedTetrahedron, EventType eventType) {
		super(addedTetrahedron, eventType);
	}
}
