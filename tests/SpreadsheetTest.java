import static org.junit.Assert.*;


import org.junit.Test;



public class SpreadsheetTest {
	public static final String ERR_STR="#Error";

/*	@Test
	public void test() {
		fail("Not yet implemented");
		
	}
*/
	Spreadsheet sp= new Spreadsheet();
	
	@Test
	public void test_SetA1_1_Get()
	{
		sp.set("A1", "1");
		
		assertEquals("1",sp.get("A1"));
		
	}
	
	@Test
	public void test_SetA2_minus1_Evaluate()
	{
		sp.set("A2", "-1");
		
		assertEquals("-1",sp.evaluate("A2"));
		
	}
	
	@Test
	public void test_SetA2_5A_Evaluate()
	{
		
		sp.set("A2", "5A");
		
		assertEquals(ERR_STR,sp.evaluate("A2"));
		
	}
	
	@Test
	public void test_A1_quoted_string()
	{
		sp.set("A1", "\"a string\"");
		assertEquals("a string",sp.evaluate("A1"));
	}

	@Test
	public void test_A1_Invalid_quoted_string()
	{
		sp.set("A1", "\"a string");
		assertEquals(ERR_STR,sp.evaluate("A1"));
	}

	@Test
	public void test_A1_evaluate_formula_quoted_string()
	{
		sp.set("A1", "=\"a string\"");
		assertEquals("a string",sp.evaluate("A1"));
	}
	
	@Test
	public void test_A1_evaluate_formula_invalid_quoted_string()
	{
		sp.set("A1", "=\"a string");
		assertEquals(ERR_STR,sp.evaluate("A1"));
		
	}
	
	
	@Test
	public void test_SetA2_formula_Refernce_A5_Evaluate()
	{
		
		sp.set("A2", "=A5");
		sp.set("A5", "5");
		
		assertEquals("5",sp.evaluate("A2"));
		
	}
	@Test
	
	public void test_SetA2_formula_5A_Evaluate()
	{
		
		sp.set("A2", "=5A");
		
		assertEquals(ERR_STR,sp.evaluate("A2"));
		
	}


}
