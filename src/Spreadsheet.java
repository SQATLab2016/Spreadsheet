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
		
		// convert string to character array.
		c = value.toCharArray();
		
		// this is a counter that counts digits in the value.
		int digitCount = 0;
		
		// TODO:
		// refactor: for loop. 
		// atm. there are too much going on.
		// using same-ish code multiple times, could be done better.
		
		// loop through the value and check for letters.
		for(int i = 0; i < c.length; i++) {
		
			// if whole value is a string.
			if(c[0] == '\'' && c[c.length - 1] == '\'') {
				isString = true;
				break;
			}
			
			// if the first character is negative (-).
			if(c[i] == '-' && i == 0) {
				isNegative = true;
				continue;
			}
						
			// if there is a '=' character then
			// the subsequent char can only be '-', '\'' or a digit.
			if(c[i] == '=') {
			
				// next character is negative sign.
				if(c[i+1] == '-') {
					
					isNegative = true;
					continue;
				
				// next character is opening single quote.
				} else if (c[i+1] == '\'') {
					
					boolean hasClosingQuote = false;
					int StringStartPos = i+2;
					int StringEndPos = 0;
					
					// loop through the remaining characters for closing quote.
					for(int j = i+2; j < c.length; j++) {
						if(c[j] == '\'') {
							hasClosingQuote = true;
							StringEndPos = j;
							break;
						}
					}
					
					// TODO:
					// characters after the closing quote are being discarded.
					
					// return value if the closing quote is found.
					if(hasClosingQuote) {
						return value.substring(StringStartPos, StringEndPos);
					} else {
						return "#Error";
					}
				
				// next character is a digit.
				} else if(Character.isDigit(c[i+1])) {
					digitCount++;
					continue;
				} else {
					return "#Error";
				}
			}
			
			if(Character.isDigit(c[i])) {
				digitCount ++;
			}
		}
		
		// if the WHOLE value is a string.
		// return a substring without single quotes.
		if(isString) {
			return value.substring(1, value.length() - 1);
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
	}
}
