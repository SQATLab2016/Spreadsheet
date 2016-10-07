import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Spreadsheet {
	
	HashMap<String, List<SubEntry>> cell_entries = new HashMap<>();

	public String get(String cell) {
		return concatSubEntryStrings(cell_entries.get(cell));
	}
	
	public void set(String cell, String value) {
		cell_entries.put(cell, createSubEntries(value));
	}
	
	public String evaluate(String cell) {
		String cell_entry = concatSubEntryStrings(cell_entries.get(cell));
		return cell_entry;
	}
	
	public String concatSubEntryStrings(List<SubEntry> subEntries) {
		String res = "";
		for (SubEntry se : subEntries) {
			res += se;
		}
		return res;
	}
	
	public List<SubEntry> createSubEntries(String cell) {
		List<SubEntry> subEntries = new LinkedList<>();
		String intSubEntry = "";
		String strSubEntry = "";
		boolean quotesOpen = false;
		
		for (char c : cell.toCharArray()) {
			if (quotesOpen == false) {
				if (c != '\'') {
					intSubEntry += c;
				} else {
					subEntries.add(new SubEntry(intSubEntry));
					intSubEntry = "";
					quotesOpen = true;
				}
			} else {
				if (c != '\'') {
					strSubEntry += c;
				} else {
					subEntries.add(new SubEntry(strSubEntry));
					strSubEntry = "";
					quotesOpen = false;
				}
			}
		}
		if (intSubEntry != "")
			subEntries.add(new SubEntry(intSubEntry));
		else if (strSubEntry != "")
			subEntries.add(new SubEntry(strSubEntry));
			/*
			int cellEntry = Integer.valueOf();
			return String.valueOf(cellEntry);
		} catch (NumberFormatException ex) {
			return "#Error";
		}
		
		
		List<SubEntry> subEntries = new LinkedList<>();
		
		*/
		return subEntries;
		
	}
	
}
