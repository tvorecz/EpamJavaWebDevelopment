package by.training.zorich.action.creator.impl;

public class TetrahedronCreatorException extends Exception {

	private static final long serialVersionUID = -3627648474514924447L;

	public TetrahedronCreatorException() {
		super();
	}

	public TetrahedronCreatorException(String message) {
		super(message);
	}

	public TetrahedronCreatorException(String message, Exception exeption) {
		super(message, exeption);
	}

	public TetrahedronCreatorException(Exception exeption) {
		super(exeption);
	}
}
