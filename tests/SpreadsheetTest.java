import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test_setAndGet_1() {
		//Arrange
		Spreadsheet sheet = new Spreadsheet();
		//Act
		sheet.set("A1", "1");
		int num = sheet.get("A1")
		//Assert
		assertEquals(1, num);
	}

}
