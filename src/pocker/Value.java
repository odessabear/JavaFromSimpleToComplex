package pocker;

public enum Value {
    HIGH_CARD("High Card"), ONE_PAIR("One Pair"), TWO_PAIRS("TwoPairs"), THREE_OF_A_KIND("Three of a kind"),
    STRAIGHT("Straight"), FLUSH("Flush"), FULL_HOUSE("Full House"), FOUR_OF_A_KIND("Four of a kind"),
    STRAIGHT_FLUSH("Straight Flush"), ROYAL_FLUSH("Royal Flush");

    private String valueString;

    Value(String s) {
        valueString = s;
    }

    public String toString() {
        return valueString;
    }

}
