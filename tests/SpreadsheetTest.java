import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class SpreadsheetTest {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void	set1Get1() {
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "1");
		assertEquals("1", "1", sheet.evaluate("A1"));
	}
	
	@Test
	public void	nonExistingCellException() throws IllegalArgumentException {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Cell doesn't exist");
		Spreadsheet sheet = new Spreadsheet();
		sheet.evaluate("A12");
	}
	
	@Test
	public void	set1AGetError() {
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "Error");
		assertEquals("Error", "#Error", sheet.evaluate("A1"));
	}
	
	@Test
	public void	setRandomAndOneApostropheGetError() {
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "124odskjfopd'421421,,,,,'''");
		assertEquals("Error", "#Error", sheet.evaluate("A1"));
	}
	
	@Test
	public void	setStringGetString() {
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "'Text'");
		assertEquals("Text", "Text", sheet.evaluate("A1"));
	}
	
	@Test
	public void	setEqualReturnString() {
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "='Text'");
		assertEquals("Text", "Text", sheet.evaluate("A1"));
	}
	
	@Test
	public void	setEqualReturnErroneusString() {
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "='Text");
		assertEquals("Text", "#Error", sheet.evaluate("A1"));
	}
	
	@Test
	public void	checkCellReference() {
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A5", "99");
		sheet.set("A1", "=A5");
		assertEquals("99", sheet.evaluate("A1"));
	}
	

}

// expectedEx.expect(IllegalArgumentException.class);
// expectedEx.expectMessage("");