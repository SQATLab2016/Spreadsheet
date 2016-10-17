import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	Spreadsheet sheet = new Spreadsheet();

	@Test
	public void SpreadsheetTest_assign_get_val() {
		sheet.set("A1", "-1");
		String val = sheet.get("A1");
		assertEquals("-1", val);
	}
	
	@Test
	public void SpreadsheetTest_assign_get_wrong_format_int() {
		sheet.set("A1", "5A");
		String val = sheet.get("A1");
		assertEquals("#Error", val);
	}
	
	@Test
	public void SpreadsheetTest_assign_get_valid_string() {
		sheet.set("A1", "'a string'");
		String val = sheet.get("A1");
		assertEquals("a string", val);
	}
	
	@Test
	public void SpreadsheetTest_assign_get_invalid_string() {
		sheet.set("A1", "'a string");
		String val = sheet.get("A1");
		assertEquals("#Error", val);
	}
	
	@Test
	public void SpreadsheetTest_assign_formula_get_valid_string() {
		sheet.set("A1", "='a string'");
		String val = sheet.get("A1");
		assertEquals("a string", val);
	}
	
	@Test
	public void SpreadsheetTest_assign_formula_get_invalid_string() {
		sheet.set("A1", "='a string");
		String val = sheet.get("A1");
		assertEquals("#Error", val);
	}
	
	@Test
	public void SpreadsheetTest_assign_formula_get_valid_reference() {
		sheet.set("A1", "='a string'");
		sheet.set("A2", "=A1");
		String val = sheet.get("A2");
		assertEquals("a string", val);
	}
	
	@Test
	public void SpreadsheetTest_assign_int_ref_get() {
		sheet.set("A1", "5");
		sheet.set("A2", "=A1");
		String val = sheet.get("A2");
		assertEquals("5", val);
	}
	
	@Test
	public void SpreadsheetTest_assign_circular_reference_get() {
		sheet.set("A1", "=A2");
		sheet.set("A2", "=A1");
		String val = sheet.get("A1");
		assertEquals("#Circular", val);
	}
	
	@Test
	public void SpreadsheetTest_invalid_calculation() {
		sheet.set("A1", "10");
		sheet.set("A2", "5");
		sheet.set("A3", "asdf");
		sheet.set("A4", "A1+A2+A3");
		String val = sheet.get("A4");
		assertEquals("#Error", val);
	}
	
	@Test
	public void SpreadsheetTest_valid_calculation() {
		sheet.set("A1", "10");
		sheet.set("A2", "5");
		sheet.set("A3", "4");
		sheet.set("A4", "=A1+A2+A3");
		String val = sheet.get("A4");
		assertEquals("19", val);
	}
	
	@Test
	public void SpreadsheetTest_valid_calculation_with_ref() {
		sheet.set("A1", "10");
		sheet.set("A2", "5");
		sheet.set("A3", "=A1");
		sheet.set("A4", "=A1+A2+A3");
		String val = sheet.get("A4");
		assertEquals("25", val);
	}

}
