import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        Color[] colors = {Color.RED, Color.BLACK};
        Suit[] suits = {Suit.CLUBS, Suit.SPADES, Suit.DIAMONDS, Suit.HEARTS};
        Rank[] ranks = {Rank.ACE, Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX,
                Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING};
        this.cards = new ArrayList<Card>();
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                if (((colors[i] == Color.RED) && (suits[j] == Suit.CLUBS)) ||
                        ((colors[i] == Color.RED) && (suits[j] == Suit.SPADES)) ||
                        ((colors[i] == Color.BLACK) && (suits[j] == Suit.HEARTS)) ||
                        ((colors[i] == Color.BLACK) && (suits[j] == Suit.DIAMONDS))) {
                    continue;
                }
                for (int k = 0; k < ranks.length; k++) {
                    cards.add(new Card(colors[i], suits[j], ranks[k]));
                }
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void printDeck(Deck deck) {
        ArrayList<Card> cardArrayList = deck.getCards();
        for (int i = 0; i < cardArrayList.size(); i++) {
            System.out.println(i);
            Card.printCard(cardArrayList.get(i));
        }
    }
}
