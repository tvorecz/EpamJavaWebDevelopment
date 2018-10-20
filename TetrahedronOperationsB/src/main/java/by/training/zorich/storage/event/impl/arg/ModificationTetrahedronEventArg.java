package by.training.zorich.storage.event.impl.arg;

import by.training.zorich.domain.Tetrahedron;
import by.training.zorich.storage.event.EventType;

public class ModificationTetrahedronEventArg extends EventArg {
	public ModificationTetrahedronEventArg(Tetrahedron modifiedTetrahedron, EventType eventType) {
		super(modifiedTetrahedron, eventType);
	}
}
