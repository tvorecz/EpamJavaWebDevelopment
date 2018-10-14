package by.training.zorich.action.reader;

import java.util.List;

public interface TextFileReader {
	List<String> getValidData(String uri) throws TextFileReaderException;
}
