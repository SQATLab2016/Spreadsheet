import java.util.HashMap;

public class Spreadsheet {
	
	public static final String ERROR_VALUE = "#Error";

	HashMap<String, String> table = new HashMap<String, String>();
	
	public String get(String cell) {
		return table.get(cell);
	}
	
	public void set(String cell, String value) {
		String v = value;
		
		if (Character.isDigit(v.charAt(0))) {
			
		}
		
		table.put(cell, value);
	}
	
	public String evaluate(String cell) {
		String value = table.get(cell);
		
		return value;
	}
	
}
