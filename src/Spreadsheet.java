import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Spreadsheet {
	
	
	List<Cell> Spreadsheet= new ArrayList<>();
	
	public String get(String cell) {
		int i = 0;
		int index=0;
		for (i=0;i<Spreadsheet.size();i++){
			if (Spreadsheet.get(i).name==cell){index=i;}
		}
		
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
