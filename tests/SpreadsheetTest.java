import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	Spreadsheet ss = new Spreadsheet();
	
	@Test
	public void spreadsheet_notnull() {
		assertNotNull(ss);
	}

	@Test
	public void spreadsheet_set_a1_1() {
		ss.set("A1", "1");
		
		String result = ss.get("A1");
		
		assertEquals("1", result);
	}
	
	
}
