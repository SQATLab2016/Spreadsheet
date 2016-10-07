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
	    assertTrue(test.evaluate("A2").equals("-1"));	
	}
	@Test
	public void test3() {
		test.set("A3", "5A");
	    assertTrue(test.evaluate("A3").equals("#Error"));	
	}
	@Test
	public void test4() {
		test.set("A1", "’a string’");
	    assertTrue(test.evaluate("A1").equals("a string"));	
	}
	@Test
	public void test5() {
		test.set("A1", "’a string");
	    assertTrue(test.evaluate("A1").equals("#Error"));	
	}@Test
	public void test6() {
		test.set("B1", "=’a string");
	    assertTrue(test.evaluate("B1").equals("#Error"));	
	}
	
	

}