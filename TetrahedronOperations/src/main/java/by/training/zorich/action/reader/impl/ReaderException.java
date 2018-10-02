package by.training.zorich.action.reader.impl;

public class ReaderException extends Exception {
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
