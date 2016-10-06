import java.util.ArrayList;

public class Spreadsheet {
	ArrayList<ArrayList<String>> sheetMatrix = new ArrayList(27);
	char[] alphabet = new char[27];
	
	public Spreadsheet() {
		createAlphabetArray();
	}

	public char[] getAlphabet(){
		return alphabet;
	}
	
	public String get(String cell) {
		// to be implemented
		return null;
	}
	
	public void set(String cell, String value) {
		char row = cell.charAt(0);
		char col = cell.charAt(1);
		sheetMatrix.get(alphabetNumber(row)).add(col, value);
	}
	
	public String evaluate(String cell) {
		char row = cell.charAt(0);
		char col = cell.charAt(1);
		return sheetMatrix.get(alphabetNumber(row)).get(col);
		
	}
	
	private void createAlphabetArray(){
           for(char ch = 'A'; ch <= 'Z'; ++ch)// fills alphabet array with the alphabet
           {
               alphabet[ch-'A'+1]=ch;
           } 
    }
	
	private int alphabetNumber(char c){
		for(int i = 1; i<27; i++)
        {
			if(alphabet[i]==c)
				return i;
        } 
		return -1;
	}

}
