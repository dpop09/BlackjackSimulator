public enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES;

    public String toString() {
        return switch (this) {
            case CLUBS -> "Clubs";
            case DIAMONDS -> "Diamonds";
            case HEARTS -> "Hearts";
            case SPADES -> "Spades";
        };
    }
}
