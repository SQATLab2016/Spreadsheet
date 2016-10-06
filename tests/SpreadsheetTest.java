import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void testSetA1With1_GetA1() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A1", "1");
		String value = ss.get("A1");
		assertEquals("1", value);
	}

	@Test
	public void testSetA2With2_GetA2() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A2", "2");
		String value = ss.get("A2");
		assertEquals("2", value);
	}

	@Test
	public void testSetA3WithMinus3_EvaluateA3() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A3", "-3");
		String value = ss.get("A3");
		assertEquals("-3", value);
	}

	@Test
	public void testSetA4WithBadNumber_EvaluateA4() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A4", "4&%");
		String value = ss.evaluate("A4");
		assertEquals("#Error", value);
	}

	@Test
	public void testSetA5WithBadNumber_EvaluateA5() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A5", "foo€%");
		String value = ss.evaluate("A5");
		assertEquals("#Error", value);
	}

	@Test
	public void testSetA6WithString_EvaluateA6() {
		Spreadsheet ss = new Spreadsheet();
		ss.set("A6", "'Elite'");
		String value = ss.evaluate("A6");
		assertEquals("Elite", value);
	}
	
	// To be continued next week, above test is failing as of now.
}
