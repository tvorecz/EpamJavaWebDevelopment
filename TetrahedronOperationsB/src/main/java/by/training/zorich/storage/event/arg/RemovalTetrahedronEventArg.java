package by.training.zorich.storage.event.arg;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.event.EventType;

public class RemovalTetrahedronEventArg extends EventArg{
	public RemovalTetrahedronEventArg(Tetrahedron removedTetrahedron, EventType eventType) {
		super(removedTetrahedron, eventType);
	}
}
