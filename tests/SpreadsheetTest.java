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
	
	@Test public void spreadsheetEvaluateA3_D4_returnsError() {
		Spreadsheet spready = new Spreadsheet();
		
		spready.set("A3", "D4");
		assertEquals("#Error", spready.evaluate("A3"));	
		
	}
	
	@Test public void spreadsheetEvaluateA3_What_returnsWhat() {
		Spreadsheet spready = new Spreadsheet();
		
		spready.set("A3", "'What'");
		assertEquals("What", spready.evaluate("A3"));	
		
	}
	
	@Test public void spreadsheetEvaluateA3_What2_returnsError() {
		Spreadsheet spready = new Spreadsheet();
		
		spready.set("A3", "'What2");
		assertEquals("#Error", spready.evaluate("A3"));	
		
	}
	
	@Test public void spreadsheetEvaluateA3_3What_returnsError() {
		Spreadsheet spready = new Spreadsheet();
		
		spready.set("A3", "3What'");
		assertEquals("#Error", spready.evaluate("A3"));	
		
	}
	
	@Test public void spreadsheetEvaluateA3EgualsArbitary_returnsArbitary() {
		Spreadsheet spready = new Spreadsheet();
		
		spready.set("A3", "='Arbitary'");
		assertEquals("Arbitary", spready.evaluate("A3"));	
		
	}
	
	@Test public void spreadsheetEvaluateA3EgualsElbaWrongFormatEnd_returnsError() {
		Spreadsheet spready = new Spreadsheet();
		
		spready.set("A3", "='Elba");
		assertEquals("#Error", spready.evaluate("A3"));	
		
	}
	
	@Test public void spreadsheetEvaluateA3EgualsElbaWrongFormatStart_returnsError() {
		Spreadsheet spready = new Spreadsheet();
		
		spready.set("A3", "=Elba'");
		assertEquals("#Error", spready.evaluate("A3"));	
		
	}
	
	@Test public void spreadsheetEvaluateA4Equals3_returns3() {
		Spreadsheet spready = new Spreadsheet();
		
		spready.set("A3", "=3");
		assertEquals("3", spready.evaluate("A3"));	
		
	}
}

