package by.training.zorich.action.validator.impl;

import by.training.zorich.action.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
	private static final String PATTERN = "(((-?\\d+(\\.\\d*)?\\s+){2}(-?\\d+(\\.\\d*)?&+)){3}((-?\\d+(\\.\\d*)?\\s+){2}(-?\\d+(\\.\\d*)?$)))";
	private static final Pattern pattern = Pattern.compile(PATTERN);
	;

	private boolean isValidData(String data) {
		Matcher matcher = pattern.matcher(data);
		return matcher.matches();
	}

	@Override
	public List<String> getCorrestData(List<String> lines) {
		List<String> result = new ArrayList<String>();
		for (String line:
			 lines) {
			if(isValidData(line))
				result.add(line);
		}

		if(result.isEmpty())
			return null;
		else
			return result;
	}
}
