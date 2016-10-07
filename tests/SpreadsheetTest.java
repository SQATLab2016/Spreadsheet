import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SpreadsheetTest {

	Spreadsheet spt;
	@Before
	public void setup(){
		spt = new Spreadsheet();
	}
	
	
	// test rule_1
	@Test
	public void Test_set_get_1_1() {
		spt.set("A1", "1");
		assertEquals("1",spt.get("A1"));
	}

	// test rule_2
	@Test
	public void Test_set_evaluate_minus1_minus1(){
		spt.set("A1", "-1");
		assertEquals("-1",spt.evaluate("A1"));
	}
	
	// test rule_3
	@Test
	public void Test_set_evaluate_5A_error(){
		spt.set("A1", "5A");
		assertEquals("#Error",spt.evaluate("A1"));
	}
	
	// test rule_4
	@Test
	public void Test_set_evaluate_astringWithQuotes_astring(){
		spt.set("A1", "'a string'");
		assertEquals("a string",spt.evaluate("A1"));
	}
	
	// test rule_5
	@Test
	public void Test_set_evaluate_astringWithQuote_error(){
		spt.set("A1", "'a string");
		assertEquals("#Error",spt.evaluate("A1"));
	}
	
	// test rule_6
	@Test
	public void Test_set_evaluate_equaltionmark_and_astringWithQuotes_astring(){
		spt.set("A1", "='a string'");
		assertEquals("a string",spt.evaluate("A1"));
	}
	
	// test rule_7
	@Test
	public void Test_set_evaluate_equaltionmark_and_astringWithQuote_error(){
		spt.set("A1", "='a string");
		assertEquals("#Error",spt.evaluate("A1"));
	}
	
	// test rule_8
	@Test
	public void Test_set_evaluate_equaltionmark_and_A5_5_5(){
		spt.set("A1","=A5");
		spt.set("A5","5");
		assertEquals("5",spt.evaluate("A1"));
	}
	
	// test rule_9
	@Test
	public void Test_set_evaluate_equaltionmark_and_A5_5A_error(){
		spt.set("A1","=A5");
		spt.set("A5", "5A");
		assertEquals("#Error",spt.evaluate("A1"));
	}
	
	// test rule_10
	@Test
	public void Test_set_evaluate_equaltionmark_and_A5_A5_circular(){
		spt.set("A1","=A5");
		spt.set("A5","=A1");
		assertEquals("#Circular",spt.evaluate("A1"));
	}
}
