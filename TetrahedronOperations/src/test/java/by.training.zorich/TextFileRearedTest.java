package by.training.zorich;

import by.training.zorich.action.reader.impl.TextFileReaderException;
import by.training.zorich.action.reader.impl.TextFileReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TextFileRearedTest {
	@Test
	public void testTextReaderTest() throws TextFileReaderException{
		//TODO: почему не проходит проверку
		TextFileReaderImpl textFileReader = new TextFileReaderImpl();

		List<String> actual = textFileReader.getValidData("repository/testData.txt");

		List<String> expected = new ArrayList<>();
		expected.add("2 -1 2&2 1 3&1 0 1&6 4 5");
		expected.add("1 3 6&2 2 1&-1                0 1&-4 6 -3");

		Assert.assertEquals(actual, expected);
	}
}
