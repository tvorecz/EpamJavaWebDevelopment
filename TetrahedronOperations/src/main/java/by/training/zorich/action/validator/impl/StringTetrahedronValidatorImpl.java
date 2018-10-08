package by.training.zorich.action.validator.impl;

import by.training.zorich.action.validator.StringTetrahedronValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTetrahedronValidatorImpl implements StringTetrahedronValidator {
	private static final String PATTERN = "(((-?\\d+(\\.\\d*)?\\s+){2}(-?\\d+(\\.\\d*)?&+)){3}((-?\\d+(\\.\\d*)?\\s+){2}(-?\\d+(\\.\\d*)?$)))";
	//	private static final Pattern pattern = Pattern.compile(PATTERN);
	private Pattern pattern;

	public StringTetrahedronValidatorImpl() {
		this.pattern = Pattern.compile(PATTERN);
	}

	public boolean isValid(String tetrahedronVertexesCoordinates) {
		Matcher matcher = pattern.matcher(tetrahedronVertexesCoordinates);
		return matcher.matches();
	}
}
