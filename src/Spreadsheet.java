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
		
		if(map.containsKey(cell)) {
			value = map.get(cell);
		} else {
			return "ValueNotFoundError";
		}
		
		c = value.toCharArray();
		
		for(int i = 0; i < c.length; i++) {
			
		}
		
		return value;
	}
	
}
