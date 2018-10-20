package by.training.zorich.storage.register.impl;

import by.training.zorich.storage.event.EventListener;

public interface TetrahedronRegister {
	double perimeter(int tetrahedronId);

	double volume(int tetrahedronId);

	double totalSquare(int tetrahedronId);
}
