import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spreadsheet {

	private String excel[][] = new String[26][26];
	
	private int AlphabetToNum(String str){
		char[] ch  = str.toCharArray();
		for(char c : ch)
		{
			int temp = (int)c;
			int temp_integer = 64; //for upper case
			if(temp<=90 & temp>=65)
				return temp-temp_integer;
		}
		return 0;
	 }
	
	private boolean isCell(String split) {
		// TODO Auto-generated method stub
		String[] str = split.split("");
		
		Pattern p = Pattern.compile("{upper}");
		Pattern p2 = Pattern.compile("{digit}");
		Matcher m = p.matcher(str[0]);
		Matcher m2 = p2.matcher(str[1]);
	    if (m.find() & m2.find())
	    	return true;
		return false;
	}
	
	public String get(String cell) {
		
		String[] str = cell.split("");
		
		return excel[AlphabetToNum(str[0])][Integer.parseInt(str[1])];
		
	}
	
	public void set(String cell, String value) {
		
		String[] str = cell.split("");	
		excel[AlphabetToNum(str[0])][Integer.parseInt(str[1])] = value;
	}
	
	public String evaluate(String cell) {
		int  resultNum=0;
		int count=0;
		String result="";
		
		String data = get(cell);
		String[] str = data.split("");
		
		for(int i=0; i<str.length; i++){

			switch(str[i]){
				case "=":
					if(isCell(data.split("=")[1]))
						
					break;
				case "-":
					if(i-1<0)
						resultNum = 0-Integer.parseInt(str[1]);
						result = result + String.valueOf(resultNum);
						break;
				case "'":
					String spl1 = data.split("'")[1];
					if(count==1)
						result = result + spl1;
					count++;
					break;
			}
		}
		
		if(result!="")
			return result;
		
		return "#Error";
		
	}
	
}
