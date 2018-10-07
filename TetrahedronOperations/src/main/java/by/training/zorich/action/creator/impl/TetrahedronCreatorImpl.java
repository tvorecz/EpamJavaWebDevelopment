package by.training.zorich.action.creator.impl;

import by.training.zorich.action.creator.PolyhedronCreator;
import by.training.zorich.action.parser.CoordinatesPolyhedronParser;
import by.training.zorich.action.parser.impl.CoordinatesTetrahedronParserExсeption;
import by.training.zorich.action.reader.TextFileReader;
import by.training.zorich.action.reader.impl.TextFileReaderException;
import by.training.zorich.domain.Polyhedron;
import by.training.zorich.domain.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TetrahedronCreatorImpl implements PolyhedronCreator {
	private String uri = "repository/data.txt";
	private TextFileReader textFileReader;
	private CoordinatesPolyhedronParser coordinatesPolyhedronParser;

	private final static Logger creatorlogger = LogManager.getLogger(TetrahedronCreatorImpl.class);

	public TetrahedronCreatorImpl(TextFileReader textFileReader, CoordinatesPolyhedronParser coordinatesPolyhedronParser, String uri) {
		this.textFileReader = textFileReader;
		this.coordinatesPolyhedronParser = coordinatesPolyhedronParser;
		this.uri = uri;
	}


	@Override
	public List<Polyhedron> createPolyherdons() throws TetrahedronCreatorException{
		List<Polyhedron> tetrahedronList = Collections.emptyList();
		try {
			List<String> linesWithTetrahedronCoordinates = textFileReader.getValidData(uri);
			List<double[][]> tetrahedronsCoordinates = coordinatesPolyhedronParser.getTetrahedronsCoordinates(linesWithTetrahedronCoordinates);

			tetrahedronList = new ArrayList<>();

			for (double[][] tetrahedronsCoordinate : tetrahedronsCoordinates) {
				tetrahedronList.add(new Tetrahedron(tetrahedronsCoordinate));
			}

		} catch (TextFileReaderException ex) {
			creatorlogger.error(ex.getStackTrace().toString());
			throw new TetrahedronCreatorException(ex);

		} catch (CoordinatesTetrahedronParserExсeption ex) {
			creatorlogger.error(ex.getStackTrace().toString());
			throw new TetrahedronCreatorException(ex);
		}

		return tetrahedronList;
	}
}
