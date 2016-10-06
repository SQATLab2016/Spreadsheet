import java.util.ArrayList;

public class Spreadsheet {
	private ArrayList<Cell> cells = new ArrayList<Cell>();
	
	
	public String get(String cell) {
		// to be implemented
		return null;
	}
	
	public void set(String cell, String value) {
		cells.add(new Cell(cell, value));
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
