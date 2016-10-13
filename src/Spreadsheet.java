import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Spreadsheet {
	
	
	List<Cell> Spreadsheet= new ArrayList<>();
	
	public Cell get(String cell) {
		int i = 0;
		int index=-1;
		for (i=0;i<Spreadsheet.size();i++){
			if (Spreadsheet.get(i).name==cell){index=i;}
		}
		if (index==-1)return null;
		return Spreadsheet.get(index) ;
	}

	public void set(String cell, String value) {
		if (get(cell)!=null)get(cell).setValue(value);
		else Spreadsheet.add(new Cell(cell, value));
		
	}
	public boolean notint(String value){
		int i = 0;
		for(i=0;i<value.length();i++){
			if(value.charAt(i)!='0'&&value.charAt(i)!='1'&&value.charAt(i)!='2'&&value.charAt(i)!='3'&&value.charAt(i)!='4'&&value.charAt(i)!='5'&&value.charAt(i)!='6'&&value.charAt(i)!='7'&&value.charAt(i)!='8'&&value.charAt(i)!='9'){return true;} 
		}
		return false;
	}
	
	public boolean notString(String value){
		int i = 0;
		int occ= 0;
		for (i=0;i<value.length();i++){
		if(value.charAt(i)!='0'&&value.charAt(i)!='1'&&value.charAt(i)!='2'&&value.charAt(i)!='3'&&value.charAt(i)!='4'&&value.charAt(i)!='5'&&value.charAt(i)!='6'&&value.charAt(i)!='7'&&value.charAt(i)!='8'&&value.charAt(i)!='9'){occ++;}
		}
		if(occ!=0&&occ!=value.length())return true;
		return false;
	}
	
	public boolean WrongFormat(String value){
		int i = 0;
		for(i=0;i<value.length();i++){
			if(value.charAt(i)=='"'||value.charAt(i)=='|'||value.charAt(i)=='&'||value.charAt(i)=='{')return true;
		}
		return false;	
	}
	
	
	public Object evaluate(String cell) {
		String value= get(cell).getValue();
		if (value.charAt(0)=='=')value=value.substring(1);
		if (get(value)!=null){ System.out.println(value);}
		if (value.charAt(0)=='-'&&notint(value.substring(1))==false)return Integer.parseInt(value,10);
		if (notString(value)==true||WrongFormat(value)==true)return "#Error";
		if (notint(value)==true){return value;}
		return Integer.parseInt(value,10);
		 
		
	}
	
}
