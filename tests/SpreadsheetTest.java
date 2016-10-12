import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void setMethodA1_2_works() {
		Spreadsheet spready = new Spreadsheet();
		
		spready.set("A1", "2");
		assertEquals("2", spready.get("A1"));	
	}
	
	@Test public void spreadsheetEvaluateA2_minus5_returnsminus5() {
		Spreadsheet spready = new Spreadsheet();
		
		spready.set("A2", "-5");
		assertEquals("-5", spready.evaluate("A2"));	
		
	}
	
}

