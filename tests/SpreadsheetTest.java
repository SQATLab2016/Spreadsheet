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
	public void test_consctuctor_A() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		char[] alphabet = sheet.getAlphabet();
		//Assert
		assertEquals('A', alphabet[1]);
	}

}
