import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.Scanner;

/* clear		tyhjent�� HashMapin
containsKey		tutkii l�ytyyk� etsitt�v� avain HashMapista.
containsValue	tutkii l�ytyyk� etsitt�v� arvo HashMapista
get				palauttaa haettavaa avainta vastaavan arvon
isEmpty			tutkii onko HashMap tyhj�
put				vie HashMapiin annetun avainmen ja arvon
remove		 	poistaa annetun avaimen mukaisen avain-arvo �parin 				HashMapista
size			palauttaa HashMapin avain-arvo -parien lukum��r�n


 */
public class Spreadsheet {

	
private HashMap<String, String> hmap = new HashMap<String, String>();

private static boolean hipsu(char merkki) {
    return ("'".indexOf(merkki) != -1);
  }

public String get(String cell) {
		
		String val = hmap.get(cell);
		return val;
		
	
	}
	
	public void set(String cell, String value) {
		hmap.put(cell, value);
		// to be implemented
		
	}
	
	public String evaluate(String cell) {
	
		
		
		Integer t;
		String value = hmap.get(cell);
		
		t = Integer.parseInt(value);
		Scanner scanner = new Scanner(value);
		
		 if (scanner.hasNextInt()) {
				return value;
				}
			else {
				return "#Error";
				}	
	
			
		//find mark
		 
		// if(scanner.findInLine("'")){
			 
		 //}
		 
		for (int i=0; i<jono.length(); ++i)
						
			if (value.matches("'"))
			{
			return value;
			}
			else {
				i
			}
		
			scanner.close();
	boolean matches(String value regular_expression)
	
	
	}
	
}
