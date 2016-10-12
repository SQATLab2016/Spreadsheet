import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	Spreadsheet sheet = new Spreadsheet();

	@Test public void testSetA4_12() {
		String cell = "A4";
		sheet.set(cell, "12");
		assertEquals("12", sheet.get(cell));
	}
	
	@Test public void testSetB12_4() {
		String cell = "B12";
		sheet.set(cell, "4");
		assertEquals("4", sheet.get(cell));
	}
	
	@Test public void evaluateString_StringWithQuotes() {
		String cell = "B12";
		sheet.set(cell, "'thisIsAString'");
		assertEquals("thisIsAString", sheet.evaluate(cell));
	}
	@Test public void evaluateUnquotedString_Error() {
		String cell = "A1";
		sheet.set(cell, "'thisIsNotAString");
		assertEquals("#Error", sheet.evaluate(cell));
	}
	@Test public void evaluateInvalidNumber_Error() {
		String cell = "A1";
		sheet.set(cell, "324as");
		assertEquals("#Error", sheet.evaluate(cell));
	}
	@Test public void evaluateNegativeNumber_minus10() {
		String cell = "F2";
		sheet.set(cell, "-10");
		assertEquals("-10", sheet.evaluate(cell));
	}
	@Test public void evaluateStringEquals_StringWithoutEqual() {
		String cell = "D9";
		sheet.set(cell, "='thisIsAString'");
		assertEquals("thisIsAString", sheet.evaluate(cell));
	}
	@Test public void evaluateNumberEquals_NumberWithoutEqual() {
		String cell = "C5";
		sheet.set(cell, "=-15");
		assertEquals("-15", sheet.evaluate(cell));
	}
	@Test public void evaluateStringEqualsWithError_Error() {
		String cell = "C5";
		sheet.set(cell, "=='thisIsAString");
		assertEquals("#Error", sheet.evaluate(cell));
	}
	@Test public void evaluateRefCell_valueInF2() {
		String cell = "C5";
		sheet.set(cell, "=F2");
		assertEquals(sheet.get("F2"), sheet.evaluate(cell));
	}
	@Test public void evaluateIncorrectRefCell_Error() {
		String cell = "C6";
		sheet.set(cell, "=2F");
		assertEquals("#Error", sheet.evaluate(cell));
	}
	@Test public void evaluateCircularRefCell_Circular() {
		String cell = "F2";
		sheet.set("C5", "=F2");
		sheet.set(cell, "=C5");
		assertEquals("#Circular", sheet.evaluate(cell));
	}
	
	

}
