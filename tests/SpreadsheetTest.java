import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	Spreadsheet spreadSheet = new Spreadsheet();

	
	/*
	 * 1
	 */
	
	@Test public void testSpreadsheet_SetA1_1_GetA1_String_1() {
		spreadSheet.set("A1", "1");
		assertEquals("1", spreadSheet.get("A1"));
	}
	
	
	/*
	 * 2
	 */
	
	@Test public void testSpreadsheet_SetA1_1_EvalA1_String_1() {
		spreadSheet.set("A1", "1");
		assertEquals("1", spreadSheet.evaluate("A1"));
	}
	
	
	/*
	 * 3
	 */
	
	@Test public void testSpreadsheet_SetA1_A5_EvalA1_ErrorString() {
		spreadSheet.set("A1", "A5");
		assertEquals("#Error", spreadSheet.evaluate("A1"));
	}
	
	
	/*
	 * 4
	 */
	
	@Test public void testSpreadsheet_SetA1_String_EvalA1_StringWithoutQuotes() {
		spreadSheet.set("A1", "'a string'");
		assertEquals("a string", spreadSheet.evaluate("A1"));
	}
	
	

	/*
	@Test
	public void test() {
		fail("Not yet implemented");
		
	}
	*/

}
