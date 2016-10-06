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
		assertEquals("","2",Cell.getValue());
	}
	
	
	
	@Test
	public void NewCell(){
		Spreadsheet.set("A1", "1");
		assertEquals("","1",Spreadsheet.get("A1"));
		
	}

}
