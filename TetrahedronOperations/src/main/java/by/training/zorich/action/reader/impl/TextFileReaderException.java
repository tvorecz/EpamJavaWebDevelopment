package by.training.zorich.action.reader.impl;

public class TextFileReaderException extends Exception {
	private static final long serialVersionUID = -7037750780485478604L;

	private final static String ERROR = "Unknown error";

	public TextFileReaderException() {
		super(ERROR);
	}

	public TextFileReaderException(String message) {
		super(message);
	}

	public TextFileReaderException(String message, Exception exeption) {
		super(message, exeption);
	}

	public TextFileReaderException(Exception exeption) {
		super(exeption);
	}
}
