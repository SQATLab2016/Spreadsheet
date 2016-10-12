
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
		
		Index index = this.getCellIndex(cell);
		
		if(index != null) 
			return cells[index.i][index.j].value;
		
		return null;
		
	}
	
	public void set(String cell, String value) {
		
		Index index = this.getCellIndex(cell);
		
		if(index != null) 
			cells[index.i][index.j].value = value;
		
	}
	
	Index getCellIndex(String cell){
		Index index = null;
		for(int i=0; i<row;++i) {
			for(int j=0; j<column;++j) {
				
				if(cells[i][j].location.equals(cell)) {
					index = new Index(i,j);
					return index;
				}
				
			}
		}
		return index;
	}
	
	public String evaluate(String cell) {
		String errorMessg = "#Error";
		int op1;
		try {
		    op1 = Integer.parseInt(get(cell));
		} catch (NumberFormatException e) {
		    return errorMessg;
		}
		
		return get(cell);
		
	}
	
}
