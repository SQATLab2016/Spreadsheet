import java.util.HashSet;
import java.util.Set;

public class Spreadsheet {
	
	private Set<Cell> cells;
	
	public Spreadsheet() {
		cells = new HashSet<Cell>();
		cells.add(new Cell("A1", ""));
		cells.add(new Cell("A2", ""));
		cells.add(new Cell("A3", ""));
		cells.add(new Cell("A4", ""));
		cells.add(new Cell("A5", ""));
	}
	
	public String get(String cell) {
		for(Cell c : cells) {
			if(c.getCellName() == cell) {
				return c.getCellContent();
			}
		}
		throw new IllegalArgumentException("Cell doesn't exist");
	}
	
	public void set(String cell, String value) {
		for(Cell c : cells) {
			if(c.getCellName() == cell) {
				c.setCellContent(value);
				return;
			} 
		}
		throw new IllegalArgumentException("Cell doesn't exist");
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
