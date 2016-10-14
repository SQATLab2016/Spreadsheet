import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testadd_getvalue() {
		
		Spreadsheet S = new Spreadsheet();
		S.set("A1", "3");
		
		assertEquals(3, S.get("A1"));
		
	}

}
