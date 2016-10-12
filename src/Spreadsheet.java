import java.util.HashMap;

public class Spreadsheet {
	
	public static final String ERROR_VALUE = "#Error";
	public static final String STRING_IDENTIFIER = '\'';

	HashMap<String, String> table = new HashMap<String, String>();
	
	public String get(String cell) {
		return table.get(cell);
	}
	
	public void set(String cell, String value) {
		String v;
		
		//String value
		if (v.startsWith(STRING_IDENTIFIER) && v.endsWith(STRING_IDENTIFIER)) {
			v = value;
		} else { //Integer
			for (int i = 0; i < v.length(); i++) {
				if (!Character.isDigit(v.charAt(i))) {
					v = ERROR_VALUE;
					break;
				}
			}
			
			v = value;
		}
		
		table.put(cell, v);
	}
	
	public String evaluate(String cell) {
		String value = table.get(cell);
		
		return value;
	}
	
}
