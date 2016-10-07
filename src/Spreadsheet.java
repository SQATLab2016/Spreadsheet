import java.util.HashMap;

public class Spreadsheet {

	private HashMap<String, String> sheetmap = new HashMap<String, String>();
	
	public String get(String cell) {
		// to be implemented
		
		return sheetmap.get(cell);
		
		
	}
	
	public void set(String cell, String value) {
		// to be implemented
		sheetmap.put(cell,value);
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
