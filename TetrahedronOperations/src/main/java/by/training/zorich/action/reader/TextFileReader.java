package by.training.zorich.action.reader;

import by.training.zorich.action.reader.impl.TextFileReaderException;

import java.util.List;

public interface TextFileReader {
	List<String> getValidData() throws TextFileReaderException;
}
