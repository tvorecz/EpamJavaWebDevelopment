package by.training.zorich.storage.event;

import by.training.zorich.storage.event.arg.EventArg;

public interface EventListener {
	void addTetrahedron(EventArg eventArg);

	void updateTetrahedron(EventArg eventArg);

	void deleteTetrahedron(EventArg eventArg);
}
