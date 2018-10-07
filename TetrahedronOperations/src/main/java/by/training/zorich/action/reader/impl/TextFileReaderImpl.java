package by.training.zorich.action.reader.impl;

import by.training.zorich.action.reader.TextFileReader;
import by.training.zorich.action.validator.StringTetrahedronValidator;
import by.training.zorich.action.validator.impl.StringTetrahedronValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextFileReaderImpl implements TextFileReader {
	private StringTetrahedronValidator stringTetrahedronValidator;

	private final static Logger readerlogger = LogManager.getLogger(TextFileReaderImpl.class);


	public TextFileReaderImpl() {
		stringTetrahedronValidator = new StringTetrahedronValidatorImpl();
	}

	@Override
	public List<String> getValidData(String uri) throws TextFileReaderException {
		List<String> linesWithTetrahedronCoordinates = Collections.emptyList();

		try (Stream<String> stream = Files.lines(Paths.get(uri))) {
			//List<String> linesWithTetrahedronCoordinates = Files.readAllLines(Paths.get(uri));

			linesWithTetrahedronCoordinates = stream.collect(Collectors.toList());

			Iterator<String> linesIterator = linesWithTetrahedronCoordinates.iterator();

			while (linesIterator.hasNext()) {
				String currentLine = linesIterator.next();
				if (!stringTetrahedronValidator.isValid(currentLine)) {
					linesIterator.remove();
				}
			}

		} catch (IOException ex) {
			readerlogger.error(ex.getStackTrace().toString());
			throw new TextFileReaderException("Reading file is failed.", ex);
		}

		return linesWithTetrahedronCoordinates;
	}
}
