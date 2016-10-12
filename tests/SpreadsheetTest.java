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
	public void testWronglyFormattedInteger_expectSuccess() throws SpreadsheetException {
		spreadsheet.set("A1", "43_27");
		spreadsheet.set("A2", "437d813++");
		spreadsheet.set("A3", "23.05843570");
		spreadsheet.set("A4", "574f139578490");
		spreadsheet.set("A5", "-4719472819");
		spreadsheet.set("A6", "-99378914327");
		
		assertFalse("Correctly formatted integer is mistaken as incorrectly formatted",
						spreadsheet.evaluate("A6").equals("#Error"));
	}
	
	@Test
	public void evaluateString() throws SpreadsheetException {
		spreadsheet.set("A1", "'a string'");
		
		assertEquals("String not evaluated correctly", "a string", spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void evaluateString_TooManyStrMarks() {
		boolean caughtException = false;
		spreadsheet.set("A1", "'str with ' in the middle'");
		
		try {
			spreadsheet.evaluate("A1");
		} catch (SpreadsheetException e) {
			caughtException = true;
			assertEquals("Caught different exception than expected",
					e.getMessage(), spreadsheet.STR_MARK_IN_THE_MIDDLE_ERROR_MSG);
		}*/
		
		if (!caughtException)
			fail("String mark not found in the middle of a string");
	}
}
