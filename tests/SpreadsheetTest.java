import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	Spreadsheet ss = new Spreadsheet();

	@Test
	public void test_set_A1_1() {
		ss.set("A1", "1");
		assertEquals("1", ss.get("A1"));
	}

}
