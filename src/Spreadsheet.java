import java.util.*;
import java.util.regex.Pattern;


public class Spreadsheet {
	
	HashMap<String,String> cells = new HashMap<String,String>();

	public String get(String cell) {
		String value = cells.get(cell);
		return value;
	}
	
	public void set(String cell, String value) {
		cells.put(cell, value);
	}
	
	// ## Not implemented yet ##
	//public String evaluate(String cell) {
	//	
	//	Pattern correctFormats = Pattern.compile("");
	//}
	
}
