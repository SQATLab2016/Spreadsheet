import java.util.HashMap;

public class Spreadsheet {
	public static final String ERR_STR="#Error";
	
	HashMap<String, String> sheet = new HashMap<String, String>();

	public String get(String cell) {
		// to be implemented
		return sheet.get(cell);
	}
	
	public void set(String cell, String value) {
		sheet.put(cell, value);
		// to be implemented
	}
	
	public String evaluate(String cell) {
		// to be implemented
		String val = sheet.get(cell);
		String retval =ERR_STR;
		
		retval=strip_quote(val);
		if (retval==ERR_STR)
			return ERR_STR;
		
		if (retval.startsWith("="))
		{
			retval=strip_quote(val.substring(1, val.length()));
			if (retval==ERR_STR)
				return ERR_STR;
			else 
				if (retval.length()>2)
					return retval;
				try{
				retval=sheet.get(val.substring(1));
				}
			catch (Exception e) {
				
				retval=ERR_STR;
				 
				// TODO: handle exception
			}
		
		}	
			
		if (val.startsWith("-") || val.startsWith("+"))
			retval=val;
		else
			retval=ERR_STR;
		
		return (retval);
		
	}
	
	public String strip_quote(String str)
	{
		String retval=str;
		if (retval.startsWith("\""))
		{
			retval=retval.substring(1);
		
			if (retval.endsWith("\""))
			{
				retval=retval.substring(0, retval.length()-1);
			}
			else
				retval=ERR_STR;
		}
		/*
		else
			if (!str.matches("-?\\d+(\\.\\d+)?"))
				retval=ERR_STR;
				*/
		return retval;
	}
}
