import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Spreadsheet {
	
	public Spreadsheet(){List<Cell> Spreadsheet= new ArrayList<>();}
	
	List<Cell> Spreadsheet= new ArrayList<>();
	
	public String get(String cell) {
	
		int index = Spreadsheet.indexOf(cell );
		return Spreadsheet.get(index).getValue() ;
	}

	public void set(String cell, String value) {
		 Spreadsheet.add(new Cell(cell, value));
		
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
