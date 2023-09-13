package serverrequests;

public enum LocatorStrategy {
	TEXT("text"),
	ATTR("attr"),
	TAG("tag");

	private String using;

	LocatorStrategy(String using) {
		this.using = using;
	}

	public String getUsing() {
		return using;
	}
}
