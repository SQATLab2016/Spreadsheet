import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spreadsheet {
	
	private Map<String, String> cells = new HashMap<String, String>();

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
			return this.evaluate(m.group(1));
		}

		// An integer
		p = Pattern.compile("^=?(-?\\d+)$");
		m = p.matcher(value);
		if (m.find()) {
			return m.group(1);
		}
		
		// An invalid integer
		if (value.matches(".*\\d+.*") && value.matches(".*[^\\d-]+.*")) {
			return "#Error";
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
