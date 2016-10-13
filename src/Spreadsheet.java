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
	
	public void set(String cell, String value) {
		boolean isFormula = false;
		if(value.charAt(0) == '=') {
			 isFormula = true;
		}
		value = checkErrors(value);
		for(Cell c : cells) {
			if(c.getCellName() == cell) {
				c.setCellContent(value);
				c.setFormula(isFormula);				
				return;
			} 
		}
		throw new IllegalArgumentException("Cell doesn't exist");
	}
	
	public String evaluate(String cell) {
		for(Cell c : cells) {
			//System.out.println("Cell: " + c.getCellName() + ", Content: " + c.getCellContent() + ", isFormula: " + c.isFormula());
			if(c.getCellName() == cell) {
				System.out.println(c.getCellName());
				if(c.isFormula()) {		
					evaluate(c.getCellContent());
				} 
				
				return c.getCellContent();
			}
		}
		throw new IllegalArgumentException("Cell doesn't exist");
	}
	
	private String checkErrors(String value) {
		System.out.println(value);
		if(value.charAt(0) == '=') {
			value = value.substring(1, value.length());
			System.out.println(value);
		}
		if(value.charAt(0) == '\'' && value.charAt(value.length()-1) == '\'') {
			return value;
		}
		if(isCellReference(value)) {
			return value;
		}
		try {
			int i = Integer.parseInt(value);
		} catch(NumberFormatException nfe) {
			value = "#Error";
			return value;
		}
		return value;
	}
	
	private boolean isCellReference(String value) {
		for(Cell c : cells) {
			if(c.getCellName().equals(value)) {
				return true;
			}
		}
		return false;
	}
	
}
