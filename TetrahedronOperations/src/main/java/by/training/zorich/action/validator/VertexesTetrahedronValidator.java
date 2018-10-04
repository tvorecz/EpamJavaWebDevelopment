package by.training.zorich.action.validator;

import sun.security.provider.certpath.Vertex;

public interface VertexesTetrahedronValidator {
	boolean isValid(Vertex vertexA, Vertex vertexB, Vertex vertexC, Vertex vertexD);
}
