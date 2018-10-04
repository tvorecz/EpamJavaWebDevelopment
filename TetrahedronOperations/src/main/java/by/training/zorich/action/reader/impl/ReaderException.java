package by.training.zorich.action.reader.impl;

public class ReaderException extends Exception {
	private static final long serialVersionUID = -7037750780485478604L;

	private final static String ERROR = "Unknown error";

	public ReaderException() {
		super(ERROR);
	}

	public ReaderException(String message) {
		super(message);
	}

	public ReaderException(String message, Exception exeption) {
		super(message, exeption);
	}

	public ReaderException(Exception exeption) {
		super(exeption);
	}
}
