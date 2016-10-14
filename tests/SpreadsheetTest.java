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
	@Test
	public void test_IncorrectInteger() {
		Spreadsheet n = new Spreadsheet();
		
		n.set("A1", "5A");
		
		assertEquals("Evaluation is not correct", "#Error", n.evaluate("A1"));
	}
	@Test
	public void test_String() {
		Spreadsheet n = new Spreadsheet();
		
		n.set("A1", "'This is correct'");
		
		assertEquals("Evaluation is not correct", "This is correct", n.evaluate("A1"));
	}
	@Test
	public void test_StringUnquated() {
		Spreadsheet n = new Spreadsheet();
		
		n.set("A1", "'This is incorrect");
		
		assertEquals("Evaluation is not correct", "#Error", n.evaluate("A1"));
	}
	@Test
	public void test_SimpleFormulas() {
		Spreadsheet n = new Spreadsheet();
		
		n.set("A1", "='a string'");
		
		assertEquals("Evaluation is not correct", "a string", n.evaluate("A1"));
	}
	@Test
	public void test_SimpleFormulasError() {
		Spreadsheet n = new Spreadsheet();
		
		n.set("A1", "='a string");
		
		assertEquals("Evaluation is not correct", "#Error", n.evaluate("A1"));
	}
	@Test
	public void test_CellReference() {
		Spreadsheet n = new Spreadsheet();
		
		n.set("A2", "5");
		n.set("A1", "=A2");
		
		assertEquals("Evaluation is not correct", "5", n.evaluate("A1"));
	}
	@Test
	public void test_CellReferenceError() {
		Spreadsheet n = new Spreadsheet();
		
		n.set("A2", "k5");
		n.set("A1", "=A2");
		
		assertEquals("Evaluation is not correct", "#Error", n.evaluate("A1"));
	}
	@Test
	public void test_CircularReference() {
		Spreadsheet n = new Spreadsheet();
		
		n.set("A2", "=A1");
		n.set("A1", "=A2");
		
		assertEquals("Evaluation is not correct", "#Circular", n.evaluate("A1"));
	}
	@Test
	public void test_IntegerOperations() {
		Spreadsheet n = new Spreadsheet();
		
		n.set("A2", "=A1");
		n.set("A1", "=A2");
		
		assertEquals("Evaluation is not correct", "#Circular", n.evaluate("A1"));
	}
	
	
	

}
