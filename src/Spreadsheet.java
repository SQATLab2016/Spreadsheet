import java.util.HashMap;

public class Spreadsheet {
	HashMap<String, String> sheet = new HashMap<String, String>();
	
	
	public String get(String cell) {
		String value = sheet.get(cell);
		
		/*if(isInteger(value))
			return value;
		else if(isCellString(value))
			return value;*/
		return value;
	}
	
	public void set(String cell, String value) {
		sheet.put(cell, value);
	}
	
	public String evaluate(String cell) {
		String value = sheet.get(cell);
		
		if(isInteger(value))
			return value;
		
		else if(isCellString(value)){
			// Remove quotes
			value = value.substring(1,value.length()-1);
			return value;
		}
		
		else if (beginsEquals(value)){
			// Remove the equals sign.
			value = value.substring(1);
			if(isInteger(value))
				return value;
			
			else if(isCellString(value)){
				// Remove quotes.
				value = value.substring(0,value.length()-1);
				return value;
			}
			
			// If reference to a cell.
			else if(isCell(value)){
				String refCell = evaluate("=" + value);
				if(refCell.equals("="+value)) // Circular?
					return "#Circular";
				return evaluate("="+value);
			}
		}
		return  "#Error";
	}
	
	public boolean isInteger(String string) {
    try {
        Integer.valueOf(string);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
	}
	
	// Can only check cells with a single letter.
	public boolean isCell(String str){
		char letter = str.charAt(0);
		if(letter<65 || letter > 90)
			return false;
		String number = str.substring(1);
		// Does not check positive-negative integers.
		if(!isInteger(number))
			return false;
		return true;
	}
	
	public boolean isCellString(String str){
		if(str.length()<=2)
			return false;
		char first = str.charAt(0);
		char last = str.charAt(str.length()-1);
		
		if(first=='\'' && last=='\'')
				return true;
		return false;
	}
	
	public boolean beginsEquals(String str){
		if (str.length()>0 && str.charAt(0)== '=')
			return true;
		return false;
	}
}
