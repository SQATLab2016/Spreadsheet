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
		
		// get the value of the cell.
		if(map.containsKey(cell)) {
			value = map.get(cell);
		} else {
			return "ValueNotFoundError";
		}
		
		int cLenght = value.toCharArray().length;  
		int digitCount = 0;
		
		// loop through the value and check for letters.
		for(char c : value.toCharArray()) {
			
			// if the first char is negative (-).
			if()
			
			if(Character.isDigit(c)) {
				digitCount ++;
			}
			
		}
		
		// if there are some other characters than digits.
		if(digitCount != cLenght) {
			return "#Error";
		}
		
		return value;
	}
	
}
