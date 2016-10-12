import java.util.HashMap;

public class Spreadsheet {
	
	public static final String ERROR_VALUE = "#Error";
	public static final String STRING_IDENTIFIER = "'";

	HashMap<String, String> table = new HashMap<String, String>();
	
	public String get(String cell) {
		return table.get(cell);
	}
	
	public void set(String cell, String value) {
		String v = value;
		
		if (isIntegerCellValue(v)) {
			
		} else if (isStringCellValue(v)) {
			
		} else {
			v = ERROR_VALUE;
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
	
	private boolean isFormula(String value) {
		if (value.startsWith("="))
			return true;
		
		return false;
	}
	
	private boolean isIntegerCellValue(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	private boolean isStringCellValue(String value) {
		if (value.startsWith(STRING_IDENTIFIER) && value.endsWith(STRING_IDENTIFIER))
			return true;
		
		return false;
	}
}
