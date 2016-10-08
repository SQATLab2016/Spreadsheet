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
			else if( !(result.endsWith("'") || result.startsWith("'")))
			{
				String r = result.replaceAll(" ", "");
				return calculate(r);
			}
			else 
			{
				if( !(result.endsWith("'") && result.startsWith("'")))
					return "#Error";
				else
				{
					String r = result.replaceAll("'&'", "");
					if( r.indexOf("&")!=-1)
						return "#Error";
					result = r.replaceAll("'", "");
					return result;
				}
			}
		}
		if( result.startsWith("'") || result.endsWith("'") )
		{
			if( result.endsWith("'") && result.endsWith("'") )
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
	
	static public String calculate(String org){
		for( int s=0 ; s<org.length() ; s++ )
		{
			if( !( (org.charAt(s)>='0' && org.charAt(s)<='9') || org.charAt(s) == '+' || org.charAt(s) == '-' || org.charAt(s) == '*' || org.charAt(s) == '/' || org.charAt(s) == '(' || org.charAt(s) == ')' ) ) 
				return "#Error";
		}
		int i = 0, j = 0; // record the index of a string
		int result = 0;
		String origin = org;
		if( (origin.charAt(0)>='0' && origin.charAt(0)<='9') || origin.charAt(0)== '(' )
			origin = "+" + origin;
		while( i<origin.length() )
		{
			j = i+1;
			if( origin.charAt(j)=='(' )
			{
				int count = 1; // record the number of '('
				int index = j+1; // record the position of ')' that matches the first '('
				while( count!=0 && index<origin.length() )
				{
					if( origin.charAt(index)=='(')
						count++;
					else if( origin.charAt(index)==')')
						count--;
					index++;
				}
				if(count!=0)
					return "#Error";
				origin = origin.substring(0,j) + calculate(origin.substring(j+1,index-1)) + origin.substring(index,origin.length());
			}
			if( origin.indexOf("#Error")!=-1)
				return "#Error";
			switch(origin.charAt(i))
			{
			case '+' : j = i+1 ;
					   while( j<origin.length() && origin.charAt(j)>='0' && origin.charAt(j)<='9') j++;
					   result += Integer.parseInt(origin.substring(i+1,j));
					   i = j;
					   break;
			case '-' : j = i+1 ;
					   while( j<origin.length() && origin.charAt(j)>='0' && origin.charAt(j)<='9' ) j++;
				       result -= Integer.parseInt(origin.substring(i+1,j));
				       i = j;
				       break;
			case '*' : j = i+1 ;
					   while( j<origin.length() && origin.charAt(j)>='0' && origin.charAt(j)<='9' ) j++;
			           result *= Integer.parseInt(origin.substring(i+1,j));
			           i = j;
			       	   break;
			case '/' : j = i+1 ;
			   		   while( j<origin.length() && origin.charAt(j)>='0' && origin.charAt(j)<='9' ) j++;
			   		   result /= Integer.parseInt(origin.substring(i+1,j));
			   		   i = j;
			   		   break;
			}
		}
		return Integer.toString(result);
	}
}
