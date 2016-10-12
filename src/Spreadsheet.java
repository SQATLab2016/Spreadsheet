
public class Spreadsheet {
	Cell[][] cells;
	int row;
	int column;
	Spreadsheet(int row,int column) {
		this.row=row;
		this.column=column;
		cells = new Cell[row][column];
		for(int i=0; i<row;++i) {
			char col = 'A';
			for(int j=0; j<column;++j, ++col) {
				
				cells[i][j] = new Cell(Character.toString(col)+Integer.toString(i+1));
			}
		}
	}
	public String get(String cell) {
		
		for(int i=0; i<row;++i) {
		
			for(int j=0; j<column;++j) {
				
				if(cells[i][j].location.equals(cell)) return cells[i][j].value;
				
			}
		}
		
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
