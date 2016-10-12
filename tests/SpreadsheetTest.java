import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	Spreadsheet sheet = new Spreadsheet();
	
	@Test
	public void test_getSetValue() {
		sheet.set("A1", "1");
		assertEquals("1", sheet.get("A1"));
	}
	
	@Test
	public void test_evalueSetValue() {
		sheet.set("A1", "-1");
		assertEquals("-1", sheet.evaluate("A1"));
	}

}
