import static org.junit.Assert.*;

import org.junit.Test;

public class SpreadsheetTest {

	@Test
	public void testSpreadSheet_getCellA1AfterSet_1() {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "1");
		assertEquals("1", oneSheet.get("A1"));
	}

	@Test
	public void testSpreadSheet_getCellA1AfterSet_negative1() {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "-1");
		assertEquals("-1", oneSheet.get("A1"));
	}
	
	@Test
	public void testSpreadSheet_evaluateCell_negative1() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "-1");
		assertEquals("-1", oneSheet.evaluate("A1"));
	}
	
	@Test (expected = SpreadSheetException.class)
	public void testSpreadSheet_evaluateCellWrongFormatedInteger_Exception() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "5A");
		oneSheet.evaluate("A1");
	}
	
	@Test
	public void testSpreadSheet_evaluateCellHandlingString() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "'a string'");
		assertEquals("a string", oneSheet.evaluate("A1"));
	}
	
	@Test (expected = SpreadSheetException.class)
	public void testSpreadSheet_evaluateCellHandlingString_Exception() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "'a string");
		oneSheet.evaluate("A1");
	}
	
	@Test
	public void testSpreadSheet_evaluateSimpleFormula() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "='a string'");
		assertEquals("a string", oneSheet.evaluate("A1"));
	}
	
	@Test (expected = SpreadSheetException.class)
	public void testSpreadSheet_evaluateSimpleFormula_Exception() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "='a string");
		oneSheet.evaluate("A1");
	}
	
	@Test
	public void testSpreadSheet_evaluateCellReference() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A5", "4");
		oneSheet.set("A1", "=A5");
		assertEquals("4", oneSheet.evaluate("A1"));
	}
	
	@Test (expected = SpreadSheetException.class)
	public void testSpreadSheet_evaluateCellReference_Exception() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A5", "5A");
		oneSheet.set("A1", "=A5");
		oneSheet.evaluate("A1");
	}
	
	@Test (expected = SpreadSheetException.class)
	public void testSpreadSheet_evaluateCellReferenceCircular_Exception() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A5", "=A1");
		oneSheet.set("A1", "=A5");
		oneSheet.evaluate("A1");
	}
	
	@Test
	public void testSpreadSheet_evaluateArithmeticOperations() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "=1*1+2");
		assertEquals("3", oneSheet.evaluate("A1"));
	}
	
	@Test (expected = SpreadSheetException.class)
	public void testSpreadSheet_evaluateArithmaticOperation_Exception() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "=1*1A");
		oneSheet.evaluate("A1");
	}
	
	@Test
	public void testSpreadSheet_evaluateStringOperations() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "='a'&'string'");
		assertEquals("astring", oneSheet.evaluate("A1"));
	}
	
	@Test (expected = SpreadSheetException.class)
	public void testSpreadSheet_evaluateStringOperations_Exception() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "='a&'string'");
		oneSheet.evaluate("A1");
	}
	
	@Test
	public void testSpreadSheet_evaluateWithSpaces() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "=1+  2");
		assertEquals("3", oneSheet.evaluate("A1"));
	}
	
	@Test
	public void testSpreadSheet_evaluateWithParantheses() throws SpreadSheetException {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "=1+(2*2)");
		assertEquals("5", oneSheet.evaluate("A1"));
	}
}
