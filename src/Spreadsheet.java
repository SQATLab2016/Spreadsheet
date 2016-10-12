import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {

	Map<String, String> sheet = new HashMap<String, String>();

	public String get(String cell) {
		return sheet.get(cell);
	}

	public void set(String cell, String value) {
		sheet.put(cell, value);
	}

	public String evaluate(String cell) throws SpreadSheetException {
		try {
			String result = "";
			if (sheet.get(cell).startsWith("'") && sheet.get(cell).endsWith("'")) {
				result = sheet.get(cell).replaceAll("'", "");
			} else if (sheet.get(cell).startsWith("=")) {
				if (sheet.get(cell).startsWith("'", 1) && sheet.get(cell).endsWith("'")) {
					result = sheet.get(cell).replaceAll("=", "");
					result = result.replaceAll("'", "");
				} else if (sheet.containsKey(sheet.get(cell).substring(1))) {
					if (sheet.get(sheet.get(cell).substring(1)).contains("=" + cell)) {
						throw new SpreadSheetException();
					} else
						result = evaluate(sheet.get(cell).substring(1));
				} else if (isInteger(sheet.get(cell).substring(1, 2))) {
					result = "" + arithmeticOperation(sheet.get(cell).substring(1));
				} else {
					throw new SpreadSheetException();
				}
			} else
				result = "" + Integer.parseInt(sheet.get(cell));
			return result;
		} catch (Exception e) {
			throw new SpreadSheetException();
		}
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	public int arithmeticOperation(String value) {
		int result = 0;
		int stringIndex = 0;
		String operator = "+";
		boolean integerValue = false;
		int previousIntegerValue = 0;
		while (stringIndex <= value.length()) {
			if (isInteger(value.substring(stringIndex, stringIndex + 1))) {
				if (integerValue = false) {
					integerValue = true;
					previousIntegerValue = Integer.parseInt(value.substring(stringIndex, stringIndex + 1))
					result = evaluateOperator(result, previousIntegerValue,
							operator);
				}
				else
					
					
			}
		}
		return result;
	}

	private int evaluateOperator(int result, int parseInt, String operator) {
		if (operator.equals("+"))
			result = result + parseInt;
		else if (operator.equals("-"))
			result = result - parseInt;
		else if (operator.equals("*"))
			result = result * parseInt;
		else if (operator.equals("/"))
			result = result / parseInt;
		else if (operator.equals("%"))
			result = result % parseInt;

		return result;
	}
}
