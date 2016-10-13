import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	Spreadsheet spreadsheet = new Spreadsheet();
	
	@Test public void testSetandGet_1_1() {
		spreadsheet.set("A1", "1");
		String value = spreadsheet.get("A1");
		assertEquals(value,"1");
	}

	@Test public void testNegativeIntegers_minus1_minus1() {
		spreadsheet.set("A1", "-1");
		String value = spreadsheet.evaluate("A1");
		assertEquals(value,"-1");
	}
	
	@Test public void testWronglyFormattedIntegers_5A_Error() {
		spreadsheet.set("A1", "5A");
		String value = spreadsheet.evaluate("A1");
		assertEquals(value,"#Error");
	}
	
	@Test public void testStringHandling_astring_astring() {
		spreadsheet.set("A1", "'a string'");
		String value = spreadsheet.evaluate("A1");
		assertEquals(value,"a string");
	}
	
	@Test public void testUnquotedStrings_astring_error() {
		spreadsheet.set("A1", "'a string");
		String value = spreadsheet.evaluate("A1");
		assertEquals(value,"#Error");
	}
	
	@Test public void testUnquotedStrings2_astring_error() {
		spreadsheet.set("A1", "a string'");
		String value = spreadsheet.evaluate("A1");
		assertEquals(value,"#Error");
	}
	
	@Test public void testEvaluateSimpleFormulas_isEqualaString_aString() {
		spreadsheet.set("A1", "='a string'");
		String value = spreadsheet.evaluate("A1");
		assertEquals(value,"a string");
	}
	
	@Test public void testEvaluate_SimpleFormulasWithErrors_equalaString_error() {
		spreadsheet.set("A1", "='a string");
		String value = spreadsheet.evaluate("A1");
		assertEquals(value,"#Error");
	}
	
	@Test public void testCellReferences_5_5() {
		spreadsheet.set("A1", "5");
		spreadsheet.set("A2", "=A1");
		String value = spreadsheet.evaluate("A2");
		assertEquals(value,"5");
	}
	
	@Test public void testWrongCellReferences_5A_error() {
		spreadsheet.set("A1", "5A");
		spreadsheet.set("A2", "=A1");
		String value = spreadsheet.evaluate("A2");
		assertEquals(value,"#Error");
	}

	@Test public void testDetectCircularReferences_A1_circular() {
		spreadsheet.set("A1", "=A2");
		spreadsheet.set("A2", "=A1");
		String value = spreadsheet.evaluate("A2");
		assertEquals(value,"#Circular");
	}

	@Test public void testIntegerOperations_1plus1multi2_4() {
		spreadsheet.set("A1", "=1+1*2");
		String value = spreadsheet.evaluate("A1");
		assertEquals(value,"4");
	}
	
	@Test public void testErrorsInIntegerOperations_A1_error() {
		spreadsheet.set("A1", "=1+1A");
		String value = spreadsheet.evaluate("A1");
		assertEquals(value,"#Error");
	}
	
	@Test public void testStringOperations_A1_astring() {
		spreadsheet.set("A1", "='a'&'string'");
		String value = spreadsheet.evaluate("A1");
		assertEquals(value,"astring");
	}
	
	@Test public void testErrorsInStringOperations_A1_error() {
		spreadsheet.set("A1", "='a&'string'");
		String value = spreadsheet.evaluate("A1");
		assertEquals(value,"#Error");
	}
	
	
}
