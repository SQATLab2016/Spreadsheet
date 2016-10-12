
public class Spreadsheet {
	String [][] sheet = new String [20][20];
	String [] abcd = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};

	public String get(String cell) {
		String letter = cell.substring(0, 1);
		String column = cell.substring(1, 2);
		int columnNumber, rowNumber;
		
		rowNumber = searchCellRow(letter);
		columnNumber = searchCellColumn(column);
		
		return sheet[rowNumber][columnNumber];
	}

	private int searchCellColumn(String column) {
		boolean found = false;
		int counter = 0;
		while (!found && counter < 20) {
			if (column.equals(String.valueOf(counter))) {
				found = true;
			}
			else {
				++counter;
			}
		}
		return counter;
	}

	private int searchCellRow(String letter) {
		boolean found = false;
		int counter = 0;
		
		while (!found && counter < 20) {
			if (letter.equals(abcd[counter])) {
				found = true;
			}
			else {
				++counter;
			}
		}
		return counter;
	}
	
	public void set(String cell, String value) {
		String letter = cell.substring(0, 1);
		String column = cell.substring(1, 2);
		
		sheet[searchCellRow(letter)][searchCellColumn(column)] = value;
	}
	
	public String evaluate(String cell) {
		String value = get(cell);
		for (int i = 0; i < value.length(); i++) {
			if ((value.charAt(i) == '+') || (value.charAt(i) == '-') || (value.charAt(i) == '*') || (value.charAt(i) == '/')) {
				return calculator(value);
			}
		}
		if (value.charAt(0) == '=') {
			if ((Character.isAlphabetic(value.charAt(1)) && (Character.isDigit(value.charAt(2))))) {
				String refCell = value.substring(1, 3);
				String circular = "=" + cell;
				if (get(refCell) != circular) {
					return get(refCell);
				}
				else {
					return "#Circular";
				}
			}
			String realValue = "";
			for (int i = 1; i < value.length(); i++) {
				realValue = realValue + value.charAt(i);
			}
			value = realValue;
		}
		
		if (isANumber(value)) {
			return value;
		}
		else if (isAString(value)) {
			String realString = "";
			for (int i = 1; i < value.length() - 1; i++) {
				realString = realString + value.charAt(i);
			}
			return realString;
		}
		else {
			return "#Error";
		}
	}

	private String calculator(String value) {
		int calc;
		return null;
	}

	private boolean isAString(String value) {
		if ((value.charAt(0) == '\'') && (value.charAt(value.length() - 1) == '\'')){
			return true;
		}
		else {
			return false;
		}
	}

	private Boolean isANumber(String value) {
		int counter = 0;
		if (value.isEmpty()) {
			return false;
		}
		if (value.charAt(counter) == '-') {
			if (value.length() > 1) {
				++counter;
			}
			else {
				return false;
			}
		}
		for (; counter < value.length(); ++counter) {
			if (!Character.isDigit(value.charAt(counter))) {
				return false;
			}
		}
		return true;
	}
	
}
