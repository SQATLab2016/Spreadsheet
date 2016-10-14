import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	
	@Test
	public void test_CreateSpreadsheet(){
		
		Spreadsheet sheet = new Spreadsheet();
		
		assertNotNull(sheet);
		
	}
	
	@Test
	public void testGetter() {
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "15");
		
		assertTrue(sheet.get("A1") == "15");
	}

	@Test
	public void testNegativeNumber() {
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A2", "-15");
		
		assertTrue(sheet.evaluate("A2") == "-15");
	}
	@Test
	public void testNonNumeric(){
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A3", "A5");
		
		assertTrue(sheet.evaluate("A3") == "#Error");
	}

	@Test
	public void testString(){
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "'a string'");
		
		assertEquals("a string",sheet.evaluate("A1"));
	}

	@Test
	public void testUnquotedString(){
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "a string");
		
		assertEquals("#Error", sheet.evaluate("A1"));
	}
	
	@Test
	public void testFormulas(){
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "='a string'");
		
		assertEquals("a string", sheet.evaluate("A1"));
	}

}

