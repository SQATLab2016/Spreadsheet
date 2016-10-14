import java.util.HashMap;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;

public class Spreadsheet {
	HashMap<String, String> sheet = new HashMap<String, String>();
	
	public String get(String cell) {
		String value = sheet.get(cell);
		return value;
	}
	
	public void set(String cell, String value) {
		sheet.put(cell, value);
	}
	
	public String evaluate(String cell) {
		String value = sheet.get(cell);
		
		// Is normal integer?
		if(isInteger(value))
			return value;
		
		// Is a quoted string e.g. 'a string'?
		else if(isCellString(value)){
			// Remove quotes
			value = value.substring(1,value.length()-1);
			return value;
		}
		
		// Is a formula to be evaluated?
		else if (beginsEquals(value)){
			// Remove the equals sign.
			value = value.substring(1);
			
			// If integer return it.
			if(isInteger(value))
				return value;
			// Is string operation? 
			// Also works for quoted string
			else if(isCellString(value)){
				String result = "";
				String temp = value;
				while(!temp.equals("")){
					int index1 = temp.indexOf('\'');
					int index2 = temp.indexOf('\'',temp.indexOf('\'')+1);
					String subStr = temp.substring(index1+1, index2);
					if(subStr.contains("&"))
						return "#Error";
					result += subStr;
					temp = temp.substring(index2+1);
				}
				result = result.replaceAll("&", "");
				return result;
			}
			
			// Is reference to a cell?
			else if(isCell(value)){
				// Check circular case.
				String refCell = get(value);
				refCell = refCell.substring(1); // Remove =	
				if(refCell.equals(cell)) // Circular?
					return "#Circular";			

				refCell = evaluate(value);
				return refCell;
			}
			
			else if(isFormula(value)){
				ScriptEngineManager mgr = new ScriptEngineManager();
		    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		    String result = "";
		    
		    try {
					int temp = (Integer) engine.eval(value);
					result = Integer.toString(temp);
				} catch (ScriptException e) {
					return "#Error";
				}
		    
		    return result;
			}
			
		}
		return  "#Error";
	}
	
	private boolean isFormula(String value) {
		if(value.contains("+")
				|| value.contains("-")
				|| value.contains("/")
				|| value.contains("*")
				|| value.contains("%")
				)
			return true;
		return false;
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
