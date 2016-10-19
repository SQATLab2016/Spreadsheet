import java.util.HashMap;

public class Spreadsheet {
	private String error = "#Error";
	HashMap<String, Object> sheet = new HashMap<String, Object>();
	
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+");  //match a number with optional '-' and decimal.
	}
	
	public static boolean isAlphaNumeric(String str) {
		return str.matches("-?[a-zA-Z0-9]+");
	}
	
	public static boolean containsNumeric(String str) { 
		return str.matches(".*\\d.*");
	}
	
	public static boolean isString(String str) {
		return str.matches("'.*'");
	}
	
	public static boolean isBroken(String str) {
		if(str.matches("'.*[^\\']")) {
			return true;
		}
		if(str.matches("[^\\'=].*'")) {
			return true;
		}
		if(str.matches("='.*[^\\']")) {
			return true;
		}
		if(str.matches("=[^\\'].*'")) {
			return true;
		}
		return false;
	}
	
	public static boolean isFormula(String str) {
		return str.matches("=.*");
	}
	
	public static boolean isStringFormula(String str) {
		return str.matches("=\\'.*\\'");
	}
	
	public static boolean isIntegerFormula(String str) {
		return str.matches("=\\d+");
	}
	
	public static boolean isReference(String str) {
		return str.matches("=[A-Za-z][0-9]+");
	}
	
	public String get(String cell) {
		// to be implemented
		return sheet.get(cell).toString();
	}
	
	public void set(String cell, String value) {
		// to be implemented
		sheet.put(cell, value);
	}
	
	private Object evaluateFormula(String formula) {
		if(Spreadsheet.isIntegerFormula(formula)) {
			return Integer.parseInt(formula.substring(1, formula.length()));
		} else {
			if(Spreadsheet.isReference(formula)) {
				String reffed = get(formula.substring(1, formula.length()));
				return reffed.substring(1, reffed.length() - 1);
			} else {
				return formula.substring(2, formula.length() - 1);
			}
		}
	}
	
	public Object evaluate(String cell) {
		// to be implemented
		Object v = sheet.get(cell);
		String sv = v.toString();
		if(Spreadsheet.isAlphaNumeric(sv)) {
			if(Spreadsheet.isNumeric(sv)) {
				return Integer.parseInt(sv);
			} else {
				if(Spreadsheet.containsNumeric(sv)) {
					return error;
				} 
			}
		} else {
			if(Spreadsheet.isBroken(sv)) {
				return error;
			}
			if(Spreadsheet.isFormula(sv)) {
				return evaluateFormula(sv);
			}
			if(Spreadsheet.isString(sv)) {
				return sv.substring(1,  sv.length()- 1);
			}
		}
		return v;
	}
	
}
