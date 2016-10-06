import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	Spreadsheet sheet;
	
	@Before
	public void init() {
		sheet = new Spreadsheet();
		sheet.init();
	}

	@Test
	public void testCreateCellA1() {
		sheet.set("A1", "1");
		String s = sheet.get("A1");
		assertEquals("1", s);
				
	}

}
