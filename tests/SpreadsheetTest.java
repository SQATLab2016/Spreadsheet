import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	Spreadsheet test = new Spreadsheet();
	@Test
	public void testSpreadsheetAppCreated_NotNull() {
		
		assertNotNull(test);
		
	}
	@Test
	pubic void testGetOperationDefinition() {
		
		
		assertEquals(0, test.get(cell));
		
	}
	

}
