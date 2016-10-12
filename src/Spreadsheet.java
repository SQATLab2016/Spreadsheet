import java.util.ArrayList;
import java.util.HashMap;

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
	
	private boolean isCircularRecursive(String value) {
		if (value.length() > 1 && value.charAt(0) == '='
				&& value.charAt(1) >= 'A' && value.charAt(1) <= 'Z') {
			String key = value.substring(1, value.length());
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
	}
	private boolean isCircular(String key) {
		mVisited.clear();
		return isCircularRecursive(get(key));
	}
	
	public String evaluate(String cell) {
		String value = get(cell);
		
		if (value.length() > 0) {
			if (value.charAt(0) == '=' && value.length() > 1) {
				if (value.charAt(1) == '\'') {
					if (value.charAt(value.length() - 1) == '\'' && value.length() > 2) {
						value = value.substring(2, value.length() - 1);
					} else {
						value = ERROR;
					}
					
				} else if ((value.charAt(value.length() - 1) == '\'')) {
					if (value.charAt(1) == '\'') {
						value = value.substring(2, value.length() - 1);
					} else {
						value = ERROR;
					}
					
				} else if (value.charAt(1) == '-' || (value.charAt(1) >= '0' && value.charAt(1) <= '9')) {
					boolean isInteger = true;
					for (int i = 1; i < value.length(); i++) {
						char c = value.charAt(i);
						if (i == 1 && c == '-')
							continue;
						
						if (c < '0' || c > '9') {
							isInteger = false;
							break;
						}
					}
					
					if (isInteger) {
						value = value.substring(1, value.length());
					} else {
						value = ERROR;
					}
					
				} else if (value.charAt(1) >= 'A' && value.charAt(1) <= 'Z') {
					String key = value.substring(1, value.length());
					if (mValues.containsKey(key)) {
						if (isCircular(key)) {
							return CIRCULAR;
						} else {
							value = evaluate(key);
						}
					} else {
						value = ERROR;
					}
					
				} else {
					value = ERROR;
				}
			} else if (value.charAt(0) == '\'') {
				if (value.length() > 1 && value.charAt(value.length() - 1) == '\'') {
					value = value.substring(1, value.length() - 1);
				} else {
					value = ERROR;
				}
			} else {
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
				
				if (!isInteger)
					value = ERROR;
			}
		}
		
		return value;
	}
	
}
