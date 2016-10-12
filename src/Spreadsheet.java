import java.util.HashMap;

public class Spreadsheet {
	
	public static final String ERROR_VALUE = "#Error";
	public static final String STRING_IDENTIFIER = '\'';

	HashMap<String, String> table = new HashMap<String, String>();
	
	public String get(String cell) {
		return table.get(cell);
	}
	
	public void set(String cell, String value) {
		String v = value;
		
		//String value
		if (isStringCellValue(v)) {
			
		} else { //Integer
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
		
		if (isStringCellValue(value)) {
			value = value.substring(1, value.length() - 1);
		}
		
		return value;
	}
	
	private boolean isStringCellValue(String value) {
		if (value.startsWith(STRING_IDENTIFIER) && value.endsWith(STRING_IDENTIFIER))
			return true;
		
		return false;
	}
}
