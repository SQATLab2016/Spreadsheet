import java.util.HashMap;

public class Spreadsheet {

	private HashMap<String, String> sheetmap = new HashMap<String, String>();
	private static final String ERROR = "#Error";
	
	public String get(String cell) {	
		return sheetmap.get(cell);	
	}
	
	public void set(String cell, String value) {		
		sheetmap.put(cell,value);
	}
	
	public String evaluate(String cell) {
		
		String content = get(cell);		
		if(isCellReference(content))
			content = get(content);		
					
		return validateCell(content);
	}
	
	private boolean isCellReference(String contents) {				
			return sheetmap.containsKey(contents);
	}
	
	private boolean checkFormula(String contents) {		
		if(contents.startsWith("="))
			return true;
		return false;
	}
	
	private boolean checkString(String contents) {
		if(contents.startsWith("'") && contents.endsWith("'"))
			return true;	
		else
			return false;
	}
	
	private boolean checkInteger(String contents) {
		try  {
			Integer.parseInt(contents);
			
			} catch (NumberFormatException exp) {
				return false;
			}		
		return true;
	}
	
	private String validateCell(String contents) {	

		if(checkFormula(contents))
			return validateCell(contents.substring(1,contents.length()));
		
		if(checkString(contents))
			return contents.substring(1, contents.length()-1);

		if(checkInteger(contents))
			return contents;
		
		return ERROR;
	}
	
}
