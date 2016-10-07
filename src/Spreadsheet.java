import java.util.HashMap;

public class Spreadsheet {

	private HashMap<String, String> sheetmap = new HashMap<String, String>();
	
	public String get(String cell) {	
		return sheetmap.get(cell);	
	}
	
	public void set(String cell, String value) {		
		sheetmap.put(cell,value);
	}
	
	public String evaluate(String cell) {
		
		return sheetmap.get(cell);
	}

	
}
