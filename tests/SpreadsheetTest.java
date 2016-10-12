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
	public void testSpreadsheetNegativeInt_setB2_neg3_getB2_returnneg3() {
		sheet.set("B2", "-3");

		assertEquals(sheet.get("B2"), "-3");

	}
	
	@Test
	public void testSpreadsheetEvaluateNegInt_setB2_neg3_evaluateB2_returnneg3() {
		sheet.set("B2", "-3");

		assertEquals(sheet.evaluate("B2"), "-3");

	}

	@Test
	public void testSpreadsheetInvalidInt_setB2_2A_evaluateB2_return_Error(){
		sheet.set("C3", "2A");
		
		assertEquals(sheet.evaluate("C3"), "#ERROR");		
		
	}
	



}
