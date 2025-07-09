class InvalidCardException extends IllegalArgumentException {
    public InvalidCardException(String message) {
        super(message);
    }
}

public class Card {
    private final CardColor color;
    private final CardSuit cardSuit;
    private final CardRank cardRank;

    public Card(CardColor color, CardSuit cardSuit, CardRank cardRank) {
        ValidateColorAndSuit(color, cardSuit);
        this.color = color;
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    private void ValidateColorAndSuit(CardColor color, CardSuit cardSuit) throws InvalidCardException {
        if (((color.toString().equals("Black")) && cardSuit.toString().equals("Hearts")) ||
                ((color.toString().equals("Black")) && cardSuit.toString().equals("Diamonds")) ||
                ((color.toString().equals("Red")) && cardSuit.toString().equals("Clubs")) ||
                ((color.toString().equals("Red")) && cardSuit.toString().equals("Spades"))) {
            throw new InvalidCardException("A card with the color " + color.toString().toLowerCase() +
                    " and the suit " + cardSuit.toString().toLowerCase() + " is not legal.");
        }
    }

    public CardColor getColor() {
        return color;
    }
    public CardSuit getSuit() {
        return cardSuit;
    }
    public CardRank getRank() {
        return cardRank;
    }

    public String getCardFileName() {
        String fileName = getRank().toString() + "_of_" + getSuit().toString() + ".png";
        return fileName.toLowerCase();
    }

    public static void printCard(Card card) {
        System.out.println("Color: " + card.getColor() + "\nSuit: " + card.getSuit() + "\nRank: " + card.getRank());
    }
}
