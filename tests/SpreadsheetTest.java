import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test_setCellToValueStringA1_1() {
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "1");
		assertEquals("1", sheet.get("A1"));
	}

}
