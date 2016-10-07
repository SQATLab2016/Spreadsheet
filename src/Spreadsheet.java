import java.util.ArrayList;

public class Spreadsheet {

	 ArrayList<String> cells=new ArrayList<String>();
	
	public String get(String cell) {
		      
		return cells.get(cells.lastIndexOf(cell)+1); // 1 
				
	}
	
	public void set(String cell, String value) {
		cells.add(cell);
		cells.add(value);

	}
	
	public String evaluate(String cell) {
		if (cells.get(cells.lastIndexOf(cell)+1).startsWith("0") || // starts with numbers or signs
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
						if(!(cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("0")|| // 3 not countinious with number
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
							cells.get(cells.lastIndexOf(cell)+1); // 2 number 
						}
				    }	
				}else if(cells.get(cells.lastIndexOf(cell)+1).startsWith("’")){ // starts with quote
					
					if(cells.get(cells.lastIndexOf(cell)+1).endsWith("’")){ // 4 ends with quote
						
						return cells.get(cells.lastIndexOf(cell)+1).substring(1,cells.get(cells.lastIndexOf(cell)+1).length()-1);
						
					}else{  // 5 starts with quote not ends with quote 
						return "#Error";
					}
					
				}else if(cells.get(cells.lastIndexOf(cell)+1).startsWith("=")){ // starts with equation
					   if(cells.get(cells.lastIndexOf(cell)+1).substring(1,2).equals("’")){ // starts with equation end quote 
						   if(cells.get(cells.lastIndexOf(cell)+1).endsWith("’")){ // 6
							   return cells.get(cells.lastIndexOf(cell)+1).substring(2,cells.get(cells.lastIndexOf(cell)+1).length()-1);
						   }else{
							   return "#Error"; // 7
						   }
					   }else if(cells.contains(cells.get(cells.lastIndexOf(cell)+1).substring(1))){ // 8 =A1 ALSO 9
						   if()
						   
						   return evaluate(cells.get(cells.lastIndexOf(cell)+1).substring(1));
					   }
				}else{
					return cells.get(cells.lastIndexOf(cell)+1);
				}
				return cells.get(cells.lastIndexOf(cell)+1);
	}
	
}
