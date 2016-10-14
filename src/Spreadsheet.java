import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spreadsheet {
	
	private static final String CIRCULAR_TAG = "#Circular";
	private static final String ERROR_TAG = "#Error";
	HashMap<String, List<SubEntry>> cell_entries = new HashMap<>();
	Set<Integer> references;
	boolean circularDetected = false;

	public String get(String cell) {
		return concatSubEntries(cell_entries.get(cell));
	}
	
	public void set(String cell, String value) {
		cell_entries.put(cell, createSubEntries(value));
	}
	
	public String evaluate(String cell) {
		references = new HashSet<>();
		List<String> evaluatedSubEntries = new LinkedList<>();
		for (SubEntry se : cell_entries.get(cell)) {
			String evaluatedSubEntry = evaluateSubEntry(se);
			if (evaluatedSubEntry.equals(ERROR_TAG))
				return ERROR_TAG;
			else
				evaluatedSubEntries.add(evaluatedSubEntry);
			
			if (circularDetected) {
				return CIRCULAR_TAG;
			}
		}
		String cell_entry = concatStrings(evaluatedSubEntries);
		
		return cell_entry;
	}
	
	public String evaluateSubEntry(SubEntry se) {
		if (se.getType() == SubEntryType.NUMBER && ! isNum(se.getValue())) {
			return ERROR_TAG;
		} else if (se.getType() == SubEntryType.REFERENCE) {
			if (references.contains(Integer.valueOf(se.getValue()))) {
				circularDetected = true;
				return CIRCULAR_TAG;
			} else {
				references.add(Integer.valueOf(se.getValue()));
				return evaluate("A" + se.getValue());
			}
		} else {
			return se.getValue();
		}
	}
	
	public String concatSubEntries(List<SubEntry> subEntries) {
		String res = "";
		for (SubEntry se : subEntries) {
			res += se.getValue();
		}
		return res;
	}
	
	public String concatStrings(List<String> strings) {
		String res = "";
		for (String s : strings) {
			res += s;
		}
		return res;
	}
	
	public List<SubEntry> createSubEntries(String cell) {
		List<SubEntry> subEntries = new LinkedList<>();
		String intSubEntry = "";
		String strSubEntry = "";
		String refValue = "";
		boolean quotesOpen = false;
		boolean refToCell = false;
		
		for (int i = 0; i < cell.toCharArray().length; i++) {
			char c = cell.toCharArray()[i];
			
			// Check for "=" at the beginning of the cell value
			if (i == 0 && c == '=')
				continue;
			
			if (refToCell) {
				if (c != ' ') {
					refValue += c;
				} else {
					refToCell = false;
					subEntries.add(new SubEntry(refValue, SubEntryType.REFERENCE));
					refValue = "";
				}
			} else if (quotesOpen == false) {
				if (c == 'A') {
					refToCell = true;
					if (intSubEntry != "" || strSubEntry != "") {
						subEntries.add(new SubEntry(ERROR_TAG, SubEntryType.ERROR));
						intSubEntry = "";
						strSubEntry = "";
					}
				} else if (c != '\'') {
					intSubEntry += c;
				} else {
					if (intSubEntry != "")
						subEntries.add(new SubEntry(intSubEntry, SubEntryType.NUMBER));
					intSubEntry = "";
					quotesOpen = true;
				}
			} else {
				if (c != '\'') {
					strSubEntry += c;
				} else {
					subEntries.add(new SubEntry(strSubEntry, SubEntryType.STRING));
					strSubEntry = "";
					quotesOpen = false;
				}
			}
		}
		if (intSubEntry != "")
			subEntries.add(new SubEntry(intSubEntry, SubEntryType.NUMBER));
		if (strSubEntry != "")
			subEntries.add(new SubEntry(ERROR_TAG, SubEntryType.ERROR));
		if (refToCell == true) {
			if (refValue != "")
				subEntries.add(new SubEntry(refValue, SubEntryType.REFERENCE));
			else 
				subEntries.add(new SubEntry(ERROR_TAG, SubEntryType.ERROR));
		}
		
		return subEntries;
	}
	
	public boolean isNum(String s) {
		try {
			Integer.valueOf(s);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
	
}
