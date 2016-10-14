import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spreadsheet {
	
	HashMap<String, String> cells = new HashMap<String, String>();

	public String get(String cell) {
		String value = cells.get(cell);
		return value;
	}
	
	public void set(String cell, String value) {
		cells.put(cell, value);
	}
	
	public void isReference(String value) {
		;// TODO
	}
	
	public void getReference(String value) {
		;// TODO
	}
	
	public void isFormula(String value) {
		;// TODO
	}
	
	public String evaluate(String cell) {
		String value = cells.get(cell);
		String return_text = "#Error";
		Boolean isEquals = false;
		
		String firstLetter = value.substring(0, 1);
		
		if (firstLetter.equals("="))
		{
			value = value.substring(1);
			isEquals = true;
			if (!value.matches("[A-Z]"))
			{
				;//System.out.println(value);
			}
		}
		
		try { 
	        Integer.parseInt(value); 
	        return value;
	    } catch(NumberFormatException e) { 
	    	;//
	    } catch(NullPointerException e) {
	    	;//
	    }
		
		Pattern p = Pattern.compile("(?:^|\\s)'([^']*?)'(?:$|\\s)", Pattern.MULTILINE);
		
		Matcher m = p.matcher(value);

		while(m.find()) {
			return_text = m.group(1);
        }
		
		return return_text;
		
	}
	
}
