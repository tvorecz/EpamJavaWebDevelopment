package by.training.zorich.action.reader.impl;

import by.training.zorich.action.reader.Reader;
import by.training.zorich.action.validator.Validator;
import by.training.zorich.action.validator.impl.ValidatorImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReaderImpl implements Reader {
	private final static String NOT_READED = "Reading file is failed.";

	private final String uri;
	private Validator validator;
	private List<String> lines;

	public ReaderImpl(String uri) {
		this.uri = uri;
		validator = new ValidatorImpl();
	}

	@Override
	public List<String> getValidData() throws ReaderException {
		try {
			readFile();
			return validator.getCorrestData(lines);
		} catch (IOException ex) {
			throw new ReaderException(NOT_READED, ex);
		}

		finally {
			lines = null;
		}
	}

	private void readFile() throws IOException {
		lines = Files.readAllLines(Paths.get(uri));
	}
}
