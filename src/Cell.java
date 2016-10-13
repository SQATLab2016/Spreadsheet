
public class Cell {
	
	private String cellName;
	private String cellContent;
	private boolean isNumber;
	private boolean isFormula;
	
	public Cell(String name, String content) {
		this.cellName = name;
		this.cellContent = content;
		this.isNumber = false;
		this.isFormula = false;
	}
	
	public String getCellContent() {
		if(isFormula || isNumber) {
			return this.cellContent;
		}
		if(cellContent.charAt(0) == '\'' && cellContent.charAt(cellContent.length()-1) == '\'') {
			StringBuilder build = new StringBuilder(this.cellContent);
				build.deleteCharAt(0);
				build.deleteCharAt(cellContent.length()-2);
			String result = build.toString();
			return result;
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
		this.cellContent = content;
		this.isNumber = true;
	}
	
	public void setFormula(boolean isFormula) {
		this.isFormula = isFormula;
	}
	
	public boolean isFormula() {
		return this.isFormula;
	}
	
	/*
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
	*/
}
