class InvalidCardException extends IllegalArgumentException {
    public InvalidCardException(String message) {
        super(message);
    }
}

public class Card {
    private final Color color;
    private final Suit suit;
    private final Rank rank;

    public Card(Color color, Suit suit, Rank rank) {
        ValidateColorAndSuit(color, suit);
        this.color = color;
        this.suit = suit;
        this.rank = rank;
    }

    private void ValidateColorAndSuit(Color color, Suit suit) throws InvalidCardException {
        if (((color.toString().equals("Black")) && suit.toString().equals("Hearts")) ||
                ((color.toString().equals("Black")) && suit.toString().equals("Diamonds")) ||
                ((color.toString().equals("Red")) && suit.toString().equals("Clubs")) ||
                ((color.toString().equals("Red")) && suit.toString().equals("Spades"))) {
            throw new InvalidCardException("A card with the color " + color.toString().toLowerCase() +
                    " and the suit " + suit.toString().toLowerCase() + " is not legal.");
        }
    }

    public Color getColor() {
        return color;
    }
    public Suit getSuit() {
        return suit;
    }
    public Rank getRank() {
        return rank;
    }

    public static void printCard(Card card) {
        System.out.println("Color: " + card.getColor() + "\nSuit: " + card.getSuit() + "\nRank: " + card.getRank());
    }
}
