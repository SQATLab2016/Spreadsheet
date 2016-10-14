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
		assertEquals("12345", value);
	}
	
	@Test
	public void testEvaluate_Reference(){
		sheet.set("B2", "=12345");
		sheet.set("B1", "=B2");
		
		String value = sheet.evaluate("B1");
		
		assertEquals("12345", value);
	}
	
	@Test
	public void testEvaluate_Circular(){
		sheet.set("B2", "=B1");
		sheet.set("B1", "=B2");
		
		String value = sheet.evaluate("B1");
		
		assertEquals("#Circular", value);
	}	
	@Test
	public void testEvaluate_MathExpression(){
		sheet.set("A4", "=3+2-1");
		
		String value = sheet.evaluate("A4");
		
		assertEquals("4", value);
	}
	@Test
	public void testEvaluate_MathExpression2(){
		sheet.set("A4", "=10*2+24-1");
		
		String value = sheet.evaluate("A4");
		
		assertEquals("43", value);
	}
	@Test
	public void testEvaluate_MathExpressionParanthesis(){
		sheet.set("A4", "=1+(1*2)");
		
		String value = sheet.evaluate("A4");
		
		assertEquals("3", value);
	}
	@Test
	public void testEvaluate_Whitespaces(){
		sheet.set("A4", "=10 *   2 +      24-1");
		
		String value = sheet.evaluate("A4");
		
		assertEquals("43", value);
	}
	@Test
	public void testEvaluate_WrongInteger(){
		sheet.set("C21", "22A");
		
		String value = sheet.evaluate("C21");
		
		assertEquals("#Error", value);
	}
	@Test
	public void testEvaluate_UnquotedString(){
		sheet.set("C21", "'a string");
		
		String value = sheet.evaluate("C21");
		
		assertEquals("#Error", value);
	}
	@Test
	public void testEvaluate_UnquotedStringInFormula(){
		sheet.set("C21", "='a string");
		
		String value = sheet.evaluate("C21");
		
		assertEquals("#Error", value);
	}
	@Test
	public void testEvaluate_ErrorInReferenceCell(){
		sheet.set("B2", "=B1");
		sheet.set("B1", "5A");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("#Error", value);
	}
	@Test
	public void testEvaluate_ErrorInIntegerFormula(){
		sheet.set("B2", "=1+1A");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("#Error", value);
	}
	@Test
	public void testEvaluate_StringConcat(){
		sheet.set("B2", "='a'&'string'");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("astring", value);
	}
	@Test
	public void testEvaluate_StringConcatError(){
		sheet.set("B2", "='a&'string'");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("#Error", value);
	}
	@Test
	public void testEvaluate_2(){
		sheet.set("B2", "-1");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("-1", value);
	}
	@Test
	public void testEvaluate_3(){
		sheet.set("B2", "5A");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("#Error", value);
	}
	@Test
	public void testEvaluate_4(){
		sheet.set("B2", "'a string'");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("a string", value);
	}
	@Test
	public void testEvaluate_5(){
		sheet.set("B2", "'a string");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("#Error", value);
	}
	@Test
	public void testEvaluate_6(){
		sheet.set("B2", "='a string'");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("a string", value);
	}
	@Test
	public void testEvaluate_7(){
		sheet.set("B2", "='a string");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("#Error", value);
	}
	@Test
	public void testEvaluate_13(){
		sheet.set("B2", "='a'&'string'");
		
		String value = sheet.evaluate("B2");
		
		assertEquals("astring", value);
	}
}
