import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	Spreadsheet test = new Spreadsheet();
	@Test
	public void testSpreadsheetAppCreated_NotNull() {
		
		assertNotNull(test);
		
	}
	@Test
	public void testGetOperationDefinition() {
		
		
		assertEquals(null, test.get("A1"));
		
	}
	@Test
	public void testSetOperation_GetOperation() {
		
		test.set("A1",  "5");
		assertEquals("5", test.evaluate("A1"));
		
	}
	@Test
	public void testReturnInteger() {
		
		test.set("A1",  "-1");
		assertEquals("-1", test.get("A1"));
		
	}
	@Test
	public void testReturnError() {
		
		test.set("A1",  "5A");
		assertEquals("#Error", test.evaluate("A1"));
		
	}
	@Test
	public void testEvaluateString() {
		
		test.set("A1",  "'a string'");
		assertEquals("a string", test.evaluate("A1"));
		
	}
	@Test
	public void testEvaluateString_long() {
		
		test.set("A1",  "'a string so long problems might happen'");
		assertEquals("a string so long problems might happen", test.evaluate("A1"));
		
	}
	@Test
	public void testStringreturnError_noTrailingQuotes() {
		
		test.set("A1",  "'a string");
		assertEquals("#Error", test.evaluate("A1"));
		
	}
	@Test
	public void testEvaluationSpecialSign_String() {
		
		test.set("A1",  "='a string'");
		assertEquals("a string", test.evaluate("A1"));
		
	}
	@Test
	public void testEvaluationSpecialSign_String_Error() {
		
		test.set("A1",  "='a string");
		assertEquals("#Error", test.evaluate("A1"));
		
	}
	@Test
	public void testEvaluation_CellReferences() {
		
		test.set("A5",  "5");
		test.set("A1", "=A5");
		
		
		assertEquals("5", test.evaluate("A1"));
		
	}

}
