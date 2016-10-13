import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	Cell Cell = new Cell();
	Spreadsheet Spreadsheet = new Spreadsheet();
	
	
	
	@Test
	public void GetCellValue(){
	
		Cell.value="a";
		assertEquals("","a",Cell.getValue());
	}
	
	@Test
	public void SetCellValue(){
		Cell.setValue("2");
		assertEquals("","2",Cell.value);
	}
	
	@Test	
	public void SetCellName(){
		Cell.setName("A1");
		assertEquals("","A1",Cell.name);
	}
	
	
	@Test
	public void NewCell(){
		Spreadsheet.set("A2", "1");
		assertEquals("","1",Spreadsheet.get("A2").getValue());
		
	}
	
	@Test
	public void GetCellValue_INT(){
		Cell.value="1";
		assertEquals("","1",Cell.getValue());
	}
	
	@Test
	public void Evaluate_int(){
		Spreadsheet.set("A1","3");
		assertEquals("",3,Spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void Evaluate_negativ_int(){
		Spreadsheet.set("A1","-1");
		assertEquals("",-1,Spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void Evaluate_wrongly_formated(){
		Spreadsheet.set("A1","5A");
		assertEquals("","#Error",Spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void Evaluate_string(){
		Spreadsheet.set("A1","value");
		assertEquals("","value",Spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void Evaluate_wrong_char(){
		Spreadsheet.set("A1","val|ue");
		assertEquals("","#Error",Spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void Evaluate_equals_sign(){
		Spreadsheet.set("A1","=3");
		assertEquals("",3,Spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void Evaluate_equal_string(){
		Spreadsheet.set("A1","=value");
		assertEquals("","value",Spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void Reference(){
		Spreadsheet.set("A1","value");
		Spreadsheet.set("A2","=A1");
		assertEquals("","value",Spreadsheet.evaluate("A2"));
	}
	@Test
	public void Set_value(){
		Spreadsheet.set("A1"," value");
		Spreadsheet.set("A1","1");
		assertEquals("",1,Spreadsheet.evaluate("A1"));
	}
	
}
