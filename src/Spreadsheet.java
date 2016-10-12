import java.util.HashMap;

public class Spreadsheet {
	
	public static final String ERROR_VALUE = "#Error";
	public static final String STRING_IDENTIFIER = "'";

	HashMap<String, String> table = new HashMap<String, String>();
	
	public String get(String cell) {
		String value = table.get(cell);
		
		boolean selfChecked = false;
		
		while (isReference(value)) {
			if (!selfChecked && value.substring(1).equals(cell)) {
				value = ERROR_VALUE;
				break;
			}
			
			selfChecked = true;
			
			value = table.get(value.substring(1));
			
			if (value == null)
				value = ERROR_VALUE;
		}
		
		return value;
	}
	
	public void set(String cell, String value) {
		if (isReference(value)) {
			table.put(cell, value);
			return;
		}
		
		String v = value;
		if (isFormula(v)) {
			v = v.substring(1);
		}
		if (!isIntegerCellValue(v) && !isStringCellValue(v)) {
			table.put(cell, ERROR_VALUE);
			return;
		}
		
		table.put(cell, value);
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
		String v = getWhitespaceRemoved(value);
		
		if (isFormula(v)) {
			int i = 1;
			boolean charFound = false;
			boolean digitFound = false;
			
			if (v.length() <= 1)
				return false;

			char character = v.charAt(i);
			while (Character.isLetter(character)) {
				charFound = true;
				i++;
				
				if (v.length() < i)
					character = v.charAt(i);
				else
					break;
			}
			
			while (Character.isDigit(v.charAt(i))) {
				digitFound = true;
				i++;
				
				if (v.length() < i)
					character = v.charAt(i);
				else
					break;
			}
			
			if (charFound && digitFound && v.length() == i)
				return true;
		}
		
		return false;
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
