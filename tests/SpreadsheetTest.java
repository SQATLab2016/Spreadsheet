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
	public void testSpreadsheetInvalidInt_setC3_2A_evaluateC3_return_Error(){
		sheet.set("C3", "2A");
		
		assertEquals(sheet.evaluate("C3"), "#ERROR");		
		
	}
	
	@Test
	public void testSpreadsheetString_setC3_aString_evaluateC3_return_aString(){
		sheet.set("C3", "'a String'");
		
		assertEquals(sheet.evaluate("C3"), "a String");		
		
	}
	
	@Test
	public void testSpreadsheetString_setC3_aString_withoutEndQuote_evaluateC3_return_ERROR(){
		sheet.set("C3", "'a String");
		
		assertEquals(sheet.evaluate("C3"), "#ERROR");		
		
	}
	

	@Test
	public void testSpreadsheetequalSign_String_setC3_EqualsaString_evaluateC3_return_aString(){
		sheet.set("C3", "='a String'");
		
		assertEquals(sheet.evaluate("C3"), "a String");		
		
	}
	
	@Test
	public void testSpreadsheetequalSign_Int_setC3_EqualsInt_evaluateC3_return_aString(){
		sheet.set("C3", "='a String'");
		
		assertEquals(sheet.evaluate("C3"), "a String");		
		
	}


}
