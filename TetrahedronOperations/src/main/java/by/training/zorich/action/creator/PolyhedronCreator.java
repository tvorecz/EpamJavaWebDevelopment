package by.training.zorich.action.creator;

import by.training.zorich.action.creator.impl.TetrahedronCreatorException;
import by.training.zorich.domain.Polyhedron;

import java.util.List;

public interface PolyhedronCreator {
	List<Polyhedron> createPolyherdons() throws TetrahedronCreatorException;
}
