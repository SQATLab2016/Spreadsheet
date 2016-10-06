
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

	public void evaluate(String cell) {
		// to be implemented
			
	}
	
	public String addition(){
		String result ="";
		
		return result;
		
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
