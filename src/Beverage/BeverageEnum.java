package Beverage;

public enum BeverageEnum {
    NOTHING("No beverage"),
    COFFEE("Coffee"),
    TEA("Tea"),
    WATER("Water"),
    ALE("Ale");

    private final String displayName;

    BeverageEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
