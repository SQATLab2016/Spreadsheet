import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test_SetAndGet() {
		Spreadsheet n = new Spreadsheet();
		n.set("A1", "2");
		
		assertEquals("Should return 2", "2",  n.get("A1"));
		
	}
	@Test
	public void test_NumberHandlingNegative() {
		Spreadsheet n = new Spreadsheet();
		n.set("A1", "-1");
		
		assertEquals("Evaluation is not correct", "-1", n.evaluate("A1"));
	}
	@Test
	public void test_NumberHandlingPositive() {
		Spreadsheet n = new Spreadsheet();
		n.set("A1", "1");
		
		assertEquals("Evaluation is not correct", "1", n.evaluate("A1"));
	}
	@Test
	public void test_NumberHandlingSigned() {
		Spreadsheet n = new Spreadsheet();
		
		n.set("A1", "1");
		
		assertEquals("Evaluation is not correct", "1", n.evaluate("A1"));
	}

}
