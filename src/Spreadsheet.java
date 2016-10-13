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
			number = getNumberValue(value);
		} catch (NumberFormatException numberError) {
			return this.getStringValue(value);
		}
		return Integer.toString(number);
	}
	
	private String getEqualSignValue(String value) {
		if (value.charAt(0) == '=') {
			return value.substring(1,  value.length()-1);
		}
		return "#Error";
	}

	private int getNumberValue(String value) {
		if (value.charAt(0) == '=') {
			return Integer.parseInt(value.substring(1));
		} else {
			return Integer.parseInt(value);
		}
	}
	
	private String getStringValue(String value) {
		if (value.charAt(0) == '=') {
			if (value.charAt(value.length()-1) == '\'' && value.charAt(1) == '\'') {
				return value.substring(2,value.length()-1);
			}
		} else {
			if (value.charAt(value.length()-1) == '\'' && value.charAt(0) == '\'') {
				return value.substring(1,value.length()-1);
			}
		}
		return "#Error";
	}
}
