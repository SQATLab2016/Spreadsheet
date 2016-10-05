import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testSpreadSheet_getCellA1AfterSet_1() {
		Spreadsheet oneSheet = new Spreadsheet();
		oneSheet.set("A1", 1);
	}

}
