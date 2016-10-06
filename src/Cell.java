
public class Cell  {
	public  String name;
	public String value;
	
	
	public String getValue(){ 
		if (parseInt(value, 10).isNaN) return this.value;
		else return parseInt(value,10);
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
