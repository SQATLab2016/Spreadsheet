import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	Spreadsheet spreadsheet = new Spreadsheet();

	@Test
	public void testSetGet() throws SpreadsheetException {
		spreadsheet.set("A1", "1");
		
		assertEquals("Cell does not return correct value", "1" , spreadsheet.get("A1"));
	}

	@Test
	public void testNegativeEvaluation() throws SpreadsheetException {
		spreadsheet.set("A1", "-1");
		
		assertEquals("Negative cell value evaluated incorrectly", "-1", spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void testWronglyFormattedInteger_expectFail() throws SpreadsheetException {
		spreadsheet.set("A1", "5A");
		
		assertEquals("Wrongly formatted integer not detected", "#Error", spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void testWronglyFormattedInteger_expectSuccess() {
		fail("not implemented yet");
	}
}
