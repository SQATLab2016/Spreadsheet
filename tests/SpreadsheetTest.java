import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class SpreadsheetTest {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void	set1Get1() {
		Spreadsheet sheet = new Spreadsheet();
		sheet.set("A1", "1");
		assertEquals("1", 1, sheet.get("A1"));
	}

}

// expectedEx.expect(IllegalArgumentException.class);
// expectedEx.expectMessage("");