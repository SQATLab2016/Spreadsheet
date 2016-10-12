import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	Spreadsheet sheet = new Spreadsheet();
	
	@Test
	public void test_getSetValue() {
		sheet.set("A1", "1");
		assertEquals("1", sheet.get("A1"));
	}
	
	@Test
	public void test_evaluateSetNegativeValue() {
		sheet.set("A1", "-1");
		assertEquals("-1", sheet.evaluate("A1"));
	}

	@Test
	public void test_wronglyFormattedInteger() {
		sheet.set("A1", "5A");
		assertEquals(Spreadsheet.ERROR_VALUE, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_evaluateStringCell() {
		sheet.set("A1", "'string'");
		assertEquals("string", sheet.evaluate("A1"));
	}
	
	@Test
	public void test_evaluateUnquotedString() {
		sheet.set("A1", "'string");
		assertEquals(Spreadsheet.ERROR_VALUE, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_simpleStringFormula() {
		sheet.set("A1", "='string'");
		assertEquals("string", sheet.evaluate("A1"));
	}
	
	@Test
	public void test_simpleIntegerFormula() {
		sheet.set("A1", "=-2");
		assertEquals("-2", sheet.evaluate("A1"));
	}
	
	@Test
	public void test_simpleStringFormula_withError() {
		sheet.set("A1", "='string");
		assertEquals(Spreadsheet.ERROR_VALUE, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_simpleIntegerFormula_withError() {
		sheet.set("A1", "=5A");
		assertEquals(Spreadsheet.ERROR_VALUE, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_simpleReference() {
		sheet.set("A1", "5");
		sheet.set("A2", "=A1");
		assertEquals("5", sheet.evaluate("A2"));
	}
	
	@Test
	public void test_selfReference() {
		sheet.set("A1", "=A1");
		assertEquals(Spreadsheet.ERROR_CIRCULAR, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_invalidReference() {
		sheet.set("A1", "=A2");
		assertEquals(Spreadsheet.ERROR_VALUE, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_longerInvalidReference() {
		sheet.set("A1", "=A2d");
		assertEquals(Spreadsheet.ERROR_VALUE, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_referenceToCellWithInvalidValue() {
		sheet.set("A5", "5A");
		sheet.set("A1", "A5");
		assertEquals(Spreadsheet.ERROR_VALUE, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_circularReference() {
		sheet.set("A5", "=A1");
		sheet.set("A1", "=A5");
		assertEquals(Spreadsheet.ERROR_CIRCULAR, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_simpleIntegerOperations1() {
		sheet.set("A1", "=1+1*2");
		assertEquals("4", sheet.evaluate("A1"));
	}
	
	@Test
	public void test_simpleIntegerOperations2() {
		sheet.set("A1", "=4-2/2");
		assertEquals("1", sheet.evaluate("A1"));
	}
	
	@Test
	public void test_errorIntegerOperation() {
		sheet.set("A1", "=1+1A");
		assertEquals(Spreadsheet.ERROR_VALUE, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_integerOperation_divideByZero() {
		sheet.set("A1", "=2/0");
		assertEquals(Spreadsheet.ERROR_VALUE, sheet.evaluate("A1"));
	}
	
	@Test
	public void test_stringOperation() {
		sheet.set("A1", "=a&string");
	}
}
