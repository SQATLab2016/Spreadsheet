import java.util.HashMap;

public class Spreadsheet {
	
	HashMap<String, String> cells = new HashMap<String, String>();

	public String get(String cell) {
		String value = cells.get(cell);
		return value;
	}
	
	public void set(String cell, String value) {
		cells.put(cell, value);
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
