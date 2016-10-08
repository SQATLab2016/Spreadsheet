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
	
	// test rule_11   String t11 = "=1+1*2"
	@Test
	public void Test_set_evaluate_t11_4(){
		String t11 = "=1+1*2";
		spt.set("A1", t11);
		assertEquals("4",spt.evaluate("A1"));
	}
	
	// test rule_12    string t12 = "=1+1A"
	@Test
	public void Test_set_evaluate_t12_error(){
		String t12 = "=1+1A";
		spt.set("A1", t12);
		assertEquals("#Error",spt.evaluate("A1"));
	}
	
	// test rule_13    string t13 = "='a'&'string'"
	@Test
	public void Test_set_evaluate_t13_astring(){
		String t13 = "='a'&'string'";
		spt.set("A1", t13);
		assertEquals("astring",spt.evaluate("A1"));
	}
	
	// test rule_14    string t14 = "='a&'string'"
	@Test
	public void Test_set_evaluate_t14_error(){
		String t14 = "='a&'string'";
		spt.set("A1", t14);
		assertEquals("#Error",spt.evaluate("A1"));
	}	
	
	// test rule_15    string t15 = "=1+(1*2)"
	@Test
	public void Test_set_evaluate_t15_3(){
		String t15 = "=1+(1*2)";
		spt.set("A1", t15);
		assertEquals("3",spt.evaluate("A1"));
	}	
	
	// test rule_15    string t15 = "=1+(1*2"
	@Test
	public void Test_set_evaluate_t16_3(){
		String t16 = "=1+(1*2";
		spt.set("A1", t16);
		assertEquals("#Error",spt.evaluate("A1"));
	}		
	
	// test rule_15    string t15 = "=1+ (1      *   2    )"
	@Test
	public void Test_set_evaluate_t17_3(){
		String t17 = "=1+ (1      *   2    )";
		spt.set("A1", t17);
		assertEquals("3",spt.evaluate("A1"));
	}		
}
