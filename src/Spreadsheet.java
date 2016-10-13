
public class Spreadsheet {

	public Spreadsheet() {

	}

	String cellVar = "0";

	public String get() {
		// to be implemented
		return cellVar;

	}

	public void set(String value) {
		// to be implemented

		cellVar = value;

	}
	public static boolean isNumeric(String value)
	{
	    for (char c : value.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}

	public void evaluate(String cell) {
		// to be implemented

	}

	public String addition(String value1, String value2) {

		value1.replaceAll("\\s+", "");
		value2.replaceAll("\\s", "");

		int parameter1 = Integer.parseInt(value1);
		int parameter2 = Integer.parseInt(value2);

		int var = parameter1 + parameter2;

		String result = String.valueOf(var);
		return result;

	}

	public String subtraction(String value1, String value2) {
		value1.replaceAll("\\s+", "");
		value2.replaceAll("\\s+", "");

		int parameter1 = Integer.parseInt(value1);
		int parameter2 = Integer.parseInt(value2);

		int var = parameter1 - parameter2;

		String result = String.valueOf(var);
		return result;

	}

	public String multiplication(String value1, String value2) {
		value1.replaceAll("\\s+", "");
		value2.replaceAll("\\s+", "");
		
		int parameter1 = Integer.parseInt(value1);
		int parameter2 = Integer.parseInt(value2);

		int var = parameter1 * parameter2;

		String result = String.valueOf(var);
		return result;

	}

	public String division(String value1, String value2) {
		value1.replaceAll("\\s+", "");
		value2.replaceAll("\\s+", "");

		if (value2.equals("0")) {
			return "#Error";
		}
		int parameter1 = Integer.parseInt(value1);
		int parameter2 = Integer.parseInt(value2);

		int var = parameter1 / parameter2;

		String result = String.valueOf(var);
		return result;

	}

	public String module(String value) {
		value.replaceAll("\\s+", "");

		value = value.startsWith("-") ? value.substring(1) : value;

		return value;

	}

	public boolean isInteger(String parameter) {

		try {
			Integer.parseInt(parameter);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}

		return true;
	}

}
