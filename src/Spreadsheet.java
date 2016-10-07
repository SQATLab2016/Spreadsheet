import java.util.ArrayList;

public class Spreadsheet {

	 ArrayList<String> cells=new ArrayList<String>();
	 
	 
	
	public String get(String cell) {
		          
		return  cells.get(cells.indexOf(cell)+1);
				
	}
	
	public void set(String cell, String value) {
		cells.add(cell);
		cells.add(value);

	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
