import java.util.*;

public class Spreadsheet {

	// dictionary of cells and values.
	// cell => key
	// value => value
	private Map <String, String> map = new HashMap<String, String>();
	
	public String get(String cell) {
		
		if(map.containsKey(cell)) {
			
		}
		
		return null;
	}
	
	public void set(String cell, String value) {
		
		map.put(cell, value);
		
		
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
