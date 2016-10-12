import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testGetCell() {
		Spreadsheet sh = new Spreadsheet(5,5);
		System.out.print(sh.get("D6"));
		assertEquals(sh.get("D6"),"7");
		
	}
	
	@Test
	public void testSetCell() {
		Spreadsheet sh = new Spreadsheet(5,5);
		sh.set("A3", "6");
		System.out.print(sh.get("A3"));
		assertEquals(sh.get("A3"),"6");
		
	}

}
