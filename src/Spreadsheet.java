import java.util.HashMap;

public class Spreadsheet {

	HashMap<String, String> spreadsheet;
	
	public Spreadsheet() {
		this.spreadsheet = new HashMap<String, String>();
	}
	public String get(String cell) {
		
		return spreadsheet.get(cell);
	}
	
	public void set(String cell, String value) {
		spreadsheet.put(cell, value);
	}
	
	public String evaluate(String cell) {
		String value = "";
		if(get(cell).charAt(0) == '-') {
			value = get(cell);
		}
		else if(get(cell).charAt(0) == '=') {
			value = checkEqual(get(cell));
		}
		else if(Character.isDigit(get(cell).charAt(0))) {
			value = checkDigit(get(cell));
		}
		else if(get(cell).charAt(0) == '\'') {
			value = checkString(get(cell));
		} else {
			value = "#Error";
		}
		return value;
	}
	
	private String checkEqual(String string) {
		if(string.charAt(1) == '\'') {
			return checkForStringOperations(string);
		} else if(Character.isLetter(string.charAt(1))) {
			String otherValue = get(string.replaceAll("=", ""));
			if(otherValue.charAt(0) == '\'') {
				return checkString(otherValue);
			} else if(Character.isDigit(otherValue.charAt(0))) {
				return checkDigit(otherValue);
			} else if (otherValue.charAt(0) == '-') {
				return otherValue;
			} else if(otherValue.charAt(0) == '=') {
				return checkForCirculation(string, otherValue);
			}
		} else if(Character.isDigit(string.charAt(1))) {	
			return checkForOperations(string);
		}
		
		return "#Error";
	}
	private String checkForStringOperations(String string) {
		if((string.contains("&")) && (string.charAt(1) == '\'') && (string.charAt(string.length()-1) == '\'')) {
			for(int i = 0; i < string.length(); i++) {
				if(string.charAt(i) == '&' && string.charAt(i-1) == '\'' && string.charAt(i+1) == '\'') {
					return string.replaceAll("['=&]", "");
				}
				
			}
			
		} else if ( string.charAt(string.length()-1) == '\'') {
			return checkString(string.replaceAll("=", ""));
		}
			
		 return "#Error";
	}
	private String checkForOperations(String string) {
		String s = string;
		int sum = 0;
		for(int i = 1; i < s.length(); i++) {
			if(Character.isLetter(s.charAt(i))) {
				return "#Error";
			}
			switch(string.charAt(i)) {
				case '+':
					sum += Character.getNumericValue(s.charAt(i-1)) + Character.getNumericValue(s.charAt(i+1));
					break;
				case '-':
					sum += Character.getNumericValue(s.charAt(i-1)) - Character.getNumericValue(s.charAt(i+1));
					break;
				case '*':
					sum += Character.getNumericValue(s.charAt(i-1)) * Character.getNumericValue(s.charAt(i+1));
					break;
				case '/':
					sum += Character.getNumericValue(s.charAt(i-1)) / Character.getNumericValue(s.charAt(i+1));
					break;
				case '%':
					sum += Character.getNumericValue(s.charAt(i-1)) % Character.getNumericValue(s.charAt(i+1));
					break;
			}
		}
		return Integer.toString(sum);
	}
	private String checkForCirculation(String string, String otherValue) {
		String key = "=";
		for(Object o : spreadsheet.keySet()) {
			if(spreadsheet.get(o).equals(string)) {
				key += o;
			}
			if(key.equals(otherValue)) {
				return "#Circular";
			}
		}
		return otherValue;
	}
	
	private String checkString(String string) {
		if(string.charAt(string.length()-1) == '\'') {
			return string.replaceAll("'", "");
		} else {
			return "#Error";
		}
	}
	
	private String checkDigit(String string) {
		for(int i = 0 ; i < string.length(); i++) {
			if(!Character.isDigit(string.charAt(i))) {
				return "#Error";
			}
		}
		return string;
	}
	
}
