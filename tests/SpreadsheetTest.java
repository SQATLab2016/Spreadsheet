import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test() {
		fail("Not yet implemented");

	}



	@Test
	public void testGet() {
		boolean ok=false;
		Spreadsheet sp= new Spreadsheet();
		sp.set("B13", "Jon");
		if ("Jon"== sp.get("B13")) {
			ok=true;
		}
		assertTrue(ok);

	}
	@Test
	public void testEvaluate() {
		boolean ok=false;
		Spreadsheet sp= new Spreadsheet();
		sp.set("B13", "-234");
		sp.evaluate("B13");
		if (sp.evaluate("B13").equals("true") ) {
			ok=true;
			System.out.println("iep");
		}
		assertTrue(ok);

	}




}
