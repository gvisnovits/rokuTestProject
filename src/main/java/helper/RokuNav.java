package helper;

public enum RokuNav {

    UP("up"),
    DOWN("down"),
    LEFT("left"),
    RIGHT("right"),
    HOME("home");

    private final String navigation;
    RokuNav(String navigation) {
        this.navigation = navigation;
    }

    public String getNavigation() {
        return navigation;
    }
}
