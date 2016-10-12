import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {
	
	Map<String, Integer> sheet = new HashMap<>();

	public String get(String cell) {
		return sheet.get(cell).toString();
	}
	
	public void set(String cell, String value) {
		sheet.put(cell, Integer.parseInt(value));
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
