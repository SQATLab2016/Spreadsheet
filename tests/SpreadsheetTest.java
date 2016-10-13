import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;


public class SpreadsheetTest {
	
	Spreadsheet sheet;
	
	@Before
	public void init() {
		sheet = new Spreadsheet();
	}

	@Test
	public void testCreateCellA1() {
		sheet.set("A1", "1");
		String s = sheet.get("A1");
		assertEquals("1", s);		
	}
	
	@Test
	public void testCreateCellA1_minus1() {
		sheet.set("A1", "-1");
		String s = sheet.evaluate("A1");
		assertEquals("-1", s);		
	}
	
	@Test
	public void testCreateCellA1_5A() {
		sheet.set("A1", "5A");
		String s = sheet.evaluate("A1");
		assertEquals("#Error", s);		
	}
	
	@Test
	public void testCreateCellA1astring() {
		sheet.set("A1", "'a string'");
		String s = sheet.evaluate("A1");
		assertEquals("a string", s);		
	}
	
	@Test
	public void testCreateCellA1astringWithNoEndQuote() {
		sheet.set("A1", "'a string");
		String s = sheet.evaluate("A1");
		assertEquals("#Error", s);	
	}
	
	@Test
	public void testCreateCellA1astringWithNoStartQuote() {
		sheet.set("A1", "a string'");
		String s = sheet.evaluate("A1");
		assertEquals("#Error", s);	
	}
	
	@Test
	public void testCreateCellA1WithSimpleEquationResultingInString() {
		sheet.set("A1", "='a string'");
		String s = sheet.evaluate("A1");
		assertEquals("a string", s);		
	}
	
	@Test
	public void testCreateCellA1WithSimpleEquationStringWithError() {
		sheet.set("A1", "=a string'");
		String s = sheet.evaluate("A1");
		assertEquals("#Error", s);		
	}
	
	@Test
	public void testCreateCellA1WithCellReferenceA5() {
		sheet.set("A5", "3");
		sheet.set("A1", "=A5");
		String s = sheet.evaluate("A1");
		assertEquals("3", s);
	}
	
	@Test
	public void testCreateCellA1WithCellReferenceA5WithErrorInIt() {
		sheet.set("A5", "5A");
		sheet.set("A1", "=A5");
		String s = sheet.evaluate("A1");
		assertEquals("#Error", s);
	}
	
	@Test
	public void testCreateCellA1WithCircularCellReference() {
		sheet.set("A5", "=A1");
		sheet.set("A1", "=A5");
		String s = sheet.evaluate("A1");
		assertEquals("#Circular", s);
	}
	
	@Test
	public void testCreateCellA1WithCircularCellReferences() {
		sheet.set("A5", "=A4");
		sheet.set("A4", "=A3");
		sheet.set("A3", "=A2");
		sheet.set("A2", "=A1");
		sheet.set("A1", "=A5");
		String s = sheet.evaluate("A1");
		assertEquals("#Circular", s);
	}
	
	@Test
	public void testCreateCellA1WithIntegerOperation5Plus1() {
		sheet.set("A1", "=5+1");
		String s = sheet.evaluate("A1");
		assertEquals("6", s);
	}
	
	@Test
	public void testCreateCellA1WithIntegerOperation5Minus1() {
		sheet.set("A1", "=5-1");
		String s = sheet.evaluate("A1");
		assertEquals("4", s);
	}
	
	@Test
	public void testCreateCellA1WithIntegerOperation5Divided1() {
		sheet.set("A1", "=5/1");
		String s = sheet.evaluate("A1");
		assertEquals("5", s);
	}
	
	@Test
	public void testCreateCellA1WithIntegerOperation5Times2() {
		sheet.set("A1", "=5*2");
		String s = sheet.evaluate("A1");
		assertEquals("10", s);
	}
	
	@Test
	public void testCreateCellA1WithIntegerOperation5Modus1() {
		sheet.set("A1", "=5%1");
		String s = sheet.evaluate("A1");
		assertEquals("0", s);
	}
	
	@Test
	public void testCreateCellA1WithIntegerOperation555Plus1() {
		sheet.set("A1", "=555+1");
		String s = sheet.evaluate("A1");
		assertEquals("556", s);
	}
	
	@Test
	public void testCreateCellA1Equals1() {
		sheet.set("A1", "=1");
		String s = sheet.evaluate("A1");
		assertEquals("1", s);
	}

}
