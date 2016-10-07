import static org.junit.Assert.*;


import org.junit.Test;


public class SpreadsheetTest {

	Spreadsheet ss = new Spreadsheet();
	
	@Test
	public void spreadsheet_notnull() {
		assertNotNull(ss);
	}

}
