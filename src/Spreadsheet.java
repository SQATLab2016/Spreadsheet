import java.util.ArrayList;

public class Spreadsheet {
	String[][] sheetMatrix = new String[27][10000];
	char[] alphabet = new char[27];
	
	public Spreadsheet() {
		//for(String[] ar : sheetMatrix)
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
		if(value.charAt(0)=='='){
			if(value.startsWith("='") && value.endsWith("'")) return value.substring(2, value.length()-1);
			else if(value.charAt(1)>='A' && value.charAt(1)<='Z' && value.length()<=6){
				for(int i = 2; i<value.length(); i++){
					if (value.charAt(i)<'0' || value.charAt(i)>'9') return "#Error";
				}
				String currentCell = value.substring(1);
				String nextCellwithEqual = get(currentCell);
				String nextCell = nextCellwithEqual.substring(1);
				if(cell.equals(nextCell)) return "#Circular";
				return evaluate(value.substring(1));
			} else if((value.charAt(1)>='0' && value.charAt(1)<='9') || value.startsWith("= ")) {
				int result = value.charAt(1);
				char operator;
				String[] numbers = value.split("[+-*/%=]");
				for(int i = 1; i<value.length(); i++){
					switch(value.charAt(i)){
					case '+':
						operator = '+';
					case '-':
						operator = '-';
					case '*':
						operator = '*';
					case '/':
						operator = '/';
					case '%':
						operator = '%';
					default:
					}
				}
				
				String res = "" + result;
				return res;
			}
			else return "#Error";
		} else {
			if(value.startsWith("'") && value.endsWith("'")) return value.substring(1, value.length()-1);
			else if((value.charAt(0)<'0' || value.charAt(0)>'9') && value.charAt(0)!='-') return "#Error";
			for(int i = 1; i<value.length(); i++){
				if (value.charAt(i)<'0' || value.charAt(i)>'9')
					return "#Error";
			}
			return sheetMatrix[alphabetNumber(row)][col];
		}
		/*if(value.charAt(0)=='-'){
			value.replace("-","");
			return 0 - Integer.parseInt(value);
		}*/
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
