import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class SpreadsheetTest {
	private static final String CIRCULAR_TAG = "#Circular";
	private static final String ERROR_TAG = "#Error";
	Spreadsheet spreadSheet = new Spreadsheet();

	
	/*
	 * 1
	 */
	
	@Test public void testSpreadsheet_SetA1_1_GetA1_String_1() {
		spreadSheet.set("A1", "1");
		assertEquals("1", spreadSheet.get("A1"));
	}
	
	
	/*
	 * 2
	 */
	
	@Test public void testSpreadsheet_SetA1_1_EvalA1_String_1() {
		spreadSheet.set("A1", "1");
		assertEquals("1", spreadSheet.evaluate("A1"));
	}
	
	
	/*
	 * 3
	 */
	
	@Test public void testSpreadsheet_SetA1_A5_EvalA1_ErrorString() {
		spreadSheet.set("A1", "5A");
		assertEquals(ERROR_TAG, spreadSheet.evaluate("A1"));
	}
	
	
	/*
	 * 4
	 */
	
	@Test public void testSpreadsheet_SetA1_String_EvalA1_StringWithoutQuotes() {
		spreadSheet.set("A1", "'a string'");
		assertEquals("a string", spreadSheet.evaluate("A1"));
	}
	
	
	/*
	 * 5
	 */
	
	@Test public void testSpreadsheet_SetA1WrongQuotedString_EvalA1_Error() {
		spreadSheet.set("A1", "'a string");
		assertEquals(ERROR_TAG, spreadSheet.evaluate("A1"));
	}
	
	
	/*
	 * 6
	 */
	
	@Test public void testSpreadSheet_SetA1_EqualSignBeforeString_EvalA1_OnlyString() {
		spreadSheet.set("A1", "='a string'");
		assertEquals("a string", spreadSheet.evaluate("A1"));
	}
	
	
	/*
	 * 7
	 */
	
	@Test public void testSpreadsheet_SetA1_EqualSignAndWrongQuotedString_EvalA1_Error() {
		spreadSheet.set("A1", "='a string");
		assertEquals(ERROR_TAG, spreadSheet.evaluate("A1"));
	}
	
	
	/*
	 * 8
	 */
	
	@Test public void testSpreadSheet_createOneSubEntryWithReference_TypeOfSubEntry_REFERENCE() {
		List<SubEntry> subEntries = spreadSheet.createSubEntries("=A5");
		assertEquals(SubEntryType.REFERENCE, subEntries.get(0).getType());
	}
	
	@Test public void testSpreadSheet_Set_A5_5_And_A1_EqualA5_EvalA1_5() {
		spreadSheet.set("A5", "5");
		spreadSheet.set("A1", "=A5");
		assertEquals("5", spreadSheet.evaluate("A1"));
	}
	
	
	/*
	 * 9
	 */
	
	@Test public void testSpreadSheet_Set_A5_5A_And_A1_EqualA5_EvalA1_Error() {
		spreadSheet.set("A5", "5A");
		spreadSheet.set("A1", "=A5");
		assertEquals(ERROR_TAG, spreadSheet.evaluate("A1"));
	}
	
	
	/*
	 * 10
	 */
	
	@Test public void testSpreadSheet_Set_A5_EqualA1_And_A1_EqualA5_EvalA1_CircularTag() {
		spreadSheet.set("A5", "=A1");
		spreadSheet.set("A1", "=A5");
		assertEquals(CIRCULAR_TAG, spreadSheet.evaluate("A1"));
	}

}
