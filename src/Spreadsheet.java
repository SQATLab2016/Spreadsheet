import java.util.*;

public class Spreadsheet {
	
	HashMap<String, String> excell = new HashMap<String, String>();

	
	public String get(String cell) throws SpreadsheetException {
		// to be implemented
		
		return (String) excell.get(cell);
	}
	
	public void set(String cell, String value) throws SpreadsheetException{
		// to be implemented
		//Test if contains only numbers 0-9
		//if(value.matches("[0-9]") &&(!(value.contains("[a-zA-Z]")))) throw new SpreadsheetException("sjadasdajsd");
		
		//Put the cell and value to excell hashmap
		System.out.println(excell);
		excell.put(cell, value);		
	}
	
	public String evaluate(String cell) throws SpreadsheetException{
		// to be implemented
		
		return null;
	}
	
}
