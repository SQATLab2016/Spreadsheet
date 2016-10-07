import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
    
	Spreadsheet test = new Spreadsheet();
	@Test
	public void test() {
		test.set("A1", "1");
	    assertTrue(test.get("A1").equals(1));	
	}

}