import java.util.Arrays;

public class Spreadsheet {
	Object [ ] [ ] sheet = new Object [ 4 ] [ 5 ] ;
	

	public class IntCell {
		public int Integer;
		
		public IntCell (int a){
			a = Integer;
			
		}
	}

	public class StringCell{
		public String Stringy;
		
		public StringCell (String a){
			a = Stringy;
		}
	}


	public String get(String cell) {
		// to be implemented
		return cell;
	}
	
	public void set(String cell, String value) {
		//A1 must be interpreted as [1] [A] = [1] [1]
		
		char columnchar = cell.charAt(0);
		
		char columnletter [] ={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'L', 'M' };
		//int column [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		
		int column = Arrays.asList(columnletter).indexOf(columnchar);
		
		
		if (value.contains("'")){
			StringCell s = new StringCell(value);
		}else{
			int a = Integer.parseInt(value);
			IntCell i = new IntCell(a);
		}
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
