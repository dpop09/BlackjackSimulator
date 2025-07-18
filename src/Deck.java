import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        CardColor[] colors = {CardColor.RED, CardColor.BLACK};
        CardSuit[] cardSuits = {CardSuit.CLUBS, CardSuit.SPADES, CardSuit.DIAMONDS, CardSuit.HEARTS};
        CardRank[] cardRanks = {CardRank.ACE, CardRank.TWO, CardRank.THREE, CardRank.FOUR, CardRank.FIVE, CardRank.SIX,
                CardRank.SEVEN, CardRank.EIGHT, CardRank.NINE, CardRank.TEN, CardRank.JACK, CardRank.QUEEN, CardRank.KING};
        this.cards = new ArrayList<Card>();
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < cardSuits.length; j++) {
                if (((colors[i] == CardColor.RED) && (cardSuits[j] == CardSuit.CLUBS)) ||
                        ((colors[i] == CardColor.RED) && (cardSuits[j] == CardSuit.SPADES)) ||
                        ((colors[i] == CardColor.BLACK) && (cardSuits[j] == CardSuit.HEARTS)) ||
                        ((colors[i] == CardColor.BLACK) && (cardSuits[j] == CardSuit.DIAMONDS))) {
                    continue;
                }
                for (int k = 0; k < cardRanks.length; k++) {
                    cards.add(new Card(colors[i], cardSuits[j], cardRanks[k]));
                }
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getDeckSize() {
        return cards.size();
    }

    public Card drawCard() {
        // check if the deck is not empty
        if (getDeckSize() > 0) {
            return cards.removeLast();
        }
        return null;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void printDeck() {
        for (int i = 0; i < getDeckSize(); i++) {
            System.out.println(i+1);
            Card.printCard(cards.get(i));
        }
    }
}
