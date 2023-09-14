package helper;

public enum RokuController {

	UP("up"),
	DOWN("down"),
	LEFT("left"),
	RIGHT("right"),
	HOME("home");

	private final String navigation;

	RokuController(String navigation) {
		this.navigation = navigation;
	}

	public String getNavigation() {
		return navigation;
	}
}
