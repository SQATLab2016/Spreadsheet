import java.util.ArrayList;

public class Spreadsheet {
	ArrayList<ArrayList> sheetMatrix = new ArrayList(27);
	char[] alphabet = new char[26];
	
	public Spreadsheet() {
		createAlphabetArray();
	}

	public String get(String cell) {
		// to be implemented
		return null;
	}
	
	public void set(String cell, String value) {
		char row = cell.charAt(0);
		char col = cell.charAt(1);
		
	}
	
	public String evaluate(String cell) {
		// to be implemented
		return null;
	}
	
	private void createAlphabetArray(){
           for(char ch = 'a'; ch <= 'z'; ++ch)// fills alphabet array with the alphabet
           {
               alphabet[ch-'a']=ch;
           } 
    }

}
