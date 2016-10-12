
public class Cell {
	private String cellName;
	private String cellValue;
	
	Cell(String cell, String value){
		this.setCellName(cell);
		this.setCellValue(value);
		
	}
	
	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

	public String getCellValue() {
		return cellValue;
	}

	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}

	
	
}
