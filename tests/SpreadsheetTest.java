import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	private Spreadsheet test_sheet = new Spreadsheet();
	@Test
	public void test_setCellToValueStringA1_1() {
		
		test_sheet.set("A1", "1");
		assertEquals("1", test_sheet.get("A1"));
	}

	@Test
	public void test_evaluateCorrectlyFormattedCellPositiveInteger() {
		test_sheet.set("A1", "1");
		String result = test_sheet.evaluate("A1");
		assertEquals("1", result);
		
	}
	
	@Test
	public void test_evaluateCorrectlyFormattedCellNegativeInteger() {
		test_sheet.set("A1", "1");
		String result = test_sheet.evaluate("A1");
		assertEquals("1", result);
		
	}
}
