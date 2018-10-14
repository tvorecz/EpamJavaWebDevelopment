package by.training.zorich.action.reader;

public class TextFileReaderException extends Exception {
	private static final long serialVersionUID = -7037750780485478604L;

	public TextFileReaderException() {
		super();
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
