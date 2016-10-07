import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	private Spreadsheet sheet = new Spreadsheet();
	@Test
	public void test_setCellToValueStringA1_1() {
		
		sheet.set("A1", "1");
		assertEquals("1", sheet.get("A1"));
	}

	public void test_evaluateCorrectlyFormattedCellInteger() {
		
		
	}
}
