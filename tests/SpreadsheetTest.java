import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test_setAndGet_1() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "1");
		String result = sheet.get("A1");
		//Assert
		assertEquals("1", result);
	}
	
	@Test
	public void test_setAndGet_minus1() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "-1");
		String result = sheet.get("A1");
		//Assert
		assertEquals("-1", result);
	}
	
	@Test
	public void test_evaluate_minus1() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "-1");
		String result = sheet.evaluate("A1");
		//Assert
		assertEquals("-1", result);
	}
	
	@Test
	public void test_evaluate_5A_Error() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "5A");
		String result = sheet.evaluate("A1");
		//Assert
		assertEquals("#Error", result);
	}
	
	@Test
	public void test_evaluate_aString() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "'a string'");
		String result = sheet.evaluate("A1");
		//Assert
		assertEquals("a string", result);
	}
	
	@Test
	public void test_evaluate_withEqual_aString() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "='a string'");
		String result = sheet.evaluate("A1");
		//Assert
		assertEquals("a string", result);
	}
	
	@Test
	public void test_evaluate_withEqual_Error() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "='a string");
		String result = sheet.evaluate("A1");
		//Assert
		assertEquals("#Error", result);
	}
	
	
	@Test
	public void test_evaluate_A1toE5_5() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "=E5");
		sheet.set("E5", "='a string");
		String result = sheet.evaluate("A1");
		//Assert
		assertEquals("#Error", result);
	}
	
	@Test
	public void test_evaluate_A1toE5toA1_Circular() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "=E5");
		sheet.set("E5", "=A1");
		String result = sheet.evaluate("A1");
		//Assert
		assertEquals("#Circular", result);
	}
	
	@Test
	public void test_evaluate_A1toE5_Error() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "=E5");
		sheet.set("E5", "5");
		String result = sheet.evaluate("A1");
		//Assert
		assertEquals("5", result);
	}
	
	@Test
	public void test_evaluate_operation_12() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "=3+3*2");
		String result = sheet.evaluate("A1");
		//Assert
		assertEquals("12", result);
	}
	
	@Test
	public void test_evaluat_onlyOneQuote_Error() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "'a string");
		String result = sheet.evaluate("A1");
		//Assert
		assertEquals("#Error", result);
	}
	
	@Test
	public void test_consctuctor_A() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		char[] alphabet = sheet.getAlphabet();
		//Assert
		assertEquals('A', alphabet[1]);
	}
	
	@Test
	public void test_consctuctor_Z() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		char[] alphabet = sheet.getAlphabet();
		//Assert
		assertEquals('Z', alphabet[26]);
	}

}
