import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {

	Map<String, String> sheet = new HashMap<>();

	public String get(String cell) {
		return sheet.get(cell);
	}

	public void set(String cell, String value) {
		sheet.put(cell, value);
	}

	public String evaluate(String cell) {
		try {
			Integer.parseInt(sheet.get(cell));
			return sheet.get(cell);
		} catch (NumberFormatException ex) {
			return "#ERROR";
		}
	}

}
