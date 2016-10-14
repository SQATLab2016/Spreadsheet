import java.util.*;

public class Spreadsheet {
	
	private HashMap<String, String> cells;
	
	public Spreadsheet(){
		cells = new HashMap<String, String>();
	}

	public String get(String cell) {
		// to be implemented
		return cells.get(cell);
	}
	
	public void set(String cell, String value) {
		
		// to be implemented
		cells.put(cell, value);
	}
	
	public String evaluate(String cell) {
		// to be implemented
		String ev = cells.get(cell);
		if(checkEquation(ev)){
			ev = ev.substring(1);
			if(ev.charAt(0) != '\''){
				if(isCircular(cell, cells.get(ev))){
					return "#Circular";
				}
				ev = evaluate(ev);
			}
		}
	    if(checkFormat(ev)){
	    	if(ev.charAt(0) == '\''){
	    		ev = ev.substring(1, ev.length() - 1);
	    		return ev;
	    	}
	    	return ev;
	    }
	    return "#Error";
	}
	public boolean checkFormat(String cell){
		for(int i = 0; i < cell.length(); i++){
			if(cell.charAt(0) == '-'){
				continue;
			}
			else if(cell.charAt(0) == '\'' && 
					cell.charAt(cell.length() - 1) == '\''){
				return true;
			}
			else if(cell.charAt(i) >= '0' && cell.charAt(i) <= '9'){
				continue;
			}
			else{
				return false;
			}
		}
		return true;
	}
	public boolean checkEquation(String cell){
		if(cell.charAt(0) == '='){
			return true;
		}
		return false;
	}
	public boolean isCircular(String current, String next){
		boolean circular = false;
		if(checkEquation(next)){
			next = next.substring(1);
		}
		if(current.equals(next)){
			return true;
		}
		
		
		return circular;
		
		
	}
	
}
