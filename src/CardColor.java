public enum CardColor {
    RED, BLACK;

    public String toString() {
        return switch (this) {
            case RED -> "Red";
            case BLACK -> "Black";
        };
    }
}
