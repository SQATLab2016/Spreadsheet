import java.util.HashMap;

public class Spreadsheet {
	HashMap<String, String> mValues = new HashMap<String, String>();
	
	public String get(String cell) {
		// to be implemented
		return null;
	}
	
	public void set(String cell, String value) {
		if (value.length() > 0) {
			boolean isInteger = false,
			for (int i = 1; i < value.length(); i++) {
				char c = value.charAt(i);
				if (i == 0 && )
				if (c < '0' || c > '9') {
					value = "#Error";
					break;
				}
			}
		}
		
		mValues.put(cell, value);
	}
	
	public String evaluate(String cell) {
		return (String) mValues.get(cell);
	}
	
}
