import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {
	
	private Map<String, String> cells = new HashMap<String, String>();

	public String get(String cell) {
		return cells.get(cell);
	}
	
	public void set(String cell, String value) {
		cells.put(cell, value);
	}
	
	public String evaluate(String cell) {
		String value = this.get(cell);
		if (value.matches(".*\\d+.*") && value.matches("[^\\d-]+")) {
			return "#Error";
		}
		
		return "-1";
	}
	
}
