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
	public void testAssignment_A1_Neg_1() {
		sheet.set("A1", "-1");
		String result = sheet.evaluate("A1");
		assertEquals("-1", result);
	}

	@Test
	public void testAssignment_A1_Pos_1() {
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

}
