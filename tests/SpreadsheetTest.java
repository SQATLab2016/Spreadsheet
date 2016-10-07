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
	public void spreadsheet_evaluate_simple_equals_formula() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='teststring'");
		assertEquals("teststring", ss.evaluate("A1"));
	}
	
	@Test
	public void spreadsheet_evaluate_simple_equals_formula_error() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "='teststring");
		assertEquals("#Error", ss.evaluate("A1"));
	}
	
}
