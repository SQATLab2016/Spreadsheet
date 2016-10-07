import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
    
	Spreadsheet test = new Spreadsheet();
	
	@Test
	public void test1() {
		test.set("A1", "1");
	    assertTrue(test.get("A1").equals("1"));	
	}
	
	@Test
	public void test2() {
		test.set("A2", "-1");
	    assertTrue(test.get("A2").equals("-1"));	
	}
	

}