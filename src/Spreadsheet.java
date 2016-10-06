import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {

	Map<String, String> sheet = new HashMap<String, String>();
	
	public String get(String cell) {
		String value = sheet.get(cell);
		return value;
	}
	
	public void set(String cell, String value) {
		sheet.put(cell, value);
	}
	
	public String evaluate(String cell) {
		String value = sheet.get(cell);
		int number = 0;
		try {
			number = Integer.parseInt(value);
		} catch (NumberFormatException numberError) {
			return "#Error";
		}
		return Integer.toString(number);
	}
}
