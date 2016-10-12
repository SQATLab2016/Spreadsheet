import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	Spreadsheet sheet = new Spreadsheet();

	@Test
	public void test_assignCell_A1_Calue_1() {
		checkEqualsGet("A1", "1", "1");
	}
	
	@Test
	public void test_evaluateCell_A1() {
		checkEvaluateEqualsError("A1", "1", "1");
	}
	
	@Test
	public void test_assignCell_A2_value_3() {
		checkEqualsGet("A1", "3", "3");
	}
	
	@Test
	public void test_assignCell_A1_value_5_andCell_A2_value_4() {
		String cellOne = "A1";
		String valueOne = "5";
		String cellTwo = "A2";
		String valueTwo = "4";
		sheet.set(cellOne, valueOne);
		sheet.set(cellTwo, valueTwo);
		String valueFromCell = sheet.get(cellTwo);
		assertEquals("4", valueFromCell);
	}
	
	@Test
	public void test_assign_5_cells_with_5_values() {
		String cellOne = "A1";
		String valueOne = "5";
		String cellTwo = "A2";
		String valueTwo = "9";
		String cellThree = "A3";
		String valueThree = "20";
		String cellFour = "B6";
		String valueFour = "10";
		String cellFive = "C4";
		String valueFive = "23";
		sheet.set(cellOne, valueOne);
		sheet.set(cellTwo, valueTwo);
		sheet.set(cellThree, valueThree);
		sheet.set(cellFour, valueFour);
		sheet.set(cellFive, valueFive);
		String valueFromCell = sheet.get(cellThree);
		assertEquals("20", valueFromCell);
	}
	
	@Test
	public void test_assignCell_A1_withString_asd() {;
		checkEvaluateEqualsError("A1", "asd", "#Error");
	}
	
	@Test
	public void test_assignCell_A5_withValueThatHasDecimals() {
		checkEvaluateEqualsError("A5", "5.4", "#Error");
	}

	@Test
	public void test_assignCell_A5_withStringThatHasSingleQuotes() {
		checkEvaluateEqualsError("A5",  "'jee jee'", "jee jee");
	}
	
	@Test
	public void test_assignCell_A10_withStringThatHasOneQuote() {
		checkEvaluateEqualsError("A10",  "'a String", "#Error");
	}
	
	@Test
	public void test_assignCell_A2_withStringThatHasTwoQuotesInWrongPlaces() {
		checkEvaluateEqualsError("A2", "jee'j'ee'asd", "#Error");
		
	}
	
	@Test
	public void test_assignCell_B6_StringThatHasEqualSignInTheBeginningWithQuotes() {
		checkEvaluateEqualsError("B6", "='yyyyyyy'", "a string");
	}
	
	@Test
	public void test_assignCell_B5_StringThatHasEqualSignInTheBeginningWithoutQuotes() {
		checkEvaluateEqualsError("B5", "=text here'", "#Error");
	}
	
	private void checkEqualsGet(String cell, String value, String result){
		sheet.set(cell, value);
		String valueFromCell = sheet.get(cell);
		assertEquals(result, valueFromCell);
	}
	
	private void checkEvaluateEqualsError(String cell, String value, String result) {
		sheet.set(cell, value);
		String evaluateCell = sheet.evaluate(cell);
		assertEquals(result, evaluateCell);
	}


}
