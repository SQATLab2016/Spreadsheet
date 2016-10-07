import java.util.*;

public class Spreadsheet {
	
	private HashMap<String, String> cells;
	
	public Spreadsheet(){
		cells = new HashMap<String, String>();
	}

	public String get(String cell) {
		// to be implemented
		return cells.get(cell);
	}
	
	public void set(String cell, String value) {
		
		// to be implemented
		cells.put(cell, value);
	}
	
	public String evaluate(String cell) {
		// to be implemented
		
		return cells.get(cell);
	}
	
}
