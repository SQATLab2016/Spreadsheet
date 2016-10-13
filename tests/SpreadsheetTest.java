import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testGet() {
		Spreadsheet ss = new Spreadsheet();
		
		ss.set("A3", "3");
		assertEquals("3", ss.get("A3"));
	}
	
	@Test
	public void testGet2() {
		Spreadsheet ss = new Spreadsheet();
		
		ss.set("A3", "3A");
		assertEquals("#Error", ss.get("A3"));
	}
	@Test
	public void testGet3() {
		Spreadsheet ss = new Spreadsheet();
		
		ss.set("A3", "'is a String'");
		assertEquals("is a String", ss.get("A3"));
	}
	
	@Test
	public void testGet4() {
		Spreadsheet ss = new Spreadsheet();
		
		ss.set("A3", "'3A");
		assertEquals("#Error", ss.get("A3"));
	}
	
	@Test
	public void testGet5() {
		Spreadsheet ss = new Spreadsheet();
		
		ss.set("A3", "3A'");
		assertEquals("#Error", ss.get("A3"));
	}
	
	@Test
	public void testGet6() {
		Spreadsheet ss = new Spreadsheet();
		
		ss.set("A3", "='a String'");
		assertEquals("a String",ss.get("A3"));
	}
	
}
