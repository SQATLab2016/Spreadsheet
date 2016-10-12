import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testSetA1() throws SpreadsheetException {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "100");	
	}
	
	@Test
	public void testGetA1() throws SpreadsheetException {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "100");
		String x = ss.get("A1");
		assertEquals("Did not find what we were looking for: A1", "100", x);
	}
	
	@Test
	public void testSetMinusNumbers() throws SpreadsheetException {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "-1");
		String x = ss.get("A1");
		assertEquals("Was not able to set -1", "-1", x);
	}
	
	@Test (expected = SpreadsheetException.class)
	public void testSetNonNumber() throws SpreadsheetException {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "a-1d");
		String x = ss.get("A1");
		assertEquals("You were able to put -1d to a number slot", "a-1d", x);
	}

}
