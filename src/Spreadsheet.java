import java.util.HashMap;

public class Spreadsheet {
	
	private HashMap<String, String> hm = new HashMap<String, String>();
	
	public String get(String cell) {
		return hm.get(cell);
	}
	
	public void set(String cell, String value) {
		hm.put(cell, value);
	}
	
	public String evaluate(String cell) {
		
		String value = hm.get(cell);
		String first = value.substring(0,1);
		String last = value.substring(value.length() - 1);

		if(isNumeric(value)){
			return value;
		}else if(first.equals("'") && last.equals("'")){
			return value.substring(1, value.length()-1);
		}else{
			return "#Error";
		}	
	}
	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
}
