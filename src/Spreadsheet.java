
public class Spreadsheet {
	String[][] spreadsheet = new String[20][20];
	 

	
	public String get(String cell) {
		String[] evaluatedCell = evaluateCell(cell);
		
		
		if(evaluateCell(cell)[0].equals("#ERROR") && evaluateCell(cell)[1].equals("#ERROR")) {
			return "#ERROR";
		}
		
		
		return spreadsheet[assignNumber(evaluatedCell[0])][Integer.parseInt(evaluatedCell[1])];
	}
	
	public void set(String cell, String value) {
		String[] evaluatedCell = evaluateCell(cell);
		spreadsheet[assignNumber(evaluatedCell[0])][Integer.parseInt(evaluatedCell[1])] = value;
	}
	
	/*
	 * evaluates only the cell position, not content, no - exception here 
	 */
	public String[] evaluateCell(String cell) {
		char[] splittedCell = cell.toCharArray();
		StringBuffer stringLetter = new StringBuffer();
		StringBuffer stringNumber = new StringBuffer();
		
		for(char character : splittedCell) {
			if(Character.isLetter(character)) {


				for(char character2 : splittedCell) {
					// only letters before this letter
					if(character2 == character) {
						break;
					}
					if(!Character.isLetter(character)) {
						// number found before this letter
						stringLetter = new StringBuffer("#ERROR");
						stringNumber = new StringBuffer("#ERROR");
					}
				}
				

				stringLetter.append(character);
			} else if(Character.isDigit(character)){
				stringNumber.append(character);
			}
		}
		
		 String[] evaluatedCells = new String[2];
		 evaluatedCells[0] = stringLetter.toString();
		 evaluatedCells[1] = stringNumber.toString();
		return evaluatedCells;
	}
	
	private int assignNumber(String cellLetter) {
		switch(cellLetter.toCharArray()[0]){
		
		case 'A': return 0;
		case 'B': return 1;
		case 'C': return 2;
		case 'D': return 3;
		case 'E': return 4;
		case 'F': return 5;
		case 'G': return 6;
		case 'H': return 7;
		case 'I': return 8;
		case 'J': return 9;
		
		case 'K': return 10;
		case 'L': return 11;
		case 'M': return 12;
		case 'N': return 13;
		case 'O': return 14;
		case 'P': return 15;
		case 'Q': return 16;
		case 'R': return 17;
		case 'S': return 18;
		case 'T': return 19;
		
		default: return -1;
		}
			
	}

	public String evaluate(String cell) {
		if(evaluateInteger(cell)) {
			return get(cell);
		}

		StringBuffer evalutedStringAsBuffer = new StringBuffer(evaluateString(cell));
		if(evalutedStringAsBuffer.charAt(0) == '=') {
			
			if(evalutedStringAsBuffer.charAt(1) == '\'') {
				
			} else {
				StringBuffer cellReferenceInput = new StringBuffer();
				// it is not a Integer only, otherwise it would have returned a value earlier
				cellReferenceInput.append(evalutedStringAsBuffer.subSequence(1, evalutedStringAsBuffer.length()).toString()); // everything after the =
				return get(cellReferenceInput.toString());
			}
		}
		
	
		return evaluateString(cell);
	}
	
	public boolean evaluateInteger(String cell) {
		boolean digitTester = true; //false if cell does not contain only digits
		int dashCounter = 0;
		String cellContent = get(cell);
		/*
		if(get(cell).equals("#ERROR")) {
			return false;
		}
		*/
		
		char[] cellContentCharArray = cellContent.toCharArray();
		
		// test if only digits
		for(int i = 0; i < cellContentCharArray.length; i++) {
			if(!Character.isDigit(cellContentCharArray[i])) {
				if(cellContentCharArray[i] == '-'){ //exclude -1 , -2 
					dashCounter++; 
					digitTester = true;
				} else {
					digitTester = false;
				}
			}
		}
		
		if(digitTester && (dashCounter == 0 || dashCounter == 1) ) { // one or none dash
			return true;
		}
		
		if(!digitTester || dashCounter > 1) {
			return false;
		}
		
		return false;
	}
	
	public String evaluateString(String cell) {

	StringBuffer string = new StringBuffer();
	boolean stringIsRunning = false;
	
		for(int j = 0; j < get(cell).toCharArray().length; j++) {
			
			if(get(cell).toCharArray()[j] == '\'') {
				stringIsRunning = !stringIsRunning;
				j++; // do not append this but the next char
			} 
			
			if(stringIsRunning) {
				string.append(get(cell).toCharArray()[j]);
			}
		}
		
		if(stringIsRunning) {
			// no even amout of swaps, missing some '
			return new String("#Error");
		}
		
		
		return string.toString();
	}
	
}
