

import java.util.*;


// Spaghetti code, exhibit A.
public class Spreadsheet {

	// member variables
	// TODO: this needs to be cleared on every "new" evaluation.
	private List<String> lastCellNames = new ArrayList<String>();
	
	// flags for doing math.
	boolean sumNext = false;
	boolean subtractNext = false;
	boolean multiplyNext = false;
	boolean divideNext = false;
	boolean moduloNext = false;
	
	// dictionary of cells and values.
	// cell => key
	// value => value
	// --> <cell's name, it's value>
	private Map <String, String> map = new HashMap<String, String>();
	
	public String get(String cell) {
		if(map.containsKey(cell)) {
			return map.get(cell);
		}
		return "errormessage";
	}
	
	public void set(String cell, String value) {
		map.put(cell, value);
	}
	
	public String evaluate(String cell) {
		
		// cell's value in a string format.
		String value = "";
		
		// cell's value in a character array format.
		char[] c;
		
		// flags for input types etc.
		boolean isNegative = false;
		boolean isString = false;
		boolean containsEquals = false;
		boolean usedMathFunctions = false;
		
		// Get the value of the cell.
		// or if not found return error.
		if(map.containsKey(cell)) {
			value = map.get(cell);
		} else {
			return "ValueNotFoundError";
		}
		
		// convert string to character array.
		c = value.toCharArray();
		
		// this is a counter that counts digits in the value.
		// TODO: this is really botched. Oh dear god (v_v)
		int digitCount = 0;
		
		// this is the result if there are math functions in the cell.
		int calculatedResult = 0;
		
		// For cutting the string to substring.
		// Used to manipulate the value string in the return statements.
		// TODO: start & end positions are smelly.
		int startPos = 0;
		int endPos = 0;
		
		// Loop through the value.
		// TODO:
		// 1. Maybe create sub-methods to clean "main" for-loop.
		for(int i = 0; i < c.length; i++) {
		
			// SPECIAL CASES BEGIN:
			
			// if whole value is a string.
			if(c[0] == '\'' && c[c.length - 1] == '\'') {
				isString = true;
				break;
			}
			
			// if the first character is negative (-).
			// only used when there are no equals sign.
			if(c[i] == '-' && i == 0) {
				isNegative = true;
				continue;
			}
						
			// SPECIAL CASES END.
			
			// If there is an equals character.
			if(c[i] == '=') {
				
				// if there is nothing else than an equals sign.
				// TODO: refactor, unused variable.
				// -> wrap this around the rest of this block 
				// -> or use myChar instead of c[i+1]
				try {
					char myChar = c[i + 1];
				} catch (ArrayIndexOutOfBoundsException e) {
					return "#Error";
				}
				
				containsEquals = true;
				
				// next character is negative sign.
				if(c[i+1] == '-') {
					startPos = i+1;
					isNegative = true;
					continue;
					
				// next character is opening single quote.
				// -> there might be multiple concatenations or none.
				} else if (c[i+1] == '\'') {
					
					int concatenationCount = 0;
					
					// Every other is starting point.
					// Example: if there are 2 concatenations there should be three strings
					// and therefore three different starting and ending points.
					List<Integer> startingAndEndingPoints = new ArrayList<Integer>();	
					
					// Check if there are string concatenations.
					for(int k = 0; k < c.length; k++) {
						if(c[k] == '&') {
							concatenationCount ++;
						}
					}
					
					// This if is here because we want to avoid breaking the code at this point.
					// If there is no concatenations it means that it's just a single string.
					// TODO: refactor this.
					if(concatenationCount == 0) {
						boolean hasClosingQuote = false;
						startPos = i+2;
						
						// Loop through the remaining characters until closing quote is found or end of c.
						for(int j = i+2; j < c.length; j++) {
							
							if(c[j] == '\'') {
								hasClosingQuote = true;
								endPos = j;
								break;
							}
						}
						
						// Return value if the closing quote is found.
						if(hasClosingQuote) {
							return value.substring(startPos, endPos);
						} else {
							return "#Error";
						}
					} else {
						
						// if there are two single quotes next to each other
						// -> there should be '&' sign between them
						// --> return error.
						for(int j = 0; j < c.length - 1; j++) {
							if(c[j] == '\'') {
								if(c[j+1] == '\'') return "#Error";
							}
						}
						
						// This is the first character in the string after opening single quote. 
						startingAndEndingPoints.add(i+2);
						
						boolean newString = false;
						String resultString = "";
						
						// Loop through the whole value of the cell and 
						// mark starting and ending points for each string.
						for(int j = i+2; j < c.length; j++) {
							
							if(c[j] == '&') {
								
								// If there are odd number of quotes,
								// -> means that this sign is inside a string.
								// --> we want to jump over it.
								// ---> it's not a new String yet.
								if(startingAndEndingPoints.size() % 2 != 0) continue;
								
								newString = true;
								continue;
							}
							
							if(c[j] == '\'') {
								if(newString) {
									startingAndEndingPoints.add(j + 1);
									newString = false;
								} else {
									startingAndEndingPoints.add(j);
								}
							}
						}
						
						// There should always be even number of points.
						if(startingAndEndingPoints.size() % 2 != 0) return "#Error";
						
						// create a string from substrings.
						for(int k = 0; k < startingAndEndingPoints.size(); k++) {
						
							// Only loop every second point, because we only want the start points.
							// -> because the end point is the next point after the start point.
							if(k % 2 != 0) continue;
							
							int startPoint = startingAndEndingPoints.get(k);  
							int endPoint = startingAndEndingPoints.get(k+1);
							
							resultString += value.substring(startPoint, endPoint);
						}
						
						return resultString;
					}
				
				// Next character is a digit.
				// This means that there are probably going to be some math functions
				// so we can put the value to calculatedResult just in case.
				} else if(Character.isDigit(c[i+1])) {
					calculatedResult = (c[i+1] - '0');
					startPos = i+1;
					continue;
					
				// Next character is a letter.
				// -> cell reference
				// TODO: this might not mean it's a cell reference!
				// Should we check if the letter is also upper case?
				} else if(Character.isLetter(c[i+1])) { 
					
					// Hard coded to take only TWO next characters as 
					// cell reference. If there are not two then return error.
					
					// TODO: for loop so long that there is either space or 
					// some special character like +, -, /, %, etc.
					
					char scnd = c[i+1];
					char thrd = ' ';
					
					// check if there is third character.
					// example: "=A5" 
					// --> 1. '='
					// --> 2. 'A'
					// --> 3. '5'
					try {
						thrd = c[i+2];
					} catch (ArrayIndexOutOfBoundsException e) {
						return "#Error";
					}
					
					// create our cell name as a string.
					// -> "=A5"
					// --> cellName == A5
					String cellName = "" + scnd + thrd;
					
					// If the last cell's name is the same as the target of this next cell.
					// -> circulating.
					if(lastCellNames.contains(cellName)) {
						return "#Circular";
					}
					
					// Set the lastCellName to the cell that we evaluated.
					lastCellNames.add(cell);
					
					return this.evaluate(cellName);
					
				} else {
					// in other case just return error.
					return "#Error";
				}
			}
			
			// Check for math functions
			// if one is found then flip it's flag to true.
			switch(c[i]) {
			case '+':
				sumNext = true;
				usedMathFunctions = true;
				break;
			
			case '-':
				subtractNext = true;
				usedMathFunctions = true;
				break;
			
			case '/':
				divideNext = true;
				usedMathFunctions = true;
				break;
				
			case '*':
				multiplyNext = true;
				usedMathFunctions = true;
				break;
			
			case '%':
				moduloNext = true;
				usedMathFunctions = true;
				break;
			}
			
			// if the character is a digit.
			if(Character.isDigit(c[i])) {
				
				// if the preceding character was a math function
				// then calculate and reset the math flags.
				if(sumNext) {
					calculatedResult += (c[i] - '0');
					ResetMathFlags();
				} else if(subtractNext) {
					calculatedResult -= (c[i] - '0');
					ResetMathFlags();
				} else if(divideNext) {
					try {
						calculatedResult /= (c[i] - '0');
						ResetMathFlags();
					} catch(ArithmeticException e) {
						return "#Error";
					}
				} else if(multiplyNext) {
					calculatedResult *= (c[i] - '0');
					ResetMathFlags();
				} else if(moduloNext) {
					try {
						calculatedResult %= (c[i] - '0');
						ResetMathFlags();
					} catch(ArithmeticException e) {
						return "#Error";
					}
				} else {
					// nothing to see here. (o_o)
				}
				digitCount ++;
				
			// if character is letter.
			} else if(Character.isLetter(c[i])) {
				
				// if we have already used math functions 
				// we don't allow letters.
				if(usedMathFunctions) {
					return "#Error";
				}
			}
		}
		
		// if we did some sort of math calculations, just return the result.
		// example: cell had "=1+1"
		// so we raised usedMathFunctions, because we noticed the '+' sign.
		if(usedMathFunctions) {
			return "" + calculatedResult;
		}
		
		// if the WHOLE input value is a string.
		// return a substring without single quotes.
		if(isString) {
			return value.substring(1, value.length() - 1);
		}
		
		// if there are some other characters than digits.
		// 1. Check if the number is negative
		// 2. if the string contains other characters than digits and '-'.
		if(isNegative || containsEquals) {
			
			// "remove" two from value length
			// 1. negative sign
			// 2. equals sign
			if(isNegative && containsEquals) {
				if(digitCount != c.length - 2) {
					return "#Error";
				} else {
					return value.substring(startPos);
				}
			}
			
			// "remove" one from value length
			// 1. negative sign
			if(digitCount != (c.length - 1)) {
				return "#Error";
			} else {
				return value.substring(startPos);
			}
			
		} else {
			
			if(digitCount != c.length) {
				return "#Error";
			} else {
				return value;
			}
			
		}
	}
	
	private void ResetMathFlags() {
		sumNext = false;
		subtractNext = false;
		multiplyNext = false;
		divideNext = false;
		moduloNext = false;
	}
	
	
}
