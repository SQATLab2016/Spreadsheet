import static org.junit.Assert.*;

import org.junit.Test;

public class SpreadsheetTest {
	
	private static final String ERROR = "#ERROR";
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

		assertEquals("-3", sheet.evaluate("B2"));

	}

	@Test
	public void testSpreadsheetInvalidInt_setC3_2A_evaluateC3_return_Error(){
		sheet.set("C3", "2A");
		
		assertEquals(sheet.evaluate("C3"), ERROR);		
		
	}
	
	@Test
	public void testSpreadsheetString_setC3_aString_evaluateC3_return_aString(){
		sheet.set("C3", "'a String'");
		
		assertEquals(sheet.evaluate("C3"), "a String");		
		
	}
	
	@Test
	public void testSpreadsheetString_setC3_aString_withoutEndQuote_evaluateC3_return_ERROR(){
		sheet.set("C3", "'a String");
		
		assertEquals(sheet.evaluate("C3"), ERROR);		
		
	}
	

	@Test
	public void testSpreadsheetequalSign_String_setC3_EqualsaString_evaluateC3_return_aString(){
		sheet.set("C3", "='a String'");
		
		assertEquals(sheet.evaluate("C3"), "a String");		
		
	}
	
	@Test
	public void testSpreadsheetequalSign_Int_setC3_Equals4_evaluateC3_return_4(){
		sheet.set("C3", "=4");
		
		assertEquals(sheet.evaluate("C3"), "4");		
		
	}
	
	@Test
	public void testSpreadsheetequalSignWithError_Int_setC3_Equals3D_evaluateC3_return_Error(){
		sheet.set("C3", "=D3");
		
		assertEquals(sheet.evaluate("C3"), ERROR);		
		
	}
	
	@Test
	public void testSpreadsheetequalSignWithCellRef_setA3_13_setC3_EqualsA3_evaluateC3_return_13(){
		sheet.set("A3", "13");
		sheet.set("C3", "=A3");
		
		assertEquals(sheet.evaluate("C3"), "13");		
		
	}
	
	@Test
	public void testSpreadsheetequalSignWithCellRefWithString_setA3_aString_setC3_EqualsA3_evaluateC3_return_aString(){
		sheet.set("A3", "'a String'");
		sheet.set("C3", "=A3");
		
		assertEquals(sheet.evaluate("C3"), "a String");		
		
	}
	
	@Test
	public void testSpreadsheetequalSignWithCellRefWithwrongInt_setA3_4G_setC3_EqualsA3_evaluateC3_return_Error(){
		sheet.set("A3", "4G");
		sheet.set("C3", "=A3");
		
		assertEquals(sheet.evaluate("C3"), ERROR);		
		
	}
	
	@Test
	public void testSpreadsheetCircularRef_setA1_eqA5_setA5_eqA1_evaluateA5_return_CircularErr(){
		sheet.set("A1", "=A5");
		sheet.set("A5", "=A1");
		
		assertEquals(sheet.evaluate("A5"), "#CIRCULAR");		
		
	}
	
	@Test
	public void testSpreadsheetFormulaCalculation_evaluateAdditionFormula(){
		sheet.set("A1", "=1+1");
		
		assertEquals(sheet.evaluate("A1"), "2");		
		
	}
	
	@Test
	public void testSpreadsheetFormulaCalculation_evaluatesubstractionFormula(){
		sheet.set("A1", "=4-1");
		
		assertEquals(sheet.evaluate("A1"), "3");		
		
	}
	
	@Test
	public void testSpreadsheetFormulaCalculation_evaluateMultiplyFormula(){
		sheet.set("A1", "=4*2");
		
		assertEquals(sheet.evaluate("A1"), "8");		
		
	}

}
