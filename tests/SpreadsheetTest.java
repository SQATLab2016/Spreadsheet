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
	public void moduleTest() {
		Spreadsheet cell3 = new Spreadsheet();
		cell3.set("-125");
		String mod = cell3.module(cell3.get());
		assertEquals("String: ", "125", mod);
	}

	@Test
	public void testIsInteger_True() {
		assertTrue(sheet.isInteger("55"));

	}
	@Test
	public void divisionTest() {

		Spreadsheet cell1 = new Spreadsheet();
		Spreadsheet cell2 = new Spreadsheet();


		cell1.set("44");
		cell2.set("0");


		String div = cell1.division(cell1.get(), cell2.get());
		assertEquals("String: ", "#Error", div);

	}
	@Test
	public void subtractionTest() {

		Spreadsheet cell1 = new Spreadsheet();
		Spreadsheet cell2 = new Spreadsheet();


		cell1.set("44");
		cell2.set("4");


		String sub = cell1.subtraction(cell1.get(), cell2.get());
		assertEquals("String: ", "40", sub);

	}
	
	@Test
	public void multiplicationTest() {

		Spreadsheet cell1 = new Spreadsheet();
		Spreadsheet cell2 = new Spreadsheet();


		cell1.set("4");
		cell2.set("4");


		String mult = cell1.multiplication(cell1.get(), cell2.get());
		assertEquals("String: ", "16", mult);

	}
	@Test
	public void verificationTest(){
		Spreadsheet cell1 = new Spreadsheet();
		Spreadsheet cell2 = new Spreadsheet();

		

		cell1.set("123");
		cell2.set("asds23");
		
		assertEquals("String: ", true, cell1.isNumeric(cell1.get()));
		assertEquals("String: ", false, cell1.isNumeric(cell2.get()));
		
	}

	// @Test
	// public void testIsInteger_A1_False(){
	// assertTrue(sheet.isInteger("A1"));
	// }

}
