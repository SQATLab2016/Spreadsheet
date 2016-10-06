
public class Cell  {
	public  String name;
	public String value;
	
	
	public Object getValue(){ 
		if(Number.isNaN(Integer.parseInt(value,10))) {return this.value;}
	
		else return Integer.parseInt(value,10);
	}
	public void setValue(String value) {

		this.value=value;
		
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	
	public Cell(String name, String value){
		this.value=value;
		this.name=name;
	}
	public Cell(){}

}
