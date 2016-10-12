import static org.junit.Assert.*;

import org.junit.Test;

public class SpreadsheetTest {
	
	Spreadsheet sheet = new Spreadsheet();

	@Test
	public void testSpreadsheet_setA1_1_getA1_return1() {
		sheet.set("A1", "1");

		assertEquals(sheet.get("A1"), "1");

	}
	
	@Test
	public void testSpreadsheet_setB2_neg3_getB2_returnneg3() {
		sheet.set("B2", "-3");

		assertEquals(sheet.get("B2"), "-3");

	}

	


}
