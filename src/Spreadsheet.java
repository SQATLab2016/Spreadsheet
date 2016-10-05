import java.util.HashMap;

public class Spreadsheet {
	HashMap<String, String> mValues = new HashMap<String, String>();
	
	public String get(String cell) {
		// to be implemented
		return null;
	}
	
	public void set(String cell, String value) {
		for (char c : value.toCharArray()) {
			if (c < '0' || c > '9')
				value = "#Error";
		}
		mValues.put(cell, value);
	}
	
	public String evaluate(String cell) {
		return (String) mValues.get(cell);
	}
	
}
