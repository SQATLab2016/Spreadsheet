import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void setMethodA1_2_works() {
		Spreadsheet spready = new Spreadsheet();
		
		spready.set("A1", "2");
		assertEquals("2", spready.get("A1"));	
	}

	@Test
	public void spreadsheetEvaluateA2_-5_returns-5() {
		fail("Not yet implemented");
		
	}
	
}
