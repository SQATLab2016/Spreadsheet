import static org.junit.Assert.*;

import org.junit.Test;

public class SpreadsheetTest {
	Spreadsheet sheet = new Spreadsheet();
	
	@Test
	public void test() {

		Spreadsheet cell1 = new Spreadsheet();
		Spreadsheet cell2 = new Spreadsheet();
		
		
		assertEquals("String: ", "0", cell1.get());
		
		cell1.set("123");
		cell2.set("1");

		assertEquals("String: ", "123", cell1.get());
		
		String add = cell1.addition(cell1.get(), cell2.get());
		assertEquals("String: ", "124", add);
	}
	
	
	
	@Test
	public void testIsInteger_True(){
		assertTrue(sheet.isInteger("55"));
		
	}
	
	
	//@Test
	//public void testIsInteger_A1_False(){
	//	assertTrue(sheet.isInteger("A1"));
	//}

}
