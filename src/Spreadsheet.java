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
		if (isArbitraryString(this.get(cell))) 
		{
			return formatArbitraryStringForEvaluation(this.get(cell));
		}
		
		if (isIllegalInteger(this.get(cell)))
		{
			return getErrorString();
		}
		return cellValues.get(cell);
	}

	private String getErrorString() {
		// TODO Auto-generated method stub
		return "#Error";
	}

	private boolean isIllegalInteger(String string) {
		// TODO Auto-generated method stub
		return false;
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
