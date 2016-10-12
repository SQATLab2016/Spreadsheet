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
		sh.set("A7", "6");
		System.out.print(sh.get("A7"));
		assertEquals(sh.get("A7"),null);
		
	}

}
