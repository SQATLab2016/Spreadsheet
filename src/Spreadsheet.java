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
		
		if (value.matches(".*\\d+.*") && value.matches(".*[^\\d-]+.*")) {
			return "#Error";
		}
		
		Pattern p = Pattern.compile("^'(.*)'$");
		Matcher m = p.matcher(value);
		if (m.find()) {
			return m.group(1);
		}
		
		p = Pattern.compile("^'(.*)[^']$");
		m = p.matcher(value);
		if (m.find()) {
			return "#Error";
		}
		
		return "-1";
	}
	
}
