package by.training.zorich.action.reader.impl;

import by.training.zorich.action.reader.Reader;
import by.training.zorich.action.validator.StringTetrahedronValidator;
import by.training.zorich.action.validator.impl.StringTetrahedronValidatorImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class ReaderImpl implements Reader {
	private final static String NOT_READED = "Reading file is failed.";

	private String uri;
	private StringTetrahedronValidator stringTetrahedronValidator;


	public ReaderImpl(String uri) {
		this.uri = uri;
		stringTetrahedronValidator = new StringTetrahedronValidatorImpl();
	}

	@Override
	public List<String> getValidData() throws ReaderException {
		try {
			List<String> lines = Files.readAllLines(Paths.get(uri));

			Iterator<String> linesIterator = lines.iterator();

			while (linesIterator.hasNext()) {
				String currentLine = linesIterator.next();
				if (!stringTetrahedronValidator.isValid(currentLine)) {
					linesIterator.remove();
				}
			}

			return lines;
		} catch (IOException ex) {
			throw new ReaderException(NOT_READED, ex);
		}
	}
}
