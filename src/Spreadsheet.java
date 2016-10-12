import java.util.Hashtable;

public class Spreadsheet {
	Hashtable<String, String> cells;
	
	private String[] allowedIntegerChars = {"1","2","3","4","5","6","7","8","9","-" };
	public final String STR_MARK_IN_THE_MIDDLE_ERROR_MSG =
			"String contains ' character(s) that is not at the beginning or end of string";
	public final String ERROR_MESSAGE = "#Error";
	public final boolean STR_MARKS_ALLOWED_INSIDE_STRING = false;
	
	public Spreadsheet() {
		cells = new Hashtable<String,String>();
	}

	public String get(String cell) throws SpreadsheetException{
		if (null == cell)
			throw new SpreadsheetException("Non null string expected for cell identifier");
		
		return cells.get(cell);
	}
	
	public void set(String cell, String value) {
		// to be implemented
		cells.put(cell, value);
	}
	
	public String evaluate(String cell) throws SpreadsheetException {
		return evaluateCell(cell);
	}
	
	private String evaluateCell(String cell) throws SpreadsheetException {
		String rawVal = cells.get(cell);
		System.out.println("rawVal == " + rawVal);
		
		return evaluation(rawVal);
	}
	
	private String evaluateValue(String value) throws SpreadsheetException {
		return evaluation(value);
	}
	
	private String evaluation(String value) throws SpreadsheetException {
		if (containsFormulaExpression(value))
			return evaluateValue(processFormula(value));
		
		if (containsString(value))
			return evaluatedString(value);
		
		if (!containsAllowedIntegers(value))
			return ERROR_MESSAGE;
		
		return value;
	}
	
	private boolean containsFormulaExpression(String value) throws SpreadsheetException {
		if (charAsStringFromPos(value, 0).equals("="))
			return true;
		return false;
	}
	
	private String processFormula(String toProcess) {
		return toProcess.substring(1);
	}
	
	private boolean containsString(String value) throws SpreadsheetException {
		if (!(charAsStringFromPos(value, 0).equals("'") && charAsStringFromPos(value, value.length() - 1).equals("'")))
			return false;
		
		if ( !STR_MARKS_ALLOWED_INSIDE_STRING)
			if (2 == characterCount(value, "'"))
				return true;

		throw new SpreadsheetException(STR_MARK_IN_THE_MIDDLE_ERROR_MSG);
	}
	
	private int characterCount(String str, String targetChar) throws SpreadsheetException {
		int count = 0;
		
		if (targetChar.length() != 1)
			throw new SpreadsheetException("Character count target length must be 1");
		
		for (int i = 0; i < str.length(); i++) {
			if (charAsStringFromPos(str, i).equals(targetChar)) {
				count++;
			}
		}
		
		return count;
	}
	
	private String evaluatedString(String unevaluatedString) throws SpreadsheetException {
		if (false == STR_MARKS_ALLOWED_INSIDE_STRING)
			return removeFirstAndLastChar(unevaluatedString);
		
		throw new SpreadsheetException("String evaluation method not found");
	}
	
	private String removeFirstAndLastChar(String target) {
		String processedTarget = target.substring(1, target.length() - 1);
		
		assert (target.length() - 2) == processedTarget.length();
		
		return processedTarget;
	}
	
	private String charAsStringFromPos(String str, int pos) throws SpreadsheetException {
		if (pos < 0 || pos > (str.length() - 1))
			throw new SpreadsheetException("Position out of bounds when getting string of 1 len from a string");
		
		String ret = str.substring(pos, pos + 1); 
		
		assert 1 == ret.length();
		
		return ret;
	}
	
	private boolean containsAllowedIntegers(String value) throws SpreadsheetException {
		for (int i = 0; i < value.length(); i++) {
			if (!isAllowedInteger(charAsStringFromPos(value, i)))
				return false;
		}
		
		return true;
	}
	
	private boolean isAllowedInteger(String character) throws SpreadsheetException {
		if (character.length() > 1)
			throw new SpreadsheetException("Checking if integer is allowed possible for only strings with len of 1");
		
		for (int i = 0; i < allowedIntegerChars.length; i++) {
			if (character.equals(allowedIntegerChars[i]))
				return true;
		}
		
		return false;
	}
	
}
