import java.util.HashMap;

public class Spreadsheet {
	HashMap<String, String> mValues = new HashMap<String, String>();
	
	public String get(String cell) {
		// to be implemented
		return null;
	}
	
	public void set(String cell, String value) {
		mValues.put(cell, value);
	}
	
	public String evaluate(String cell) {
		return (String) mValues.get(cell);
	}
	
}
