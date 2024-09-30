package cardgame.decks;
import cardgame.cards.actioncards.HaramyCard;
public class HaramyDeck extends ClassicDeck {

    public HaramyDeck() {
        super();
        deck.push(new HaramyCard());
    }
}
