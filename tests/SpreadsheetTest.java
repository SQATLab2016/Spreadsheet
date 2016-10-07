import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	@Test
	public void spreadsheet_notnull() {
		Spreadsheet ss = new Spreadsheet();
		assertNotNull(ss);
	}

	@Test
	public void spreadsheet_set_a1_1() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "1");
		String result = ss.get("A1");
		assertEquals("1", result);
	}
	
	@Test
	public void spreadsheet_set_a1_teststring() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "teststring");
		String result = ss.get("A1");
		assertEquals("teststring", result);
	}
	
	@Test
	public void spreadsheet_get_error() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "2");
		assertEquals("errormessage", ss.get("A2"));
	}
	
	
}
