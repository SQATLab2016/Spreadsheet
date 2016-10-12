import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testGetCell() {
		Spreadsheet sh = new Spreadsheet(5,5);
		System.out.print(sh.get("D5"));
		assertEquals(sh.get("D5"),"7");
		
	}

}
