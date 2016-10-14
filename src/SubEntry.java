
public class SubEntry {
	private String value;
	private SubEntryType type;
	
	public SubEntry(String value, SubEntryType type) {
		this.value = value;
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public SubEntryType getType() {
		return type;
	}

	public void setType(SubEntryType type) {
		this.type = type;
	}
	
}
