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
		
		if (!isIntegerCellValue(v) && !isStringCellValue(v)) {
			v = ERROR_VALUE;
		}
		
		table.put(cell, v);
	}
	
	public String evaluate(String cell) {
		String value = get(cell);
		
		if (isFormula(value)) {
			value = value.substring(1);
		}
		
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
			if (isFormula(value))
				value = value.substring(1);
			
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	private boolean isStringCellValue(String value) {
		if (isFormula(value))
			value = value.substring(1);
		
		if (value.startsWith(STRING_IDENTIFIER) && value.endsWith(STRING_IDENTIFIER))
			return true;
		
		return false;
	}
	
	private boolean isReference(String value) {
		//if (isFormula(value) && value.)
	}
	
	private String getWhitespaceRemoved(String value) {
		String newValue = "";
		
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isWhitespace(value.charAt(i)))
				newValue += value.charAt(i);
		}
		
		return newValue;
	}
}
