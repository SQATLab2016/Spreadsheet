import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	@Test
	public void spreadsheet_notnull() {
		Spreadsheet ss = new Spreadsheet();
		assertNotNull(ss);
	}

	@Test
	public void spreadsheet_set_a1_1() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "1");
		String result = ss.get("A1");
		assertEquals("1", result);
	}
	@Test
	public void spreadsheet_get_error() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "2");
		assertEquals("errormessage", ss.get("A2"));
	}
	
	@Test
	public void spreadsheet_get_ValueNotFoundError() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "2");
		assertEquals("ValueNotFoundError", ss.evaluate("A2"));
	}
	
	@Test
	public void spreadsheet_evaluate_negative() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "-1");
		assertEquals("-1", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_wronglyFormattedInt() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "5A");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_a1_teststring() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "'teststring'");
		assertEquals("teststring", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_incorrect_string() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "'teststring");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_simple_equals_formula_string() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='teststring'");
		assertEquals("teststring", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_simple_equals_formula_string_error() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='teststring");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_simple_equals_formula_negative_int() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=-5");
		assertEquals("-5", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_simple_equals_formula_int() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=5");
		assertEquals("5", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_equals_error() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_incorrect_cell_reference() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A5", "5");
		ss.set("A1", "=A");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_cell_reference() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A5", "5");
		ss.set("A1", "=A5");
		assertEquals("5", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_multiple_cell_references() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A5", "10");
		ss.set("A1", "=A5");
		ss.set("A2", "=A1");
		assertEquals("10", ss.evaluate("A2"));
	}
	
	@Test
	public void spreadsheet_evaluate_multiple_cell_references_string() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A5", "'test'");
		ss.set("A1", "=A5");
		ss.set("A2", "=A1");
		assertEquals("test", ss.evaluate("A2"));
	}
	
	@Test
	public void spreadsheet_evaluate_circular_error() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=A2");
		ss.set("A2", "=A1");
		assertEquals("#Circular", ss.evaluate("A2"));
	}
	
	@Test
	public void spreadsheet_evaluate_multiple_cell_circular_error() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=A2");
		ss.set("A2", "=A3");
		ss.set("A3", "=A1");
		assertEquals("#Circular", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_integer_operation_plus() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=1+1");
		assertEquals("2", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_math_operation_plus_multiply() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=1+1*2");
		assertEquals("4", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_math_operation_division() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=2/2");
		assertEquals("1", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_math_operation_modulo() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=6%5");
		assertEquals("1", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_math_division_by_zero() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=1/0");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_math_modulo_by_zero() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=1%0");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_cell_reference_math_function() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=1+1");
		ss.set("A2", "=A1");
		assertEquals("2", ss.evaluate("A2"));
	}
	
	@Test
	public void spreadsheet_evaluate_math_operation_plus_incorrect_input() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "=1+1A");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_string_concatenation_one() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='awesome'&'sauce'");
		assertEquals("awesomesauce", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_string_concatenation_two() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='best'&'awesome'&'sauce'");
		assertEquals("bestawesomesauce", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_string_concatenation_three() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='moms'&'best'&'awesome'&'sauce'");
		assertEquals("momsbestawesomesauce", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_string_concatenation_four() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='moms'&'best'&'awesome'&'hot'&'sauce'");
		assertEquals("momsbestawesomehotsauce", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_string_concatenation_no_sign() { // this doesn't even use the concatenation code block.
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='moms''spaghetti'");
		assertEquals("moms", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_string_concatenation_incorrect_sign_placement() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='moms&''spaghetti'");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_string_concatenation_signs_in_strings() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='moms&'&'spaghetti'");
		assertEquals("moms&spaghetti", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_string_concatenation_odd_number_quotes() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='moms'&best'");
		assertEquals("#Error", ss.evaluate("A1"));
	}
}
