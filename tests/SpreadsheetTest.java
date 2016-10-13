import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test() {		
		fail("Not yet implemented");
		
	}
	
	@Test
	public void testSetup(){
		Spreadsheet sp = new Spreadsheet();
		
		sp.set("A1", "1");
		assertEquals("1",sp.get("A1"));
	}
	
	@Test
	public void testNumber_handling(){
		Spreadsheet sp = new Spreadsheet();

		sp.set("A1", "-1");
		assertEquals("-1",sp.evaluate("A1"));

	}
	
	@Test
	public void testWrongly_formatted_integers(){
		Spreadsheet sp = new Spreadsheet();
		
		sp.set("B1", "A%");
		assertEquals("#Error",sp.evaluate("B1"));
	}
	
	@Test
	public void testString_handling(){
		Spreadsheet sp = new Spreadsheet();
		
		sp.set("B3", "'a string'");
		assertEquals("a string",sp.evaluate("B3"));
	}
	
	@Test
	public void testUnquoted_strings(){
		Spreadsheet sp = new Spreadsheet();
		
		sp.set("B3", "'a string");
		assertEquals("#Error",sp.evaluate("B3"));
	}
	
	@Test
	public void testSimple_formulas(){
		Spreadsheet sp = new Spreadsheet();
		
		sp.set("B3", "='a string'");
		assertEquals("a string",sp.evaluate("B3"));
	}
	
	@Test
	public void testCell_references(){
		Spreadsheet sp = new Spreadsheet();
		
		sp.set("A1", "=A5");
		assertEquals("#Circular",sp.evaluate("A1"));
	}

}
