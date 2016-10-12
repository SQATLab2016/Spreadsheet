import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	Spreadsheet spr = new Spreadsheet();
	

	
	@Test public void test_evaluateCell_evaluateA3toA3() {
		
		String a3 = new String("A3"); 
		String[] result = spr.evaluateCell(a3);

		assertEquals("A3", result[0]+result[1]);
	}
	
	@Test public void test_setCell_setCellToA3EqualsYes() {
		spr.set("A3", "yes");
		
		assertEquals("yes", spr.spreadsheet[0][3]);
	}
	
	@Test public void test_getCell_getCellA3EqualsYes() {
		spr.set("A3", "yes");
		
		assertEquals("yes", spr.get("A3"));
	}
	
	@Test public void test_evaluate_evaluate3to3() {
		spr.set("A3", "3");
		
		
		assertEquals("3",spr.evaluate("A3"));
		
	}
	
	@Test public void test_evaluate_evaluateMinu1toMinus1() {
		spr.set("A3", "-1");
		
		
		assertEquals("-1",spr.evaluate("A3"));
		
	}
	
	
	@Test public void test_evaluate_evaluateAStringtoAString() {
		spr.set("A3", "'a string'");
		
		
		assertEquals("a string",spr.evaluate("A3"));
		
	}
	
	
	@Test public void test_evaluate_evaluateWrongFormatAStringtoAString() {
		spr.set("A3", "'a string");
		
		
		assertEquals("#Error",spr.evaluate("A3"));
		
	}
	
	@Test public void test_evaluate_evaluateEqualAStringtoAString() {
		spr.set("A3", "='a string'");
		
		
		assertEquals("a string",spr.evaluate("A3"));
		
	}
	
	@Test public void test_evaluate_evaluateWrongFormatEqualAStringtoAString() {
		spr.set("A3", "='a string");
		
		
		assertEquals("#Error",spr.evaluate("A3"));
		
	}
	
	@Test public void test_evaluate_evaluateWrongFormatCell() {
		spr.set("A3", "='a string");
		
		
		assertEquals("#Error",spr.evaluate("A3"));
		
	}
	
	@Test public void test_evaluate_evaluateWrongFormatCellA() {
		spr.set("A3", "=5A");
		
		
		assertEquals("#Error",spr.evaluate("A3"));
		
	}

	
	

}
