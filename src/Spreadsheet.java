import java.util.HashMap;

public class Spreadsheet {
	HashMap<String, String> mValues = new HashMap<String, String>();
	
	final public static String ERROR = "#Error";
	final public static String CIRCULAR = "#Circular";
	
	public String get(String cell) {
		// to be implemented
		return null;
	}
	
	public void set(String cell, String value) {
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
					
				} else if (value.charAt(1) != '\'') {
					value = "&" + value.substring(1, value.length());
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
	
		mValues.put(cell, value);
	}
	
	public String evaluate(String cell) {
		String value = (String) mValues.get(cell);
		
		if (value.length() > 0 && value.charAt(0) == '&') {
			String key = value.substring(1, value.length());
			if (mValues.containsKey(key)) {
				String refValue = (String) mValues.get(key);
				if (refValue.length() > 0 && refValue.charAt(0) == '&' && refValue.equals("&" + cell)) {
					return CIRCULAR;
				} else {
					return refValue;
				}
			} else {
				return ERROR;
			}
		}
		
		return value;
	}
	
}
