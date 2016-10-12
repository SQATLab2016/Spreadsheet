
public class Spreadsheet {
	String cell;
	String value;
			
	public String get(String cell) {
		
		return this.value;
	}
	
	public void set(String cell, String value) {
		this.cell = cell;
		this.value = value;
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
