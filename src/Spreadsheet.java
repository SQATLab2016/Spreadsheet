import java.util.*;

public class Spreadsheet {

	// dictionary of cells and values.
	// cell => key
	// value => value
	private Map <String, String> map = new HashMap<String, String>();
	
	public String get(String cell) {
		if(map.containsKey(cell)) {
			return map.get(cell);
		}
		return "errormessage";
	}
	
	public void set(String cell, String value) {
		map.put(cell, value);
	}
	
	public String evaluate(String cell) {
		
		String value = "";
		char[] c;
		boolean isNegative = false;
		boolean isString = false;
		
		// get the value of the cell.
		if(map.containsKey(cell)) {
			value = map.get(cell);
		} else {
			return "ValueNotFoundError";
		}
		
		c = value.toCharArray();
		int digitCount = 0;
		
		// loop through the value and check for letters.
		//for(char c : value.toCharArray()) {
		for(int i = 0; i < c.length; i++) {
		
			// if value is a string.
			if(c[0] == '\'' && c[c.length - 1] == '\'') {
				isString = true;
				break;
			}
			
			// if the first character is negative (-).
			if(c[i] == '-' && i == 0) {
				isNegative = true;
				continue;
			}
			
			if(Character.isDigit(c[i])) {
				digitCount ++;
			}
			
		}
		
		// if there are some other characters than digits.
		// 1. Check if the number is negative
		// 2. if the string contains other characters than digits and '-'.
		if(isNegative) {
			if(digitCount != (c.length - 1)) {
				return "#Error";
			} else {
				return value;
			}
		} else {
			if(digitCount != c.length) {
				return "#Error";
			} else {
				return value;
			}
		}
		
		return value;
	}
}
