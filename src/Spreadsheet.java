import java.util.HashMap;

public class Spreadsheet {
	
	public static final String ERROR_VALUE = "#Error";
	public static final char STRING_IDENTIFIER = '\'';

	HashMap<String, String> table = new HashMap<String, String>();
	
	public String get(String cell) {
		return table.get(cell);
	}
	
	public void set(String cell, String value) {
		String v = value;
		
		if (v.startsWith(prefix))
		
		if (Character.isDigit(v.charAt(0))) {
			for (int i = 0; i < v.length(); i++) {
				if (!Character.isDigit(v.charAt(i))) {
					v = ERROR_VALUE;
					break;
				}
			}
		}
		
		table.put(cell, v);
	}
	
	public String evaluate(String cell) {
		String value = table.get(cell);
		
		return value;
	}
	
}
