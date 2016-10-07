import java.util.HashMap;

public class Spreadsheet {
	
	private HashMap<String,String> hashmap;
	
	public Spreadsheet(){
		hashmap = new HashMap<String,String>();
	}
	
	public String get(String cell) {
		return hashmap.get(cell);
	}
	
	public void set(String cell, String value) {
		hashmap.put(cell, value);
	}
	
	public String evaluate(String cell) {
		String result = get(cell);
		HashMap<String,Boolean> temp = new HashMap<String,Boolean>();
		while( result.startsWith("="))
		{
			result = result.substring(1,result.length());
			if( result.matches("[A-Z]+\\d") )
			{
				if( temp.containsKey(result) )
					return "#Circular";
				temp.put(result, true);
				result = get(result);
			}
		}
		if( result.startsWith("'"))
		{
			if( result.endsWith("'") )
				result = result.substring(1, result.length()-1);
			else
				result = "#Error";
		}
		else
		{
			for( int i=0 ; i<result.length() ; i++ )
			{
				if( !( (result.charAt(i)>='0' && result.charAt(i)<='9') || result.charAt(i)=='-' ) ) 
				{
					result = "#Error";
					break;
				}
			}
		}
		return result;
	}
	
}
