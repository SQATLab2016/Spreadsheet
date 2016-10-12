import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spreadsheet {
	
	private Map<String, String> cells = new HashMap<String, String>();
	private List<String> referencedCells = new ArrayList<String>();
	
	private String calculateEquation(String equation) {
		String[] operands = equation.replaceAll("\\d", "").split("\\s*");
		String[] numbers = equation.replaceAll("[^\\d]", " ").split("\\s+");
		
		if (numbers.length != operands.length + 1) {
			return "#Error";
		}
		
		int sum = Integer.parseInt(numbers[0]);
		for (int i = 0; i < operands.length; i++) {
			int number = Integer.parseInt(numbers[i + 1]); 
			if (operands[i].equals("+")) {
				sum += number;
			} else if (operands[i].equals("-")) {
				sum -= number;
			} else if (operands[i].equals("*")) {
				sum *= number;
			} else if (operands[i].equals("/")) {
				if (number == 0) {
					return "#Error";
				}
				
				sum /= number;
			} else if (operands[i].equals("%")) {
				sum %= number;
			} else {
				return "#Error";
			}
		}
		
		return Integer.toString(sum);
	}

	public String get(String cell) {
		return cells.get(cell);
	}
	
	public void set(String cell, String value) {
		cells.put(cell, value);
	}
	
	public String evaluate(String cell) {
		String value = this.get(cell);
		
		// Cell reference
		Pattern p = Pattern.compile("^=([A-Z]+\\d+)$");
		Matcher m = p.matcher(value);
		if (m.find()) {
			String referencedCell = m.group(1);
			
			if (this.referencedCells.contains(referencedCell)) {
				return "#Circular";
			}
			
			referencedCells.add(referencedCell);
			return this.evaluate(referencedCell);
		}
		// Reset referenced cell counter
		this.referencedCells.clear();

		// An integer
		p = Pattern.compile("^=?(-?\\d+)$");
		m = p.matcher(value);
		if (m.find()) {
			return m.group(1);
		}
		
		// Integer operations
		p = Pattern.compile("^=([\\d+\\-\\*/%\\(\\)\\s]+)$");
		m = p.matcher(value);
		if (m.find()) {
			StringBuffer equation = new StringBuffer(m.group(1).replaceAll("\\s+", ""));
			
			// Look for parentheses
			while (equation.indexOf(")") != -1) {
				int closingParenthesis = equation.indexOf(")");
				
				int openingParenthesis = equation.lastIndexOf("(", closingParenthesis);
				if (openingParenthesis == -1) {
					// No matching opening parenthesis found
					return "#Error";
				}
				
				String subEquation = equation.substring(openingParenthesis + 1, closingParenthesis);
				String calculatedSubEquation = calculateEquation(subEquation);
				
				if (calculatedSubEquation.equals("#Error")) {
					return "#Error";
				}

				// Replace the parentheses and their content with the calculated result
				equation = equation.replace(openingParenthesis, closingParenthesis + 1, calculatedSubEquation);
			}
			
			// No more parentheses; calculate the full equation
			return calculateEquation(equation.toString());
		}
		
		// An invalid integer
		if (value.matches(".*\\d+.*") && value.matches(".*[^\\d-]+.*")) {
			return "#Error";
		}
		
		// String concatenation
		// Find all concatenations, i.e.
		// '&' (valid)
		// '&  (invalid)
		//  &' (invalid)
		p = Pattern.compile("^=?'(.*)(?:'?&'?(.*))+'$");
		m = p.matcher(value);
		if (m.find()) {
			int totalCount = m.groupCount();
			
			// Find only valid concatenations
			p = Pattern.compile("^=?'(.*)(?:'&'(.*))+'$");
			m = p.matcher(value);
			
			// If the two findings are not of equal size, it means
			// that the first finding found also invalid concatenations
			if (!m.find() || m.groupCount() != totalCount) {
				return "#Error";
			}
			
			return m.group(1) + String.join("", m.group(2).split("'&'"));
		}
		
		// A string
		p = Pattern.compile("^=?'(.*)'$");
		m = p.matcher(value);
		if (m.find()) {
			return m.group(1);
		}
		
		// A string without a heading or trailing quote
		p = Pattern.compile("^[^'](.*)'$|^'(.*)[^']$");
		m = p.matcher(value);
		if (m.find()) {
			return "#Error";
		}
		
		return "#Error";
	}
	
}
