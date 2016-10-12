import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	private Spreadsheet s = new Spreadsheet();

	@Test
	public void test_set_and_get_A1_integer_1() {
		s.set("A1", "1");
		String retrievedValue = s.get("A1");
		assertEquals("1", retrievedValue);
	}

	@Test
	public void test_set_and_get_A1_integer_2() {
		s.set("A1", "2");
		String retrievedValue = s.get("A1");
		assertEquals("2", retrievedValue);
	}

	@Test
	public void test_set_and_evaluate_A1_negative_integer_minus1() {
		s.set("A1", "-1");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("-1", evaluatedValue);
	}

	@Test
	public void test_set_and_evaluate_A1_invalid_integer_5A() {
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

	@Test
	public void test_cell_reference_integer() {
		s.set("A5", "5");
		s.set("A1", "=A5");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("5", evaluatedValue);
	}

	@Test
	public void test_cell_reference_invalid_integer() {
		s.set("A5", "5A");
		s.set("A1", "=A5");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("#Error", evaluatedValue);
	}

	@Test
	public void test_circular_reference() {
		s.set("A5", "=A1");
		s.set("A1", "=A5");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("#Circular", evaluatedValue);
	}

	@Test
	public void test_integer_operation_plus_1() {
		s.set("A1", "=1+1");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("2", evaluatedValue);
	}

	@Test
	public void test_integer_operation_plus_2() {
		s.set("A1", "=1+2");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("3", evaluatedValue);
	}

	@Test
	public void test_integer_operation_plus_minus() {
		s.set("A1", "=5+8-7");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("6", evaluatedValue);
	}

	@Test
	public void test_integer_operation_all_operands() {
		s.set("A1", "=20*2-5+20/5%10");
		String evaluatedValue = s.evaluate("A1");
		assertEquals("1", evaluatedValue);
	}

}
