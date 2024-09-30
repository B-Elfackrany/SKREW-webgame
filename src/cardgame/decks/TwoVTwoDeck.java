package cardgame.decks;
import cardgame.cards.actioncards.*;

public class TwoVTwoDeck extends ClassicDeck {

    public TwoVTwoDeck() {
        super();
        deck.push(new PingCard());
        deck.push(new PingCard());
        deck.push(new PongCard());
        deck.push(new PongCard());
    }
}