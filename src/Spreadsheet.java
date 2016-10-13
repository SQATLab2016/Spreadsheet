
public class Spreadsheet {

	String[][] matrix = new String [26][1000];
	char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	public Spreadsheet(){}

	public Spreadsheet(String[][] matrix, char[] alphabet) {
		super();
		this.matrix = matrix;
		this.alphabet = alphabet;		
	}

	public String[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(String[][] matrix) {
		this.matrix = matrix;
	}

	public char[] getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(char[] alphabet) {
		this.alphabet = alphabet;
	}

	public String get(String cell) {
		// to be implemented
		char letra = cell.charAt(0);
		char num = cell.charAt(1);
		for (int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] == letra){ // You know if its A, B ...

				String value = matrix[i][num];
				
				if(value.startsWith("'") && value.endsWith("'")){
					return value.substring(1, value.length()-1);
				}else if(value.startsWith("'") && value.endsWith("")){
					return "#Error";
				}else if(value.startsWith("") && value.endsWith("'") && !value.startsWith("=")){
					return "#Error";
				}else if(value.startsWith("='") && value.endsWith("'"))
					return value.substring(2, value.length()-1);
				

				try {
					Integer.parseInt(value);
					return value;
				} catch (NumberFormatException nfe){
					return "#Error";
				}
			}

		}
		return null;
	}


	public void set(String cell, String value) {
		// to be implemented

		char letra = cell.charAt(0);
		char num = cell.charAt(1);
		for (int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] == letra){ 
				matrix[i][num] = value;
			}
		}
	}

	public String evaluate(String cell) {
		// to be implemented

		return null;


	}



}
