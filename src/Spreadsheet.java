import java.util.ArrayList;
import java.util.HashMap;

public class Spreadsheet {
	
	private static final String error = "#Error";
	private static final String circular = "#Circular";
	
	private HashMap<String, String> spreadSheet = new HashMap<String, String>();
	private ArrayList<String> nodes = new ArrayList<String>();

	public String get(String cell) {
		String val = spreadSheet.get(cell);
		if (val != null) {
			if (isValidString(val)) {
				val = stripStringTags(val);
			}
			else if (isFormula(val)) {
				val = handleFormula(cell, val);
			}
		}
		if (val != circular && nodes.contains(cell)) {
			nodes.remove(cell);
		}
		return val;
	}

	private String handleFormula(String cell, String val) {
		if (isValidCalculation(val.substring(1))) {
			val = calculate(val.substring(1));
		}
		else if (isReference(val.substring(1))) {
			if (!nodes.contains(cell)) {
				nodes.add(cell);
			}
			else {
				val = circular;
			}
		}
		if (val != circular && !isValidInteger(val)) {
			val = evaluate(val.substring(1));
		}
		return val;
	}

	private boolean isFormula(String val) {
		if (val.startsWith("=")) {
			return true;
		}
		return false;
	}

	private String stripStringTags(String val) {
		val = val.replace("'", "");
		val = val.replace("&", "");
		return val;
	}
	
	public void set(String cell, String value) {
		if (isValidInteger(value) || isValidString(value) || isFormula(value) || isValidCalculation(value)) {
			spreadSheet.put(cell, value);
		}
		else {
			spreadSheet.put(cell, error);
		}
	}
	
	private boolean isValidString(String value) {
		if (value.startsWith("'") && value.endsWith("'")) {
			return true;
		}
		return false;
	}

	private boolean isValidInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public String evaluate(String cell) {
		String val = cell;
		if (isValidString(val)) {
			if (hasStringOperation(val)) {
				val = performStringOperation(val);
			}
			else {
				val = stripStringTags(val);
			}
		}
		else if (isValidInteger(val)) {
			// do nothing
		}
		else if (isReference(val)) {
			val = this.get(val);
		}
		else {
			return error;
		}
		return val;
	}

	private String performStringOperation(String val) {
		String[] strings = val.split("&");
		String word;
		String phrase = "";
		for (int i = 0; i < strings.length; i++) {
			word = this.evaluate(strings[i]);
			phrase = phrase.concat(word);
			if (word == error) {
				phrase = error;
				break;
			}
		}
		return phrase;
	}

	private boolean hasStringOperation(String val) {
		if (val.indexOf("&") != -1) {
			return true;
		}
		return false;
	}

	private String calculate(String cell) {
		String operations = "+";
		int result = 0;
		int val;
		char operation;
		String[] values = cell.split("[-+*/%]");
		operations += cell.replaceAll("\\w", "");
		for (int i = 0; i < values.length; i++) {
			operation = operations.charAt(i);
			if (isValidInteger(values[i])) {
				val = Integer.parseInt(values[i]);
			}
			else {
				val = Integer.parseInt(this.get(values[i]));
			}
			result = performOperation(result, val, operation);
		}
		return Integer.toString(result);
	}

	private int performOperation(int result, int val, char operation) {
		if (operation == '+') {
			result += val;
		}
		else if (operation == '-') {
			result -= val;
		}
		else if (operation == '*') {
			result *= val;
		}
		else if (operation == '/') {
			result /= val;
		}
		else if (operation == '%') {
			result %= val;
		}
		return result;
	}

	private boolean isValidCalculation(String cell) {
		String[] values = cell.split("[-+*/%]");
		if (values.length > 1) {
			for (int i = 0; i < values.length; i++) {
				if (!isValidInteger(values[i]) && !isValidInteger(this.get(values[i]))) {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isReference(String cell) {
		if (isValidInteger(cell) || isValidString(cell)) {
			return false;
		}
		if (Character.isLetter(cell.charAt(0)) && Character.isDigit(cell.charAt(1))) {
			return true;
		}
		return false;
	}
	
}
