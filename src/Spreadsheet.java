import java.util.HashMap;

public class Spreadsheet {
	
	static HashMap<String, String> hashMap = new HashMap<String, String>();

	public static String get(String cell) {
		String value = hashMap.get(cell);
		return value;
	}
	
	public void set(String cell, String value) {
		hashMap.put(cell,value);
	}
	
	public String evaluate(String cell) {
		String value = hashMap.get(cell);
		int i = 0;
		int j = value.length()-1; // j=2
		//first char is "=" 
		if(value.charAt(i)=='='){
			//second or last char is "'"
			if(value.charAt(i+1)=='\'' || value.charAt(value.length()-1)=='\''){
				//second and last chars are both "'"
				if(value.charAt(i+1)=='\'' && value.charAt(value.length()-1)=='\''){
					//return chars between ''
					return value.substring(2, value.length()-1);
				}
				//one of second and last char is not "'"
				else
					//return error
					return "#Error";
			}
			//chars after "=" can be found in other cells
			else if(hashMap.containsKey(value.substring(1,value.length()))){
				//find its value in next cells
				while(hashMap.containsKey(value.substring(1,value.length()))){
					//this value become next cell to be found
					value = hashMap.get(value.substring(1,value.length()));
					//circular
					if(value.substring(1,value.length()).equals(cell))
						return "#Circular";
					//value of this cell doesn't start with a "="
					else if(value.charAt(i) != '='){
						//value of this cell start or end with a "'"
						if(value.charAt(i)=='\'' || value.charAt(value.length()-1)=='\''){
							//first and last chars are both "'"
							if(value.charAt(i)=='\'' && value.charAt(value.length()-1)=='\''){
								//return chars between ''
								return value.substring(1, value.length()-1);
							}
							//one of second and last char is not "'"
							else
								//return error
								return "#Error";			
						}
						//value doesn't start with a "'"
						else
							//check every char in value
							for(i=0;i<value.length();i++){
								//there are illegal char in value
								if( !(value.charAt(i)>='0' && value.charAt(i)<='9' || value.charAt(i)=='-'))
									//return error
									return "#Error";
							}		
						//there isn't illegal char in value
						return value;
					}
				}
			}
			//including calculating
			else
				return value.substring(1, j);		
		}
		else if(value.charAt(i)=='\'' && value.charAt(j)=='\'')
			return value.substring(1, j);
		else if((value.charAt(i)=='\'' && value.charAt(j)!='\'') || (value.charAt(i)!='\'' && value.charAt(j)=='\''))
			return "#Error";
		else
			for(i=0;i<value.length();i++){
				if(! (value.charAt(i)>='0' && value.charAt(i)<='9' || value.charAt(i)=='-'))
					return "#Error";
			}
		return value;
	}
	
}
