import java.util.ArrayList;

public class Spreadsheet {
	private ArrayList<Cell> cells = new ArrayList<Cell>();
	private ArrayList<String> circularReferences = new ArrayList<String>();
	
	
	public String get(String cell) {
		for(Cell c: cells) {
			if(cell.equals(c.getId()))
				return c.getValue();
		}
		return null;
	}
	
	public void set(String cell, String value) {
		cells.add(new Cell(cell, value));
	}
	
	public String evaluate(String cell) {
		String value = get(cell);
		char c = value.charAt(0);
		
		if(Character.isDigit(c) || c =='-') {
			return dealWithNumbers(value);
		}
		
		else if(c== '=') {
			StringBuilder sb = new StringBuilder(value);
			sb.deleteCharAt(0);
			if(isAValidString(sb.toString(), sb.charAt(0))) {
				return dealWithStrings(sb.toString());
			}
			
			else if(Character.isDigit(sb.charAt(0)) || sb.charAt(0) =='-') {
				return dealWithNumbers(sb.toString());
			}
			
			//definition of cell #ID? Uppercase A-Z, number
			else if(Character.isUpperCase(sb.charAt(0)) && Character.isDigit(sb.charAt(1)) && 2 == sb.length()) {
				String cellName = sb.toString();
				if(circularReferences.contains(cellName)){
					return "#Circular";
				}
				else {
					circularReferences.add(cellName);
					return evaluate(cellName);
				}
			}
			
			else 
				return "#Error";
		}
		
		else {
			if(isAValidString(value, c)) {
				return dealWithStrings(value);
			}
			else
				return "#Error";
		}
	}
	
	
	
	
	public String dealWithStrings(String input) {
		StringBuilder sb = new StringBuilder(input);
		sb.deleteCharAt(0);
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	
	
	
	public String dealWithNumbers(String input) {
		String value = input;
		int counter = 0;
		for(char ch: value.toCharArray()){
			if(ch == '-' && counter == 0) {
				
			}
			else if(Character.isDigit(ch) || ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
				
			}
			else
				return "#Error";
			counter++;
		}

		ArrayList<Integer> values = new ArrayList<Integer>();
		ArrayList<Character> operations = new ArrayList<Character>();
		
		int result = 0;
		for (int i=0; i < value.length(); i++) {
		    char c = value.charAt(i);
		    if (Character.isDigit(c)) {
		    	result = result*10 + Character.getNumericValue(c);
		    	if(i == value.length()-1)
		    		values.add(result);
		    }
		    else {
		    	values.add(result);
		    	operations.add(c);
		    	result = 0;
		    }
		    
		}

		int calculated = 0;
		int operationCounter = -1;
		for(int v : values) {
			if(operationCounter == -1) {
				calculated = v;
			}
			else {
				char c = operations.get(operationCounter);
				switch(c) {
				case '+' :
					calculated += v;
					break;
				case '-' :
					calculated -= v;
					break;
				case '*' :
					calculated = calculated * v;
					break;
				case '/' :
					calculated = calculated / v;
					break;
				case '%' :
					calculated = calculated % v;
					break;
				}
			}
			operationCounter++;
		}
		value = "" + calculated;
		return value;
	}
	
	
	
	public boolean isAValidString(String testable, char first) {
		if(first == '\'' && testable.substring(testable.length() - 1).equals("'")) {
			return true;
		}
		return false;
	}
	
}
