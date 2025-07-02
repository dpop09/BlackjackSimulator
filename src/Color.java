public enum Color {
    RED, BLACK;

    public String toString() {
        return switch (this) {
            case RED -> "Red";
            case BLACK -> "Black";
        };
    }
}
