import java.util.HashMap;

public class Spreadsheet {
	
	HashMap<String, String> cellValues = new HashMap<String, String>();

	public String get(String cell) {
		return cellValues.get(cell);
	}
	
	public void set(String cell, String value) {
		cellValues.put(cell, value);
	}
	
	public String evaluate(String cell) {
		if (isIllegalInteger(this.get(cell))) {
			return getErrorString();
		}
		
		if (isIllegalString(this.get(cell))) {
			return getErrorString();
		}
		
		if (isArbitraryString(this.get(cell))) 
		{
			return formatArbitraryStringForEvaluation(this.get(cell));
		}
		
		return cellValues.get(cell);
	}

	private boolean isIllegalString(String string) {
		if ((string.charAt(0) == '\'' && string.charAt(string.length() - 1) != '\'') || (string.charAt(0) != '\'' && string.charAt(string.length() - 1) == '\'')) {
			return true;
		}
		return false;
	}

	private String getErrorString() {
		return "#Error";
	}

	private boolean isIllegalInteger(String string) {
		try {
			Long.parseLong(string);
			return false;
		} catch(NumberFormatException ex) {
			return true;
		}
	}

	private String formatArbitraryStringForEvaluation(String string) {
		return string.substring(1, string.length() - 1);
	}

	private boolean isArbitraryString(String string) {
		if (string.charAt(0) == '\'' && string.charAt(string.length() - 1) == '\'') {
			return true;
		}
		else return false;
	}
	
}
