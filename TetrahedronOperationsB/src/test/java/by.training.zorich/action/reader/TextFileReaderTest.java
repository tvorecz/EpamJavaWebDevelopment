package by.training.zorich.action.reader;

import by.training.zorich.action.reader.TextFileReaderException;
import by.training.zorich.action.reader.impl.TextFileReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TextFileReaderTest {
	private final static String FIRST = "2 -1 2&2 1 3&1 0 1&6 4 5";
	private final static String SECOND = "1 3 6&2 2 1&-1                0 1&-4 6 -3";
	private static String uri;

	@BeforeTest
	public void createPath() {
		//		uri = TextFileReaderImpl.class.getClassLoader().getResource("testData.txt").getPath();
		uri = "C:\\Users\\tvore\\Documents\\EpamJavaWebDevelopment\\TetrahedronOperationsB\\target\\test-classes\\testData.txt";
	}

	@Test
	public void testTextReaderTest() throws TextFileReaderException {
		//TODO: почему не проходит проверку
		TextFileReaderImpl textFileReader = new TextFileReaderImpl();

		List<String> actual = textFileReader.getValidData(uri);

		List<String> expected = new ArrayList<>();
		expected.add(FIRST);
		expected.add(SECOND);

		Assert.assertEquals(actual, expected);
	}
}
