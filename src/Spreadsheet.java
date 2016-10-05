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
		if (cell.matches("\\d") && cell.matches("[^\\d]")) {
			return "#Error";
		}
		
		return "-1";
	}
	
}
