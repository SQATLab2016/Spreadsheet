
import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {
	Map<String, String> spreadSheet = new HashMap<String, String>();

	public String get(String cell) {
		return spreadSheet.get(cell);
	}
	
	public void set(String cell, String value) {
		spreadSheet.put(cell, value);
	}
	
	public String evaluate(String cell) {
		if (spreadSheet.get(cell).startsWith("\'") && spreadSheet.get(cell).endsWith("\'") == true)
			return spreadSheet.get(cell).replaceAll("\'","").replaceAll("=", "");
		if  (String.valueOf(spreadSheet.get(cell).charAt(0)) == "=" && String.valueOf(spreadSheet.get(cell).charAt(1)) == "\'" && spreadSheet.get(cell).endsWith("\'") == true)
			return spreadSheet.get(cell).replaceAll("\'","").replaceAll("=", "");
		else {
			try
		    { //|| spreadSheet.get(cell).startsWith("=")) 
				int valueOfCell = Integer.parseInt(spreadSheet.get(cell));
		        return Integer.toString(valueOfCell);
		    } catch (NumberFormatException ex) {
				return "#Error";
		    }
		}
	}
	
}
