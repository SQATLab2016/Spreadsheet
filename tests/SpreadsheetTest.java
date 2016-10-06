import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	Cell Cell = new Cell();
	Spreadsheet Spreadsheet = new Spreadsheet();
	
	@Test
	public void test() {
		fail("Not yet implemented");
		
	}
	
	@Test
	public void GetCellValue(){
	
		Cell.value="1";
		assertEquals("","1",Cell.getValue());
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
		assertEquals("","1",Spreadsheet.get("A2"));
		
	}
	
	@Test
	public void GetCellValue_INT(){
		Cell.value="1";
		assertEquals("",1,Cell.getValue());
	}

}
