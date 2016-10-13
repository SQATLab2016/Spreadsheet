import java.awt.Event;
import java.util.ArrayList;

public class Spreadsheet {

	public String[][] matrix = new String[27][1000];
	public static char[] abecedario = new char[26];




	public Spreadsheet() {
		super();

		int a = (int) 'A'; 

		for(int i = 0; i < abecedario.length; i++) 
		{ 
			abecedario[i] = (char) (a + i); 
		}

	}


	public char intToAbc(int num){
		return abecedario[num];

	}	
	public int abcToInt(char a){
		int num=-1;
		for(int i = 0; i < abecedario.length; i++) 
		{ 
			if (abecedario[i]== a) {
				num=i;
				break;
			}
		}

		return num;

	}
	public String get(String cell) {

		int row= abcToInt(cell.charAt(0));
		cell= cell.substring(1);
		int column = Integer.valueOf(cell);

		return matrix[row][column];
	}

	public void set(String cell, String value) {
		int row= abcToInt(cell.charAt(0));
		cell= cell.substring(1);
		int column = Integer.valueOf(cell);	
		matrix[row][column]= value;	

	}

	public String evaluate(String cell) {
		String value="";

		if (get(cell).startsWith("=")) {

			if (get(cell).startsWith("='") && get(cell).endsWith("'")) {
				value+= get(cell).substring(2, get(cell).length()-1);
			}else if (isCell(get(cell).substring(1))) {
				String nextCell=get(cell).substring(1);
				
				if (isNumeric(get(nextCell))) {
					value+=get(nextCell);
				}else value.equals("#Error1");

				
				if (get(nextCell).substring(1).equals(cell)) {
					value+="#Circula";

				}


			}else return "#Error2";



		}else{

			if (isNumeric(get(cell))) {

				value+= get(cell);
			}else if (get(cell).startsWith("'") && get(cell).endsWith("'")) {
				value+= get(cell).substring(1, get(cell).length()-1);
			}else return "#Error3";

		}
		return value;
	}	


	//	si = + String '' --> devuelve el string
	//	si = + String a medias 'o' --> devuelve #error
	//	si = + Letra+Numeros A13--> devuelve le valor de esa celda

	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	private static boolean isCell(String cadena){
		if (cadena.charAt(0)>='A'&&cadena.charAt(0)<='Z' && isNumeric(cadena.substring(1))&& cadena.charAt(1)!='-') {
			return true;
		}else return false;
	}

	public static void main(String[] args) {

		Spreadsheet sp= new Spreadsheet();
		sp.set("B13","=B16");
		sp.set("B16", "5");
		System.out.println(sp.evaluate("B13"));

	}
}
