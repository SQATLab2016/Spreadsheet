import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	Spreadsheet sheet = new Spreadsheet();
	
	@Test
	public void testIsInteger_213214_true(){	
		assertTrue(sheet.isInteger("213214"));
	}
	
	@Test
	public void testIsInteger_A1_false(){	
		assertFalse(sheet.isInteger("A1"));
	}
	
	@Test
	public void testIsCell_231_false(){
		assertFalse(sheet.isCell("231"));
	}
	
	@Test 
	public void testIsCell_A32A_true(){
		assertFalse(sheet.isCell("A32A"));
	}
	
	@Test 
	public void testIsCell_X23_false(){
		assertTrue(sheet.isCell("X23"));
	}
	
	@Test
	public void testIsCellString_a_string(){
		assertFalse(sheet.isCellString("a string"));
	}
	
	@Test
	public void testIsCellString_q_a_string_q(){
		assertTrue(sheet.isCellString("'a string'"));
	}
	
	@Test 
	public void testSet_A2_321(){
		sheet.set("A2", "321");
		
		String value = sheet.get("A2");
		
		assertEquals("321", value);
	}

	@Test
	public void testEvaluate_Integer(){
		sheet.set("A1", "546");
		
		String value = sheet.evaluate("A1");
		
		assertEquals("546", value);
	}
	
	@Test
	public void testEvaluate_String(){
		sheet.set("B2", "'a string'");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("a string", value);
	}
	
	@Test
	public void testEvaluate_Integer_With_Formula(){
		sheet.set("B2", "=12345");
		
		String value = sheet.evaluate("B2");
	}
}
