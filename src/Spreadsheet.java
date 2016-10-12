import java.util.HashMap;
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
			String[] characters = cellStored.split("[+]");
			int total = 0;
			for (String s : characters) {
				int i = Integer.parseInt(s);
				total = total + i;
			}
			return String.valueOf(total);

		} catch (NumberFormatException ex) {

			return ERROR;
		}
	}

}
