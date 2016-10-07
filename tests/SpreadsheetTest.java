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
	@Test
	public void testSetOperation_GetOperation() {
		
		test.set("A1",  "5");
		assertEquals("5", test.get("A1"));
		
	}
	@Test
	public void testReturnInteger() {
		
		test.set("A1",  "-1");
		assertEquals("-1", test.get("A1"));
		
	}
	

}
