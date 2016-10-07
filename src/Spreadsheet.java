import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
public class Spreadsheet {
	//private static final Map<String, String> map;
	HashMap<String, String> myMap = new HashMap<String, String>();
		
	
	public String get(String cell) {
		// to be implemented
		return myMap.get(cell);
	}
	
	public void set(String cell, String value) {
		// to be implemented
	myMap.put(cell, value);
	}
	
	public String evaluate(String cell) {
		
		int integer = Integer.parseInt(myMap.get(cell));
		return integer;
	}
	
	
	
}
