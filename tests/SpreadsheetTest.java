import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test_EvaluatePass() {
		Spreadsheet evaluate = new Spreadsheet();
		evaluate.set("A3", "5");
		String result = evaluate.evaluate("A3");
		assertEquals("Contains only numbers", "5", result);
		
		
	}



	@Test
	public void test_set(){
		Spreadsheet set = new Spreadsheet();
		set.set("A3", "5");
		String result = set.get("A3");
		assertEquals("5", result);
	}

	
	}