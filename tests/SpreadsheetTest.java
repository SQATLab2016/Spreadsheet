import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SpreadsheetTest {
	Spreadsheet sheet;
	
	@Before
	public void initilize() {
		sheet = new Spreadsheet();
	}

	@Test
	public void testAssignment_A1_Negative_1() {
		sheet.set("A1", "-1");
		String result = sheet.evaluate("A1");
		assertEquals("-1", result);
	}

	@Test
	public void testAssignment_A1_Postive_1() {
		sheet.set("A1", "1");
		String result = sheet.evaluate("A1");
		assertEquals("1", result);
	}

	@Test
	public void testAssignmentInvalidInteger_Excess_DecimalPoint_Error() {
		sheet.set("A1", "1.");
		String result = sheet.evaluate("A1");
		assertEquals("#Error", result);
	}

	@Test
	public void testAssignmentInvalidInteger_Excess_A_Error() {
		sheet.set("A1", "5A");
		String result = sheet.evaluate("A1");
		assertEquals("#Error", result);
	}

	@Test
	public void testAssignment_A1_ValidString() {
		sheet.set("A1", "'a string'");
		String result = sheet.evaluate("A1");
		assertEquals("a string", result);
	}

	@Test
	public void testAssignment_A1_String_Missing_SingleQuote_Begin_Error() {
		sheet.set("A1", "a string'");
		String result = sheet.evaluate("A1");
		assertEquals("#Error", result);
	}

	@Test
	public void testAssignment_A1_String_Missing_SingleQuote_End_Error() {
		sheet.set("A1", "'a string");
		String result = sheet.evaluate("A1");
		assertEquals("#Error", result);
	}

	@Test
	public void testAssignment_A1_Assign_String() {
		sheet.set("A1", ""='a string'");
		String result = sheet.evaluate("A1");
		assertEquals("a string", result);
	}
}
