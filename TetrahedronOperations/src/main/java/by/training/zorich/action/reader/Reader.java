package by.training.zorich.action.reader;

import by.training.zorich.action.reader.impl.ReaderException;

import java.util.List;

public interface Reader {
	List<String> getValidData() throws ReaderException;
}
