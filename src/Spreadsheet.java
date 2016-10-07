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
		boolean containsEquals = false;
		
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
		// 1. Refactor: using same-ish code multiple times, could be done better (in for loop).
		// 2. if value is "= ", there is no error message for special cases.
		// 3. make it recursive (I guess).
		
		// TODO:
		// start & end positions are smelly.
		
		// for cutting the string to substring.
		// used to manipulate the value string in the return statements.
		int startPos = 0;
		int endPos = 0;
		
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
			
				containsEquals = true;
				
				// next character is negative sign.
				if(c[i+1] == '-') {
					startPos = i+1;
					isNegative = true;
					continue;
				
				// next character is opening single quote.
				} else if (c[i+1] == '\'') {
					
					boolean hasClosingQuote = false;
					startPos = i+2;
					
					// loop through the remaining characters for closing quote.
					for(int j = i+2; j < c.length; j++) {
						if(c[j] == '\'') {
							hasClosingQuote = true;
							endPos = j;
							break;
						}
					}
					
					// TODO:
					// characters after the closing quote are being discarded.
					
					// return value if the closing quote is found.
					if(hasClosingQuote) {
						return value.substring(startPos, endPos);
					} else {
						return "#Error";
					}
				
				// next character is a digit.
				} else if(Character.isDigit(c[i+1])) {
					startPos = i+1;
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
		if(isNegative || containsEquals) {
			
			// "remove" two from value length
			// 1. negative sign
			// 2. equals sign
			if(isNegative && containsEquals) {
				if(digitCount != c.length - 2) {
					return "#Error";
				} else {
					return value.substring(startPos);
				}
			}
			
			//"remove" one from value length
			// 1. negative sign
			if(digitCount != (c.length - 1)) {
				return "#Error";
			} else {
				return value.substring(startPos);
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
