package by.training.zorich.action.creator.impl;

import by.training.zorich.action.creator.TetrahedronCreator;
import by.training.zorich.action.parser.CoordinatesTetrahedronParser;
import by.training.zorich.action.parser.CoordinatesTetrahedronParserExсeption;
import by.training.zorich.action.reader.TextFileReader;
import by.training.zorich.action.reader.TextFileReaderException;
import by.training.zorich.domain.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TetrahedronCreatorImpl implements TetrahedronCreator {
	private String uri;
	private TextFileReader textFileReader;
	private CoordinatesTetrahedronParser coordinatesTetrahedronParser;

	private final static Logger LOGGER = LogManager.getLogger(TetrahedronCreatorImpl.class);

	public TetrahedronCreatorImpl(TextFileReader textFileReader, CoordinatesTetrahedronParser coordinatesTetrahedronParser, String uri) {
		this.textFileReader = textFileReader;
		this.coordinatesTetrahedronParser = coordinatesTetrahedronParser;
		this.uri = uri;
	}


	@Override
	public List<Tetrahedron> createTetraherdons() {
		List<Tetrahedron> tetrahedronList = Collections.emptyList();

		try {
			List<String> linesWithTetrahedronCoordinates = textFileReader.getValidData(uri);
			List<double[][]> tetrahedronsCoordinates = coordinatesTetrahedronParser.parseTetrahedronsVertexesCoordinates(linesWithTetrahedronCoordinates);

			tetrahedronList = new ArrayList<>();

			for (double[][] tetrahedronsCoordinate : tetrahedronsCoordinates) {
				Tetrahedron tetrahedron = new Tetrahedron(tetrahedronsCoordinate);
				tetrahedronList.add(tetrahedron);
			}

		} catch (TextFileReaderException ex) {
			LOGGER.error(ex);

		} catch (CoordinatesTetrahedronParserExсeption ex) {
			LOGGER.error(ex);
		}

		return tetrahedronList;
	}
}
