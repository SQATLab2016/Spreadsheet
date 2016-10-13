import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test() {
		fail("Not yet implemented");
		
	}
	@Test
	public void SetGetIntCell() {
		
		Spreadsheet spread = new Spreadsheet();
		spread.set("A1", "5");
		spread.get(cell);
		
		assertEquals("return value incorrect", "5", cell);
		
	}

}
