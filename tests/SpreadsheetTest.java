import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest 
{
	Spreadsheet spreadsheet = new Spreadsheet();

	@Test
	public void setA1GetMinusOneIntTest() 
	{
		spreadsheet.set("A1", "-1");
		assertSame("Get result doesn't match to the set value", "-1", spreadsheet.get("A1"));
	}
	
	@Test
	public void setA1EvaluatePlusOneIntTest() 
	{
		spreadsheet.set("A1", "1");
		assertSame("Evaluate result doesn't match to the set value", "1", spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void setA1EvaluateMinusOneIntTest() 
	{
		spreadsheet.set("A1", "-1");
		assertSame("Evaluate result doesn't match to the set value", "-1", spreadsheet.evaluate("A1"));
	}
	
	@Test
	public void setA1EvaluateMinusTwoIntTest() 
	{
		spreadsheet.set("A1", "-2");
		assertSame("Evaluate result doesn't match to the set value", "-2", spreadsheet.evaluate("A1"));
	}

	@Test
	public void setA1EvaluateA5Test() 
	{
		spreadsheet.set("A1", "A5");
		assertSame("Evaluate result doesn't match to the set value", "#Error", spreadsheet.evaluate("A1"));
	}

	@Test
	public void setA1EvaluateCorrectString() 
	{
		spreadsheet.set("A1", "'a string'");
		assertEquals("a string", spreadsheet.evaluate("A1"));
	}

	
}
