import java.util.ArrayList;

public class Spreadsheet {
	String[][] sheetMatrix = new String[27][10000];
	char[] alphabet = new char[27];
	
	public Spreadsheet() {
		for(String[] ar : sheetMatrix)
		createAlphabetArray();
	}

	public char[] getAlphabet(){
		return alphabet;
	}
	
	public String get(String cell) {
		char row = cell.charAt(0);
		char col = cell.charAt(1);
		return sheetMatrix[alphabetNumber(row)][col];
	}
	
	public void set(String cell, String value) {
		char row = cell.charAt(0);
		char col = cell.charAt(1);
		sheetMatrix[alphabetNumber(row)][col] = value;
	}
	
	public String evaluate(String cell) {
		char row = cell.charAt(0);
		char col = cell.charAt(1);
		String value =  sheetMatrix[alphabetNumber(row)][col];
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
