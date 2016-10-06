
public class Spreadsheet extends Cell {
	
	public Cell[] Spreadsheet;

	public String get(String cell) {
		
		return getCell().getValue();
	}
	
	private Cell getCell() {
		
		return null;
	}

	public void set(String cell, String value) {
		// to be implemented
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
