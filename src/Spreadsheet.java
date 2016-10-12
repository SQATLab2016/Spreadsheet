
public class Spreadsheet {
	Cell[][] cells;
	
	Spreadsheet(int row,int column) {
		cells = new Cell[row][column];
		for(int i=0; i<row;++i) {
			char col = 'A';
			for(int j=0; j<column;++j, ++col) {
				
				cell[i][j] = new Cell(Character.toString(col)+Integer.toString(i+1));
			}
		}
	}
	public String get(String cell) {
		
		table.get(cell);
		
		return null;
	}
	
	public void set(String cell, String value) {
		// to be implemented
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
}
