import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testGetCell() {
		Spreadsheet sh = new Spreadsheet(5,5);
		
		assertEquals(sh.get("A1"),"5");
	}

}
