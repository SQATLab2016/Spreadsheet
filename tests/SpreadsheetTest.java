import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	Spreadsheet sheet = new Spreadsheet();

	@Test
	public void test_SetGetIntegerValue1CellA1() {
		setCell("A1", "1");
		String value = getCell("A1");
		assertEquals("1", value);
	}
	
	@Test
	public void test_SetGetIntegerValue2CellA1() {
		setCell("A1", "2");
		String value = getCell("A1");
		assertEquals("2", value);
	}
	
	@Test
	public void test_SetGetIntegerValueMinus1CellA1() {
		setCell("A1", "-1");
		String value = getCell("A1");
		assertEquals("-1", value);
	}
	
	@Test
	public void test_SetEvaluateIntegerValue1CellA1() {
		setCell("A1", "1");
		String value = getCell("A1");
		assertEquals("1", value);
	}
	
	@Test
	public void test_SetEvaluateIntegerValueMinus1CellA1() {
		setCell("A1", "-1");
		String value = evaluateCell("A1");
		assertEquals("-1", value);
	}
	
	@Test
	public void test_SetGetStringValue_teststring_CellA1() {
		setCell("A1", "'teststring'");
		String value = getCell("A1");
		assertEquals("'teststring'", value);
	}
	
	@Test
	public void test_SetEvaluateStringValue_teststring_CellA1() {
		setCell("A1", "'teststring'");
		String value = evaluateCell("A1");
		assertEquals("teststring", value);
	}
	
	@Test
	public void test_SetEvaluateIllegalIntegerValue5ACellA1() {
		setCell("A1", "5A");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetEvaluateIllegalStringValue_teststring_WithoutTrailingQuoteCellA1() {
		setCell("A1", "'teststring");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetGetChangeIntegerValueFirstValue1SecondValue2CellA1() {
		setCell("A1", "1");
		setCell("A1", "2");
		String value = evaluateCell("A1");
		assertEquals("2", value);
	}
	
	@Test
	public void test_SetEvaluateFormulaStringValue() {
		setCell("A1", "='teststring'");
		String value = evaluateCell("A1");
		assertEquals("teststring", value);
	}
	
	@Test
	public void test_SetEvaluateFormulaIntegerValue() {
		setCell("A1", "=1");
		String value = evaluateCell("A1");
		assertEquals("1", value);
	}
	
	@Test
	public void test_SetEvaluateFormulaInvalidStringValueMissingTrailingQuote() {
		setCell("A1", "='teststring");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetEvaluateFormulaInvalidStringValueMissingLeadingQuote() {
		setCell("A1", "=teststring'");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetEvaluateFormulaInvalidIntegerValue() {
		setCell("A1", "=1.2");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetEvaluateCellReferenceA1ReferencesA2StringValue() {
		setCell("A1", "=A2");
		setCell("A2", "'teststring'");
		String value = evaluateCell("A1");
		assertEquals("teststring", value);
	}
	
	@Test
	public void test_SetEvaluateCellReferenceA1ReferencesA2IntegerValue() {
		setCell("A1", "=A2");
		setCell("A2", "3");
		String value = evaluateCell("A1");
		assertEquals("3", value);
	}
	
	@Test
	public void test_SetEvaluateCellReferenceA1ReferencesA2InvalidString() {
		setCell("A1", "=A2");
		setCell("A2", "teststring'");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetEvaluateCellReferenceA1ReferencesA2InvalidInteger() {
		setCell("A1", "=A2");
		setCell("A2", "3.5");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetEvaluateCircularReferenceA1ReferencesA2ReferencesA1() {
		setCell("A1", "=A2");
		setCell("A2", "=A1");
		String value = evaluateCell("A1");
		assertEquals("#Circular", value);
	}
	
	@Test
	public void test_SetEvaluateCircularReferenceA1ReferencesA2ReferencesA3ReferencesA1() {
		setCell("A1", "=A2");
		setCell("A2", "=A3");
		setCell("A3", "=A1");
		String value = evaluateCell("A1");
		assertEquals("#Circular", value);
	}
	
	@Test
	public void test_SetEvaluateIntegerFormulaAddition1Plus1() {
		setCell("A1", "=1+1");
		String value = evaluateCell("A1");
		assertEquals("2", value);
	}
	
	@Test
	public void test_SetEvaluateIntegerFormulaInvalidInteger() {
		setCell("A1", "=1+1A");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetEvaluateIntegerFormulaDivisionByZero() {
		setCell("A1", "=5/0");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetEvaluateStringFormulaValues_teststring_another() {
		setCell("A1", "='teststring'&'another'");
		String value = evaluateCell("A1");
		assertEquals("teststringanother", value);
	}
	
	@Test
	public void test_SetEvaluateStringFormulaValuesInvalidString() {
		setCell("A1", "='teststring'&another'");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetEvaluateIntegerFormulaWithParentheses() {
		setCell("A1", "=2*(1+2)");
		String value = evaluateCell("A1");
		assertEquals("6", value);
	}
	
	private String getCell(String cell) {
		String value = sheet.get(cell);
		return value;
	}

	private void setCell(String cell, String value) {
		sheet.set(cell, value);
	}
	
	private String evaluateCell(String cell) {
		return sheet.evaluate(cell);
	}

}
