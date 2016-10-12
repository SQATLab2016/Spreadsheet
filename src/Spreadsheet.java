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
		
		if (isInteger(myMap.get(cell)))
		{
			
			int integer = Integer.parseInt(myMap.get(cell));
			
			if (integer == (int)integer)
			{
				return myMap.get(cell);
			}
		}
		
		cell = myMap.get(cell);
		final char firstChar = cell.charAt(0);
		
		if (firstChar == '=')
		{

			String output = new String(cell);
			StringBuilder sr = new StringBuilder(output);
			sr.deleteCharAt(0); //Remove "="
			String TwoChar = new String(sr.substring(0, 2));


				if (myMap.containsKey(TwoChar))
				{
					return myMap.get(TwoChar);
				}

			
			if (isString(sr.toString()))
			{
				
			sr.deleteCharAt(0); //Remove "'"
			sr.deleteCharAt(sr.length() - 1);
			return sr.toString();
			}
			
		}
				
		
		if (cell.getClass().equals(String.class))
		{
			

			if (isString(cell))
			{
				
			String output = new String(cell);
			StringBuilder sr = new StringBuilder(output);
			sr.deleteCharAt(0);
			sr.deleteCharAt(sr.length() - 1);
			return sr.toString();
			}
			else {
			return "#Error";
			}
		}
		return "null";
}

	boolean isString(String cell) {
		final char start = cell.charAt(0);
		final char end = cell.charAt(cell.length()-1);
		//System.out.print(start);
		//System.out.print(end);
		
		if (start == '\'' && end == '\''){
			return true;	
		}
		return false;
		
		}

	private boolean isInteger(String cell) {
		
		try{
			Integer.parseInt(cell);
			return true;
			
		}catch (NumberFormatException e){
			
			return false;
		}
		
	}
	
		
	
}
