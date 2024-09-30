package cardgame.decks;
import java.util.Stack;
import java.util.Collections;
import cardgame.cards.*;
public abstract class Deck {

    protected Stack<Card> deck;
    protected Stack<Card> playedPile;

    public Deck() {
        deck = new Stack<>();
        playedPile = new Stack<>();
        initializeDeck();
    }

    public abstract void initializeDeck();

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public Card drawCard() {
        if (!deck.isEmpty()) {
            return deck.pop();
        }
        return null;
    }

    public void printDeck() {
        int count = 0;
        for (Card card : deck) {
            count++;
            System.out.println(card.cardInfo());
        }
        System.out.println("Deck count: " + count);
    }
}