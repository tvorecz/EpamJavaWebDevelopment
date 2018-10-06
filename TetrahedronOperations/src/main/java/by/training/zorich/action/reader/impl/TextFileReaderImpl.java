package by.training.zorich.action.reader.impl;

import by.training.zorich.action.reader.TextFileReader;
import by.training.zorich.action.validator.StringTetrahedronValidator;
import by.training.zorich.action.validator.impl.StringTetrahedronValidatorImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextFileReaderImpl implements TextFileReader {
	private final static String NOT_READED = "Reading file is failed.";

	private String uri;
	private StringTetrahedronValidator stringTetrahedronValidator;


	public TextFileReaderImpl(String uri) {
		this.uri = uri;
		stringTetrahedronValidator = new StringTetrahedronValidatorImpl();
	}

	@Override
	public List<String> getValidData() throws TextFileReaderException {
		List<String> lines = Collections.emptyList();

		try (Stream<String> stream = Files.lines(Paths.get(uri))) {
			//List<String> lines = Files.readAllLines(Paths.get(uri));

			lines = stream.collect(Collectors.toList());

		} catch (IOException ex) {
			throw new TextFileReaderException(NOT_READED, ex);
		}

		Iterator<String> linesIterator = lines.iterator();

		while (linesIterator.hasNext()) {
			String currentLine = linesIterator.next();
			if (!stringTetrahedronValidator.isValid(currentLine)) {
				linesIterator.remove();
			}
		}

		return lines;
	}
}
