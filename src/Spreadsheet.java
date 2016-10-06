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
		return cellValues.get(cell);
	}

	private String formatArbitraryStringForEvaluation(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean isArbitraryString(String string) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
