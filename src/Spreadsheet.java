import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spreadsheet {

	private static final String STRING_CLASSIFIER = "'";
	private static final String EQUALS = "=";
	private static final String ERROR = "#ERROR";
	Map<String, String> sheet = new HashMap<>();

	public String get(String cell) {
		return sheet.get(cell);
	}

	public void set(String cell, String value) {
		sheet.put(cell, value);
	}

	public String evaluate(String cell) {
		String cellValue = sheet.get(cell);

		if (cellValue.startsWith(EQUALS)) {
			cellValue = cellValue.substring(1); // remove equal sign
			if (sheet.containsKey(cellValue)) {
				if (sheet.get(cellValue).substring(1).equals(cell)) {
					return "#CIRCULAR";
				}
				return evaluate(cellValue);
			}
		}

		if (cellValue.startsWith(STRING_CLASSIFIER)) {
			return evaluateString(cellValue);
		} else {
			return evaluateInt(cellValue);
		}
	}

	private String evaluateString(String cellStored) {
		if (cellStored.endsWith(STRING_CLASSIFIER)) {
			return cellStored.substring(1, cellStored.length() - 1);
		} else {
			return ERROR;
		}
	}

	private String evaluateInt(String cellStored) {
		try {
			char[] characters = cellStored.toCharArray();
			return evaluateIntFormula(characters);	

		} catch (NumberFormatException ex) {

			return ERROR;
		}
	}

	private String evaluateIntFormula(char[] characters) {
		char operand = 0;
		String number="";
		int calculation = 0;
		int i = 0;
		for (char c : characters) {
			if (c >= '0' && c <= '9') {
				operand = c;
			} else if (c == '+') {
				int x = operand;
				int y = Integer.parseInt(evaluateIntFormula(Arrays.copyOfRange(characters, i, characters.length)));
				calculation = x + y;
				return String.valueOf(calculation);
			} else {
				return ERROR;
			}
			number = number + String.valueOf(operand);
		}
		return number;
	}

}
