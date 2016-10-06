
public class Cell {
	
	private String cellName;
	private String cellContent;
	private int cellInt;
	private boolean isNumber;
	
	public Cell(String name, String content) {
		this.cellName = name;
		this.cellContent = content;
		this.isNumber = false;
	}
	
	public String getCellContent() {
		if(isNumber) {
			return Integer.toString(cellInt);
		}
		return this.cellContent;
	}
	
	public String getCellName() {
		return this.cellName;
	}
	
	public void setCellContent(String content) {
		try {
			int i = Integer.parseInt(content);
		} catch(NumberFormatException nfe) {
			this.cellContent = content;
			this.isNumber = false;
			return;
		}
		this.cellContent = "";
		this.isNumber = true;
		this.cellInt = Integer.parseInt(content);
	}
}
