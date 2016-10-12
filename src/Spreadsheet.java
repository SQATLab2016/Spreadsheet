
public class Spreadsheet {
	String cell;
	String value;
		
	
	
	
	
	
	
	
	public String get(String cell) {
		return this.value;
	}
	
	public void set(String cell, String value) {
		this.cell = cell;
		this.value = value;
	}
	
	public String evaluate(String cell) {
		int tempValue;
		String tempString = this.value;
		
		if ((tempString.endsWith("\'")) && (tempString.startsWith("\'"))){
			tempString = tempString.substring(1, tempString.length()-1);
			return tempString;
		}
		
		else if (tempString.startsWith("=")){
			tempString = tempString.substring(1);
			
			if ((tempString.endsWith("\'")) && (tempString.startsWith("\'"))){
				tempString = tempString.substring(1, tempString.length()-1);
				return tempString;
				}
			
			else if ()
			
			else {
			return "#Error";
			}
		}
		
		try {
		tempValue = Integer.parseInt(this.value);
		}
		
		catch (NumberFormatException n) {
			return "#Error";
			
		}
		
		String returnString = Integer.toString(tempValue);
		return returnString;
	}
	
}
