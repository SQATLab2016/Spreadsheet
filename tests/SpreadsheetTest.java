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
		assertEquals(-1, oneSheet.evaluate("A1"));
	}
	
	@Test (expected = SpreadSheetException.class)
	public void testSpreadSheet_evaluateCellWrongFormatedInteger_Exception() {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", "5A");
		oneSheet.evaluate("A1");
	}
}
