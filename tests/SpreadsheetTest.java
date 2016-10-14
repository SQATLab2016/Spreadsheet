import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	Spreadsheet ss = new Spreadsheet();

	@Test
	public void test_set_A1_1() {
		ss.set("A1", "1");
		assertEquals("1", ss.get("A1"));
	}
	
	@Test
	public void test_set_A1_minus_1() {
		ss.set("A1", "-1");
		assertEquals("-1", ss.evaluate("A1"));
	}
	
	@Test
	public void test_set_5A_returns_error() {
		ss.set("A1", "5A");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void test_set_a_string_evaluates_string() {
		ss.set("A1", "'A string'");
		assertEquals("A string", ss.evaluate("A1"));
	}
	
	@Test
	public void test_set_invalid_string_evaluates_as_error() {
		ss.set("A1", "'A string");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void test_set_equals_to_string_evaluates_as_string() {
		ss.set("A1", "='A string'");
		assertEquals("A string", ss.evaluate("A1"));
	}
	
	@Test
	public void test_set_equals_to_invalid_string_evaluates_as_error() {
		ss.set("A1", "='A string");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void test_reference_from_A5_returns_5() {
		ss.set("A5", "5");
		ss.set("A1", "=A5");
		assertEquals("5", ss.evaluate("A1"));
	}
	
	@Test
	public void test_reference_from_invalid_A5_returns_error() {
		ss.set("A5", "5A");
		ss.set("A1", "=A5");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	

}
