import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {
	
	private Map<String, String> spriteSheet = new HashMap<String, String>();

	public String get(String cell) {
		String cellValue = spriteSheet.get(cell);
		
		return cellValue;
	}
	
	public void set(String cell, String value) {
		spriteSheet.put(cell, value);
	}
	
	public String evaluate(String cell) {
		
		String cellValue = get(cell);
		String returnValue;
		char first = cellValue.charAt(0);
		char last = cellValue.charAt(cellValue.length() -1);
		
		if(isNumeric(cellValue) == true){
			returnValue = cellValue;
		}else if(isString(first, last) == true){
			returnValue = cellValue.substring(1, cellValue.length()-1);
		}else{
			returnValue = "#Error";
		}
		
		return returnValue;
	}
	
	public boolean isNumeric(String s){
		
		if(s.matches("-?\\d+(\\.\\d+)?")){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isString(char a, char b){
		
		if(a == '’' && b == '’'){
			return true;
		}else{
			return false;
		}
	}
}