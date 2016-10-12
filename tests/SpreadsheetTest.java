import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testGetCell() {
		Spreadsheet sh = new Spreadsheet(5,5);
		System.out.print(sh.get("D5"));
		assertEquals(sh.get("D5"),"7");
		
	}
	
	@Test
	public void testSetCell() {
		Spreadsheet sh = new Spreadsheet(5,5);
		sh.set("A3", "6");
		System.out.print(sh.get("A4"));
		assertEquals(sh.get("A4"),"7");
		
	}

}
