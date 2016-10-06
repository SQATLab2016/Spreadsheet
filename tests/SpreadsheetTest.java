import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	Spreadsheet sheet = new Spreadsheet();

	@Test
	public void test_SetGetIntegerValue1CellA1() {
		setCellValue("A1", "1");
		String value = getCell("A1");
		assertEquals("1", value);
	}
	
	@Test
	public void test_SetGetIntegerValue2CellA1() {
		setCellValue("A1", "2");
		String value = getCell("A1");
		assertEquals("2", value);
	}
	
	@Test
	public void test_SetGetIntegerValueMinus1CellA1() {
		setCellValue("A1", "-1");
		String value = getCell("A1");
		assertEquals("-1", value);
	}
	
	@Test
	public void test_SetEvaluateIntegerValue1CellA1() {
		setCellValue("A1", "1");
		String value = getCell("A1");
		assertEquals("1", value);
	}
	
	@Test
	public void test_SetEvaluateIntegerValueMinus1CellA1() {
		setCellValue("A1", "-1");
		String value = evaluateCell("A1");
		assertEquals("-1", value);
	}
	
	@Test
	public void test_SetGetStringValue_teststring_CellA1() {
		setCellValue("A1", "'teststring'");
		String value = getCell("A1");
		assertEquals("'teststring'", value);
	}
	
	@Test
	public void test_SetEvaluateStringValue_teststring_CellA1() {
		setCellValue("A1", "'teststring'");
		String value = evaluateCell("A1");
		assertEquals("teststring", value);
	}
	
	@Test
	public void test_SetEvaluateIllegalIntegerValue5ACellA1() {
		setCellValue("A1", "5A");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetEvaluateIllegalStringValue_teststring_WithoutTrailingQuoteCellA1() {
		setCellValue("A1", "'teststring");
		String value = evaluateCell("A1");
		assertEquals("#Error", value);
	}
	
	@Test
	public void test_SetGetChangeIntegerValueFirstValue1SecondValue2CellA1() {
		setCellValue("A1", "1");
		setCellValue("A1", "2");
		String value = evaluateCell("A1");
		assertEquals("2", value);
	}
	
	@Test
	public void test_SetEvaluateFormula() {
		fail("Not implemented");
	}
	
	private String getCell(String cell) {
		String value = sheet.get(cell);
		return value;
	}

	private void setCellValue(String cell, String value) {
		sheet.set(cell, value);
	}
	
	private String evaluateCell(String cell) {
		return sheet.evaluate(cell);
	}

}
