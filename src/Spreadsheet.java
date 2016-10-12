import java.util.HashMap;

public class Spreadsheet {

	HashMap<String, String> table = new HashMap<String, String>();
	
	public String get(String cell) {
		return table.get(cell);
	}
	
	public void set(String cell, String value) {
		table.put(cell, value);
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
