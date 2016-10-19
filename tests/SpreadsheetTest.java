import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SpreadsheetTest {
	Spreadsheet shiaat;
	@Before
	public void initialization() {
		shiaat = new Spreadsheet();
	}

	
	@Test
	public void test_setGetFunctionInteger() {
		shiaat.set("A1", "45");
		assertEquals(45, shiaat.evaluate("A1"));
	}
	
	@Test
	public void test_setGetFunctionIntegerNegative() {
		shiaat.set("A1", "-45");
		assertEquals(-45, shiaat.evaluate("A1"));
	}
	
	@Test
	public void test_setGetFunctionIntegerBad() {
		shiaat.set("A1", "45A");
		assertEquals("#Error", shiaat.evaluate("A1"));
	}
	
	@Test
	public void test_setGetFunctionString() {
		shiaat.set("A1", "'45A'");
		assertEquals("45A", shiaat.evaluate("A1"));
	}
	
	@Test
	public void test_setGetFunctionInvalidString1() {
		shiaat.set("A1", "'45A");
		assertEquals("#Error", shiaat.evaluate("A1"));
	}

	@Test
	public void test_setGetFunctionInvalidString2() {
		shiaat.set("A1", "45A'");
		assertEquals("#Error", shiaat.evaluate("A1"));
	}
	
	@Test
	public void test_setGetFunctionIntegerFormula() {
		shiaat.set("A1", "=45");
		assertEquals(45, shiaat.evaluate("A1"));
	}
	
	@Test
	public void test_setGetFunctionStringFormula() {
		shiaat.set("A1", "='45A'");
		assertEquals("45A", shiaat.evaluate("A1"));
	}
	
	@Test
	public void test_setGetFunctionStringFormulaBroken1() {
		shiaat.set("A1", "=45A'");
		assertEquals("#Error", shiaat.evaluate("A1"));
	}
	
	@Test
	public void test_setGetFunctionStringFormulaBroken2() {
		shiaat.set("A1", "='45A");
		assertEquals("#Error", shiaat.evaluate("A1"));
	}
	
	@Test
	public void test_setGetFunctionReference() {
		shiaat.set("A1", "'Yo'");
		shiaat.set("A2", "=A1");
		assertEquals("Yo", shiaat.evaluate("A2"));
	}
}
