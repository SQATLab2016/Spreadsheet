import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testSpreadsheet_setA1_1_getA1_return1() {
		
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "1");
		
		assertEquals(sheet.get("A1"), "1");
		
	}

}
