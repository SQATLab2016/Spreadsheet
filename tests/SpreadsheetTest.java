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
	public void test_set_and_evaluate_A1_minus1() {
		s.set("A1", "-1");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("-1", evaluatedValue);
	}

	@Test
	public void test_set_and_evaluate_A1_5A() {
		s.set("A1", "5A");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("#Error", evaluatedValue);
	}

	@Test
	public void test_set_and_evaluate_A1_a_string() {
		s.set("A1", "'a string'");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("a string", evaluatedValue);
	}

	@Test
	public void test_set_and_evaluate_A1_a_string_without_heading_quote() {
		s.set("A1", "a string'");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("#Error", evaluatedValue);
	}

	@Test
	public void test_set_and_evaluate_A1_a_string_without_trailing_quote() {
		s.set("A1", "'a string");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("#Error", evaluatedValue);
	}

	@Test
	public void test_set_and_evaluate_A1_equals_a_string() {
		s.set("A1", "='a string'");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("a string", evaluatedValue);
	}

	@Test
	public void test_set_and_evaluate_A1_equals_integer() {
		s.set("A1", "=8");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("8", evaluatedValue);
	}

	@Test
	public void test_set_and_evaluate_A1_equals_a_string_without_heading_quote() {
		s.set("A1", "=a string'");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("#Error", evaluatedValue);
	}

	@Test
	public void test_set_and_evaluate_A1_equals_a_string_without_trailing_quote() {
		s.set("A1", "='a string");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("#Error", evaluatedValue);
	}

	@Test
	public void test_set_and_evaluate_A1_equals_invalid_integer() {
		s.set("A1", "=8B");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("#Error", evaluatedValue);
	}

}
