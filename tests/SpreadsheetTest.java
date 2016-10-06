import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	@Test
	public void test() {
		fail("Not yet implemented");
		
	}
	
	@Test
	public void GetCellValue(){
		Cell Cell = new Cell();
		Cell.value="1";
		assertEquals("","1",Cell.getValue());
	}

}
