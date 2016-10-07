import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	Spreadsheet test = new Spreadsheet();
	@Test
	public void testSpreadsheetAppCreated_NotNull() {
		
		assertNotNull(test);
		
	}
	@Test
	public void testGetOperationDefinition() {
		
		
		assertEquals(null, test.get("A1"));
		
	}
	

}
