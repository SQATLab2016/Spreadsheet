import java.util.ArrayList;

public class Spreadsheet {

	 ArrayList<String> cells=new ArrayList<String>();
	 
	 
	
	public String get(String cell) {
		          
		
		if (cells.get(cells.lastIndexOf(cell)+1).startsWith("0") ||
		cells.get(cells.lastIndexOf(cell)+1).startsWith("1") ||
		cells.get(cells.lastIndexOf(cell)+1).startsWith("2") ||
		cells.get(cells.lastIndexOf(cell)+1).startsWith("3") ||
		cells.get(cells.lastIndexOf(cell)+1).startsWith("4") ||
		cells.get(cells.lastIndexOf(cell)+1).startsWith("5") ||
		cells.get(cells.lastIndexOf(cell)+1).startsWith("6") ||
		cells.get(cells.lastIndexOf(cell)+1).startsWith("7") ||
		cells.get(cells.lastIndexOf(cell)+1).startsWith("8") ||
		cells.get(cells.lastIndexOf(cell)+1).startsWith("9") ||
		cells.get(cells.lastIndexOf(cell)+1).startsWith("-") ||
		cells.get(cells.lastIndexOf(cell)+1).startsWith("+")){
			
			for(int i=1; i<cells.get(cells.lastIndexOf(cell)+1).length() ; i++){
				if(!(cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("0")||
				cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("1")||
				cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("2")||
				cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("3")||
				cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("4")||
				cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("5")||
				cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("6")||
				cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("7")||
				cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("8")||
				cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("9")||
				cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("0"))){
					return "#Error";
				}else{
					cells.get(cells.lastIndexOf(cell)+1);
				}
		    }	
		}else if(cells.get(cells.lastIndexOf(cell)+1).startsWith("’")){
			
			if(cells.get(cells.lastIndexOf(cell)+1).endsWith("’")){
				
				return cells.get(cells.lastIndexOf(cell)+1).substring(1,cells.get(cells.lastIndexOf(cell)+1).length()-1);
				
			}else{
				return "#Error";
			}
			
			
		}else{
			return cells.get(cells.lastIndexOf(cell)+1);
		}
		return cells.get(cells.lastIndexOf(cell)+1);
				
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
