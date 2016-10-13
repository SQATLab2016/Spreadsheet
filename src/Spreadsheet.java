import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Spreadsheet {
	
	HashMap<String, String> cellValues = new HashMap<String, String>();
	ArrayList<String> previousCellReferences = new ArrayList<String>();

	public String get(String cell) {
		return cellValues.get(cell);
	}
	
	public void set(String cell, String value) {
		cellValues.put(cell, value);
	}
	
	public String evaluate(String cell) {
		
		if (isFormula(this.get(cell))) {
			if (isCellValue(this.get(cell))) {
				if (!previousCellReferences.contains(removeLeadingEqualsForFormula(this.get(cell)))) {
					String referenceCell = removeLeadingEqualsForFormula(this.get(cell));
					previousCellReferences.add(removeLeadingEqualsForFormula(this.get(cell)));
					return evaluate(referenceCell);
				}
				else return "#Circular";
			}
			else if (isIntegerFormula(this.get(cell))) {
				String value = calculateIntegerFormulaValue(this.get(cell));
				return value;
			}
			
			else if (isStringFormula(this.get(cell))) {
				String value = concatenateStrings(this.get(cell));
				return value;
			}
			
			else if (isArbitraryString(this.get(cell)) && !isIllegalString(removeLeadingEqualsForFormula(this.get(cell)))) {
				return formatArbitraryStringForEvaluation(this.get(cell)).substring(1);
			}
			else if (!isIllegalInteger(removeLeadingEqualsForFormula(this.get(cell)))){
				return this.get(cell).substring(1);
			}
			else return getErrorString();
		}
				
		if (isIllegalString(this.get(cell))) {
			return getErrorString();
		}
		
		else if (isArbitraryString(this.get(cell))) {
			return formatArbitraryStringForEvaluation(this.get(cell));
		}
		
		else if (isIllegalInteger(this.get(cell))) {
			return getErrorString();
		}
			
		else return cellValues.get(cell);
	}
	
	private String concatenateStrings(String string) {
		ArrayList<String> strings = new ArrayList<String>();
		
		StringTokenizer stringSplitter = new StringTokenizer(string, "&");
		while (stringSplitter.hasMoreTokens()) {
			strings.add(stringSplitter.nextToken());
		}
		
		String firstString = strings.get(0);
		firstString = firstString.substring(1);
		strings.set(0, firstString);
			
		StringBuilder value = new StringBuilder();
		for (String tempString : strings) {
			if (!isIllegalString(tempString)) {
				value.append(formatArbitraryStringForEvaluation(tempString));
			}
			else return "#Error";
		}
		
		return value.toString();
	}

	private boolean isStringFormula(String string) {
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '&') return true;
		}
		return false;
	}

	private String calculateIntegerFormulaValue(String string) {
		if (formulaContainsParentheses(string)) {
			string = handleFormulaParentheses(string);
		}
		
		ArrayList<String> integers = new ArrayList<String>();
		ArrayList<String> operators = new ArrayList<String>();
		
		//Split integers
		StringTokenizer stringSplitter = new StringTokenizer(string, "+-*/");
		while (stringSplitter.hasMoreTokens()) {
			integers.add(stringSplitter.nextToken());
		}
		
		//Parse operators
		for (int i = 0; i < string.length(); i++) {
			Character c = string.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				operators.add(c.toString());
			}
		}
		
		if (isIllegalInteger(removeLeadingEqualsForFormula(integers.get(0)))) {
			return "#Error";
		}
		
		//Start value
		int index = 0;
		Integer value = Integer.parseInt(removeLeadingEqualsForFormula(integers.get(index)));
		index++;
		
		//Calculate formula value
		for (String operator : operators) {
			if (isIllegalInteger(integers.get(index))) {
				return "#Error";
			}
			
			if (operator.equals("+")) {
				value += Integer.parseInt(integers.get(index));
			}
			else if (operator.equals("-")) {
				value -= Integer.parseInt(integers.get(index));
			}
			else if (operator.equals("*")) {
				value *= Integer.parseInt(integers.get(index));
			}
			else {
				if (Integer.parseInt(integers.get(index)) != 0) {
					value /= Integer.parseInt(integers.get(index));
				}
				else return "#Error";
			}
			index++;
		}
		return value.toString();
	}

	private String handleFormulaParentheses(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean formulaContainsParentheses(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isIntegerFormula(String string) {
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				return true;
			}
		}
		
		return false;

	}


	private boolean isFormula(String string) {
		return string.charAt(0) == '=';
	}
	
	private boolean isCellValue(String string) {
		if (cellValues.containsKey(string.substring(1))) {
			return true;
		}
		else return false;
	}

	private boolean isIllegalString(String string) {
		if ((string.charAt(0) == '\'' && string.charAt(string.length() - 1) != '\'') || (string.charAt(0) != '\'' && string.charAt(string.length() - 1) == '\'')) {
			return true;
		}
		return false;
	}

	private String getErrorString() {
		return "#Error";
	}

	private boolean isIllegalInteger(String string) {
		try {
			Long.parseLong(string);
			return false;
		} catch(NumberFormatException ex) {
			return true;
		}
	}

	private String formatArbitraryStringForEvaluation(String string) {
		return string.substring(1, string.length() - 1);
	}

	private boolean isArbitraryString(String string) {
		if (isFormula(string)) {
			if (string.charAt(1) == '\'' && string.charAt(string.length() - 1) == '\'') {
				return true;
			}
		}
		else {
			if (string.charAt(0) == '\'' && string.charAt(string.length() - 1) == '\'') {
				return true;
			} 
		}
		
		return false;
	}
	
	private String removeLeadingEqualsForFormula(String string) {
		return string.substring(1);
	}
	
}
