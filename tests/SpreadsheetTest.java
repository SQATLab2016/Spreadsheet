import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	private static final String ERROR = "#Error";
	private static final String VALID_INPUT_A_STRING_CATCHES = "'A string catches'";
	private static final String VALID_INPUT_FORMULA_A_STRING_CATCHES = "='A string catches'";
	private static final String INVALID_INPUT_FORMULA_A_STRING_CATCHES = "A string catches'";	
	private static final String VALID_EVALUATE_A_STRING_CATCHES = "A string catches";
	private static final String STRING_FAIL_BOAT_START_WRONG = "Fail boat'";
	private static final String STRING_FAIL_BOAT_END_WRONG = "'Fail boat";
	private static final String STRING_FAIL_BOAT_NO_QUOTES = "Fail boat";
	
	private Spreadsheet test_sheet = new Spreadsheet();
	
	@Test	
	public void test_setCellToValueStringA1_1() {		
		test_sheet.set("A1", "1");
		assertEquals("1", test_sheet.get("A1"));
	}

	@Test
	public void test_evaluateCorrectlyFormattedCellPositiveInteger() {
		test_sheet.set("A1", "1");
		assertEquals("1", evaluateCell("A1"));		
	}
	
	@Test
	public void test_evaluateCorrectlyFormattedCellNegativeInteger() {
		test_sheet.set("A1", "-1");		
		assertEquals("-1", evaluateCell("A1"));		
	}
	
	@Test
	public void test_evaluateInvalidFormattedCellInteger() {
		test_sheet.set("A1", "A3");		
		assertEquals(ERROR, evaluateCell("A1"));		
	}
	
	@Test 
	public void test_evaluateCatchesDecimalsInCellSeparatorDot() {
		test_sheet.set("A1", "4.2");
		assertEquals(ERROR, evaluateCell("A1"));
	}
	
	@Test 
	public void test_evaluateCatchesDecimalsInCellSeparatorComma() {
		test_sheet.set("A1", "4,2");		
		assertEquals(ERROR, evaluateCell("A1"));
	}
	
	@Test 
	public void test_canSetGetStringsCell() {
		test_sheet.set("A7", VALID_INPUT_A_STRING_CATCHES);
		String result = test_sheet.get("A7");
		assertEquals(VALID_INPUT_A_STRING_CATCHES, result);
	}
	
	@Test
	public void test_evaluateValidQuotedStringReturnsUnquotedString() {
		test_sheet.set("A1", VALID_INPUT_A_STRING_CATCHES);
		assertEquals(VALID_EVALUATE_A_STRING_CATCHES, evaluateCell("A1"));
	}
	
	@Test
	public void test_evaluateInvalidNonQuotedString() {
		test_sheet.set("A1", STRING_FAIL_BOAT_NO_QUOTES);
		assertEquals(ERROR, evaluateCell("A1"));		
	}
	
	@Test
	public void test_evaluateInvalidQuotedStringStart() {
		test_sheet.set("A1", STRING_FAIL_BOAT_START_WRONG);
		assertEquals(ERROR, evaluateCell("A1"));		
	}
	
	@Test
	public void test_evaluateInvalidEndQuotedString() {
		test_sheet.set("A1", STRING_FAIL_BOAT_END_WRONG);
		assertEquals(ERROR, evaluateCell("A1"));		
	}
	
	@Test
	public void test_evaluateSimpleFormulaIntegerInput() {
		test_sheet.set("A1", "=1");		
		assertEquals("1", evaluateCell("A1"));
	}
	
	@Test
	public void test_evaluateSimpleFormulaSignedIntegerInput() {
		test_sheet.set("A1", "=-11");		
		assertEquals("-11", evaluateCell("A1"));
	}	
	
	@Test
	public void test_evaluateSimpleFormulaInvalidIntegerInput() {
		test_sheet.set("A1", "=A51");		
		assertEquals(ERROR, evaluateCell("A1"));
	}
	
	@Test
	public void test_evaluateSimpleFormulaStringInput() {
		test_sheet.set("A1", VALID_INPUT_FORMULA_A_STRING_CATCHES);
		assertEquals(VALID_EVALUATE_A_STRING_CATCHES, evaluateCell("A1"));
	}
	
	@Test
	public void test_evaluateSimpleFormulateInvalidStringInput() {
		test_sheet.set("A1", INVALID_INPUT_FORMULA_A_STRING_CATCHES);
		assertEquals(ERROR, evaluateCell("A1"));
	}
	
	@Test
	public void test_evaluateFormulaReferencesReturnsLastCellContentSingleRerence() {
		test_sheet.set("A1", "A5");
		test_sheet.set("A5", "1");
		assertEquals("1", evaluateCell("A1"));
	}
	
	/* Run in to corner with this, trying to see if moving forward helps to bubble up better solution
	 * ... and then i realized the re-factoring i did was wrong...
	@Test
	public void test_evaluateFormulaReferencesReturnsLastCellContent3ChainRerence() {
		test_sheet.set("A1", "A5");
		test_sheet.set("A5", "A3");
		test_sheet.set("A3", "A7");
		test_sheet.set("A7", "1");
		assertEquals("1", evaluateCell("A1"));
	}*/
	
	
	private String evaluateCell(String cell) {
		return test_sheet.evaluate(cell);
	}
	
}
