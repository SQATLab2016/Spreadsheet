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
		String cellStored = sheet.get(cell);
		if(cellStored.startsWith(EQUALS)){
			cellStored=cellStored.substring(1);
		}
		if (cellStored.startsWith(STRING_CLASSIFIER)) {
			return evaluateString(cellStored);
		} else {
			return evaluateInt(cellStored);
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
			Integer.parseInt(cellStored);
			return cellStored;
		} catch (NumberFormatException ex) {
			return ERROR;
		}
	}

}
