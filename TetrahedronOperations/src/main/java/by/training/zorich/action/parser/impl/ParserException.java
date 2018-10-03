package by.training.zorich.action.parser.impl;

public class ParserException extends Exception {
	private final static String ERROR = "Unknown error";

	public ParserException() {
		super(ERROR);
	}

	public ParserException(String message) {
		super(message);
	}

	public ParserException(String message, Exception exeption) {
		super(message, exeption);
	}

	public ParserException(Exception exeption) {
		super(exeption);
	}
}
