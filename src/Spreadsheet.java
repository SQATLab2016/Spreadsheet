import java.util.ArrayList;

public class Spreadsheet {
	private ArrayList<Cell> cells = new ArrayList<Cell>();
	
	
	public String get(String cell) {
		for(Cell c: cells) {
			if(cell.equals(c.getId()))
				return c.getValue();
		}
		return null;
	}
	
	public void set(String cell, String value) {
		cells.add(new Cell(cell, value));
	}
	
	public String evaluate(String cell) {
		String value = get(cell);
		char c = value.charAt(0);
		
		if(Character.isDigit(c) || c =='-') {
			int counter = 0;
			for(char ch: value.toCharArray()){
				if(ch == '-' && counter == 0) {
					
				}
					
				else if(!Character.isDigit(ch))
					return "#Error";
				counter++;
			}
			return value;
		}
		
		else {
			if(c == '\'' && value.substring(value.length() - 1).equals("'")) {
				StringBuilder sb = new StringBuilder(value);
				sb.deleteCharAt(0);
				sb.deleteCharAt(sb.length()-1);
				return sb.toString();
			}
			else
				return "#Error";
		}
	}
	
}
