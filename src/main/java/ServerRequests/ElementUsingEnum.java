package ServerRequests;

public enum ElementUsingEnum {
    TEXT("text"),
    ATTR("attr"),
    TAG("tag");

    private String using;

    ElementUsingEnum(String using) {
        this.using = using;
    }

    public String getUsing() {
        return using;
    }
}
