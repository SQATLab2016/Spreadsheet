import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {
	
	Spreadsheet s = new Spreadsheet();

	@Test
	public void test_1() {
		s.set("A1","1");
		String result = s.get("A1");
		assertEquals("1",result);
	}
	
	@Test
	public void test_2() {
		s.set("A1","-1");
		String result = s.evaluate("A1");
		assertEquals("-1",result);
	}
	
	@Test
	public void test_3() {
		s.set("A1","5A");
		String result = s.evaluate("A1");
		assertEquals("#Error",result);
	}
	
	@Test
	public void test_4() {
		s.set("A1","'a string'");
		String result = s.evaluate("A1");
		assertEquals("a string",result);
	}
	
	@Test
	public void test_5() {
		s.set("A1","'a string");
		String result = s.evaluate("A1");
		assertEquals("#Error",result);
	}
	
	@Test
	public void test_6() {
		s.set("A1","='a string'");
		String result = s.evaluate("A1");
		assertEquals("a string",result);
	}
	
	@Test
	public void test_7() {
		s.set("A1","='a string");
		String result = s.evaluate("A1");
		assertEquals("#Error",result);
	}
	
	@Test
	public void test_8() {
		s.set("A5","5");
		s.set("A1","=A5");
		String result = s.evaluate("A1");
		assertEquals("5",result);
	}
	
	@Test
	public void test_9() {
		s.set("A5","5A");
		s.set("A1","=A5");
		String result = s.evaluate("A1");
		assertEquals("#Error",result);
	}
	
	@Test
	public void test_10() {
		s.set("A5","=A1");
		s.set("A1","=A5");
		String result = s.evaluate("A1");
		assertEquals("#Circular",result);
	}
	
	@Test
	public void test_11() {
		s.set("A1","=1+1*2");
		String result = s.evaluate("A1");
		assertEquals("4",result);
	}



}
