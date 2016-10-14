import java.util.ArrayList;
public class Spreadsheet {

	 ArrayList<String> cells=new ArrayList<String>();
	 static boolean error;
	public String get(String cell) {
		      
		return cells.get(cells.lastIndexOf(cell)+1); // 1 
				
	}
	
	public void set(String cell, String value) {
		cells.add(cell);
		cells.add(value);

	}
	
	public String evaluate(String cell) {
		if (cells.get(cells.lastIndexOf(cell)+1).startsWith("0") || // starts with numbers or signs
				cells.get(cells.lastIndexOf(cell)+1).startsWith("1") ||
				cells.get(cells.lastIndexOf(cell)+1).startsWith("2") ||
				cells.get(cells.lastIndexOf(cell)+1).startsWith("3") ||
				cells.get(cells.lastIndexOf(cell)+1).startsWith("4") ||
				cells.get(cells.lastIndexOf(cell)+1).startsWith("5") ||
				cells.get(cells.lastIndexOf(cell)+1).startsWith("6") ||
				cells.get(cells.lastIndexOf(cell)+1).startsWith("7") ||
				cells.get(cells.lastIndexOf(cell)+1).startsWith("8") ||
				cells.get(cells.lastIndexOf(cell)+1).startsWith("9") ||
				cells.get(cells.lastIndexOf(cell)+1).startsWith("-") ||
				cells.get(cells.lastIndexOf(cell)+1).startsWith("+")){
					
					for(int i=1; i<cells.get(cells.lastIndexOf(cell)+1).length() ; i++){
						if(!(cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("0")|| // 3 not countinious with number
						cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("1")||
						cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("2")||
						cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("3")||
						cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("4")||
						cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("5")||
						cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("6")||
						cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("7")||
						cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("8")||
						cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("9")||
						cells.get(cells.lastIndexOf(cell)+1).substring(i).startsWith("0"))){
							return "#Error";
						}else{
							cells.get(cells.lastIndexOf(cell)+1); // 2 number 
						}
				    }	
				}else if(cells.get(cells.lastIndexOf(cell)+1).startsWith("’")){ // starts with quote
					
					if(cells.get(cells.lastIndexOf(cell)+1).endsWith("’")){ // 4 ends with quote
						
						return cells.get(cells.lastIndexOf(cell)+1).substring(1,cells.get(cells.lastIndexOf(cell)+1).length()-1);
						
					}else{  // 5 starts with quote not ends with quote 
						return "#Error";
					}
					
				}else if(cells.get(cells.lastIndexOf(cell)+1).startsWith("=")){ // starts with equation
					   if(cells.get(cells.lastIndexOf(cell)+1).substring(1,2).equals("’")){ // starts with equation end quote 
						   String operation = cells.get(cells.lastIndexOf(cell)+1).substring(1);
						   if(operation.contains("&")){
								 if(operation.startsWith("’") & operation.endsWith("")){
							     int index = operation.indexOf('&')-1;
								 int firstIndex =operation.substring(1, operation.length()-2).indexOf('’');
								 int lastIndex = operation.substring(1, operation.length()-2).lastIndexOf('’');
							// 	System.out.println(operation.substring(1,firstIndex+1) + operation.substring(lastIndex+2,operation.length()-1));
						    // System.out.println(firstIndex +" "+index+" "+lastIndex);
								 if((firstIndex +1 == index) & (index +1==lastIndex)){
								 return operation.substring(1,firstIndex+1) + operation.substring(lastIndex+2,operation.length()-1);
								 }else{
									 return "#Error";
								 }
								 }else{
									 return "#Error";
								 }
								 
							 }else if(cells.get(cells.lastIndexOf(cell)+1).endsWith("’")){ // 6
							   return cells.get(cells.lastIndexOf(cell)+1).substring(2,cells.get(cells.lastIndexOf(cell)+1).length()-1);
						   }else{
							   return "#Error"; // 7
						   }
					  }else if(cells.contains(cells.get(cells.lastIndexOf(cell)+1).substring(1))){ // 8 =A1 ALSO 9
					           if(cells.get(cells.lastIndexOf(cells.get(cells.lastIndexOf(cell)+1).substring(1))+1).equals("=" + cell)){
					        	   return "#Circular"; // 10
					           }else{
					        	   return evaluate(cells.get(cells.lastIndexOf(cell)+1).substring(1)); // 8 =A1 ALSO 9
					           }
						   
						   
					   }else if(cells.get(cells.lastIndexOf(cell)+1).contains("+")||
							   cells.get(cells.lastIndexOf(cell)+1).contains("-")||
							   cells.get(cells.lastIndexOf(cell)+1).contains("*")||
							   cells.get(cells.lastIndexOf(cell)+1).contains("/")||
							   cells.get(cells.lastIndexOf(cell)+1).contains("%")){
						 String operation = cells.get(cells.lastIndexOf(cell)+1).substring(1);
					/*	for(int i=0 ; i<operation.length();i++){
							if(!(operation.charAt(i)==('0')||
							  operation.charAt(i)==('1')||
							  operation.charAt(i)==('2')||
							  operation.charAt(i)==('3')||
							  operation.charAt(i)==('4')||
							  operation.charAt(i)==('5')||
							  operation.charAt(i)==('6')||
							  operation.charAt(i)==('7')||
							  operation.charAt(i)==('8')||
							  operation.charAt(i)==('9')||
							  operation.charAt(i)==('+')||
							  operation.charAt(i)==('-')||
							  operation.charAt(i)==('*')||
							  operation.charAt(i)==('/')||
							  operation.charAt(i)==('%')||
							  operation.charAt(i)==('(')||
							  operation.charAt(i)==(')'))||
							  operation.charAt(i)==(' ')||
							  operation.charAt(i)==('\r')||
							  operation.charAt(i)==('\t')||
                              operation.charAt(i)==('\r')
							  ){
								
								
								return "#Error";
						}
						}
					*/		
						
						if((operation.contains("(")&& !operation.contains(")"))||(!operation.contains("(") && operation.contains(")"))){
							return "#Error";
						}
						
							 return eval(operation);
						

					   }
				}else{
					return cells.get(cells.lastIndexOf(cell)+1);
				}
				return cells.get(cells.lastIndexOf(cell)+1);
	}
	public static String eval(final String str) {
	    return new Object() {
	        int pos = -1, ch;

	        void nextChar() {
	            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
	        }

	        boolean eat(int charToEat) {
	            while (ch == ' ') nextChar();
	            if (ch == charToEat) {
	                nextChar();
	                return true;
	            }
	            return false;
	        }

	        String parse() {
	            nextChar();
	            int x = parseExpression();
	            if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
	            return Integer.toString(x);
	        }

	        // Grammar:
	        // expression = term | expression `+` term | expression `-` term
	        // term = factor | term `*` factor | term `/` factor
	        // factor = `+` factor | `-` factor | `(` expression `)`
	        //        | number | functionName factor | factor `^` factor

	        int parseExpression() {
	            int x = parseTerm();
	            for (;;) {
	                if      (eat('+')) x += parseTerm(); // addition
	                else if (eat('-')) x -= parseTerm(); // subtraction
	                else if (eat('*')) x *= parseTerm();
	                else if (eat('/')) x /= parseTerm();
	                else return x;
	            }
	        }

	        int parseTerm() {
	        	 if (eat('+')) return parseTerm(); // unary plus
		        if (eat('-')) return -parseTerm(); // unary minus
		        
	          /*  int x = parseFactor();
	            for (;;) {
	                if      (eat('*')) x *= parseFactor(); // multiplication
	                else if (eat('/')) x /= parseFactor(); // division
	                else return x;
	            }
	            */
		        int x;
	            int startPos = this.pos;
	            if (eat('(')) { // parentheses
	                x = parseExpression();
	                eat(')');
	            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
	                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
	                x = Integer.parseInt(str.substring(startPos, this.pos));
	  
	            } else {
	            	error = true;
	                throw new RuntimeException("Unexpected: " + (char)ch);
	            }

	            return x;
	        }

	    }.parse();
	}
}
