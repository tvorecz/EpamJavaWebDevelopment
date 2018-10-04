package by.training.zorich.action.parser.impl;

public class ParserException extends Exception {
	private static final long serialVersionUID = 5846774251042920266L;

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
