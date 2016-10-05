import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	private Spreadsheet s = new Spreadsheet();

	@Test
	public void test_set_and_get_A1_1() {
		s.set("A1", "1");
		String retrievedValue = s.get("A1");
		assertEquals("1", retrievedValue);
	}

	@Test
	public void test_set_and_get_A1_2() {
		s.set("A1", "2");
		String retrievedValue = s.get("A1");
		assertEquals("2", retrievedValue);
	}

	@Test
	public void test_set_and_get_A1_minus1() {
		s.set("A1", "-1");
		String retrievedValue = s.get("A1");
		assertEquals("-1", retrievedValue);
	}

}
