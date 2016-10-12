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
		System.out.print(sh.get("D6"));
		assertEquals(sh.get("D6"),"7");
		
	}

}
