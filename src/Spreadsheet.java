import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Spreadsheet {
	HashMap<String, String> mValues = new HashMap<String, String>();
	ArrayList<String> mVisited = new ArrayList<String>();
	
	final public static String ERROR = "#Error";
	final public static String CIRCULAR = "#Circular";
	
	public String get(String cell) {
		return (String) mValues.get(cell);
	}
	
	public void set(String cell, String value) {
		mValues.put(cell, value);
	}

	private boolean isMathFormula(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) == '+') {
				return true;
			}
		}
		return false;
	}
	
	private String evaluateMathFormula(String value) {
		Scanner scanner = new Scanner(value);
		scanner.useDelimiter("+")

		ArrayList<Integer> integers = new ArrayList<Integer>();
		ArrayList<Character> operators = new ArrayList<Character>();
		
		while (scanner.hasNextInt()) {
			integers.add(scanner.nextInt());

			String next = scanner.next();
			
			if (next.equals('+')) {
				operators.add('+');
				
			} else {
				break;
			}
		}
		
		if (integers.size() > 0) {
			int result = integers.get(0);
			
			for (int i = 0; i < operators.size(); i++) {
				if (operators.get(i) == '+') {
					result += integers.get(i * 2);
				}
			}
			
			return Integer.toString(result);
			
		} else {
			return ERROR;
		}
	}

	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
	private boolean isReference(String value) {
		return value.length() > 0 && value.charAt(0) >= 'A' && value.charAt(0) <= 'Z';
	}

	private boolean isAssignment(String value) {
		return value.length() > 0 && value.charAt(0) == '=';
	}
	
	private String evaluateAssignment(String value) {
		return value.substring(1, value.length());
	}

	private boolean isInteger(String value) {
		return value.length() > 0 && (
				value.charAt(0) == '-' || isDigit(value.charAt(0)));
	}
	
	private String evaluateInteger(String value) {
		boolean isInteger = true;
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			if (i == 0 && c == '-')
				continue;
			
			if (c < '0' || c > '9') {
				isInteger = false;
				break;
			}
		}
		
		if (isInteger) {
			return value;
		} else {
			return ERROR;
		}
	}
	
	private boolean isString(String value) {
		return value.length() > 0 && (value.charAt(0) == '\'' ||
				value.charAt(value.length() - 1) == '\'');
	}
	
	private String evaluateString(String value) {
		if (value.charAt(0) == '\'' &&
			value.charAt(value.length() - 1) == '\'') {
			return value.substring(1, value.length() - 1);
		} else {
			return ERROR;
		}
	}
	
	private boolean isCircularRecursive(String value) {
		if (isAssignment(value)) {
			String key = evaluateAssignment(value);
			if (isReference(key)) {
				if (mVisited.contains(key)) {
					return true;
					
				} else {
					if (mValues.containsKey(key)) {
						mVisited.add(key);
						return isCircularRecursive(get(key));
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private boolean isCircular(String key) {
		mVisited.clear();
		return isCircularRecursive(get(key));
	}
	
	public String evaluate(String cell) {
		String value = get(cell);
		
		if (value.length() > 0) {
			if (isAssignment(value)) {
				value = evaluateAssignment(value);
				
				if (isMathFormula(value)) {
					value = evaluateMathFormula(value);
				} else if (isString(value)) {
					value = evaluateString(value);
				} else if (isInteger(value)) {
					value = evaluateInteger(value);
				} else if (isReference(value)) {
					if (mValues.containsKey(value)) {
						if (isCircular(value)) {
							return CIRCULAR;
						} else {
							value = evaluate(value);
						}
					} else {
						value = ERROR;
					}
					
				} else {
					value = ERROR;
				}
				
			} else if (isString(value)) {
				value = evaluateString(value);
			} else {
				value = evaluateInteger(value);
			}
		}
		
		return value;
	}
	
}
