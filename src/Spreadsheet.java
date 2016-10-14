import java.util.ArrayList;

public class Spreadsheet {

	private ArrayList<Cell> cells =  new ArrayList<Cell>();
	
	public void set(String cell, String value) {
		Cell C = new Cell();
		C.setId(cell);
		C.setValue(value);
		cells.add(C);
	}
	
	
	public String get(String cell) {
		
		cell.get(id);
		return cell;
	}
	

	
	public String evaluate(String cell) {
	
		if (cell.substring(0).contains("[1-9]+") && (cell.substring(0).matches("[1-9]+"))){
			return cell;	
		}		
		return "#Error";
	}	
}
