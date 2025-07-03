public enum CardRank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public String toString() {
        return switch (this) {
            case ACE -> "Ace";
            case TWO -> "Two";
            case THREE -> "Three";
            case FOUR -> "Four";
            case FIVE -> "Five";
            case SIX -> "Six";
            case SEVEN -> "Seven";
            case EIGHT -> "Eight";
            case NINE -> "Nine";
            case TEN -> "Ten";
            case JACK -> "Jack";
            case QUEEN -> "Queen";
            case KING -> "King";
        };
    }
}
