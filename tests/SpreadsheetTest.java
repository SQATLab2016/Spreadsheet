import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	Spreadsheet testsheet = new Spreadsheet();

	
	@Test
	public void testSetValueToCell() {
		
		// Arrange value to cell A1
		testsheet.set("A1", "1");
		
		// Get value from cell A1
		String value = testsheet.get("A1");
		
		// Assert
		assertEquals("Failed to return value from cell", "1", value);
	}
	
	
	@Test
	public void testNumberHandling() {
		
		// Arrange value to cell A1
		testsheet.set("A1", "-1");
		
		// Get value from cell A1
		String value = testsheet.get("A1");
		
		// Assert
		assertEquals("Failed to return negative number from cell", "-1", value);
	}
	
	
	@Test
	public void testErrorOnWrongFormat() {
		// Arrange
		testsheet.set("A1", "5A");
		
		// Get value from cell A1
		String value = testsheet.get("A1");
		
		// Assert
		assertEquals("Failed to return error on wrong format", "#Error", value);
	}
	
}
