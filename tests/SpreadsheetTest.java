import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	private Spreadsheet s = new Spreadsheet();

	@Test
	public void test_set_and_get() {
		s.set("A1", "1");
		String retrievedValue = s.get("A1");
		assertEquals("1", retrievedValue);
	}

}
