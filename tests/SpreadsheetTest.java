import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testCreate() {
		Spreadsheet sp = new Spreadsheet();
		assertNotNull(sp);
	}
	
	@Test
	public void testGet() {
		Spreadsheet sp = new Spreadsheet();
		sp.set("A1", "5");
		String cv = sp.get("A1");
		assertEquals("5", cv);
	}
	
	@Test
	public void testEvaluate_integer() {
		Spreadsheet sp = new Spreadsheet();
		sp.set("A1", "1");
		String cv = sp.evaluate("A1");
		assertEquals("1", cv);
	}
	
	@Test
	public void testEvaluate_quoted_string() {
		Spreadsheet sp = new Spreadsheet();
		sp.set("A1", "’abc’");
		String cv = sp.evaluate("A1");
		assertEquals("abc", cv);
	}
	
	@Test
	public void testEvaluate_incorrect_value() {
		Spreadsheet sp = new Spreadsheet();
		sp.set("A1", "’abc1");
		String cv = sp.evaluate("A1");
		assertEquals("#Error", cv);
	}
	
}
