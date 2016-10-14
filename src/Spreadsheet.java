import java.util.Hashtable;

public class Spreadsheet {
	Hashtable<String, String> cellsStrings = new Hashtable<String, String>();
	Hashtable<String, Integer> cellsIntegers = new Hashtable<String, Integer>();
	

	public void get(String cell){
		if(cellsStrings.get(cell) != null){
			this.getStrings(cell);
		}else{
			this.getnumbers(cell);
		}
		
	}
	
	public String getStrings(String cell){
		return cellsStrings.get(cell);
	}
	
	public int getnumbers(String cell){
		int convert = Integer.parseInt(cell);
		return convert;
	}
	
	public void set(String cell, String value) {
		
		try{
			int cells = Integer.parseInt(value);
			cellsIntegers.put(cell, new Integer(value));
		}catch(Exception e){
			cellsStrings.put(cell, new String(value));
		}
		
	}
	
	public String evaluate(String cell) {
	
		return null;
	}
	
}
