import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test() {
		
		Spreadsheet cell1 = new Spreadsheet();
		String test1 = cell1.get();
		assertEquals("String: ","0",test1);
		
		cell1.set(test1, "123");
		
		String test2 = cell1.get();
		assertEquals("String: ","0",test2);
		
		
		
			
		
	}

}
