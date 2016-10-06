import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;


public class SpreadsheetTest {
	
	Spreadsheet sheet;
	
	@Before
	public void init() {
		sheet = new Spreadsheet();
	}

	@Test
	public void testCreateCellA1() {
		sheet.set("A1", "1");
		String s = sheet.get("A1");
		assertEquals("1", s);
				
	}
	
	@Test
	public void testCreateCellA1_minus1() {
		sheet.set("A1", "-1");
		String s = sheet.evaluate("A1");
		assertEquals("-1", s);
				
	}
	
	@Test
	public void testCreateCellA1_5A() {
		sheet.set("A1", "5A");
		String s = sheet.evaluate("A1");
		assertEquals("#Error", s);
				
	}

}
