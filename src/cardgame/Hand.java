package cardgame;
import java.util.List;
import java.util.ArrayList;
import cardgame.decks.*;
import cardgame.cards.*;
public class Hand {

    protected List<Card> cards;
    protected String playerID;

    protected void initializeHand(String playerID, Deck deck) {
        cards = new ArrayList<>();
        this.playerID = playerID;
        cards.add(deck.drawCard());
        cards.add(deck.drawCard());
        cards.add(deck.drawCard());
        cards.add(deck.drawCard());
    }

    public void printHand() {
        System.out.println(playerID + "'s Hand:");
        for (Card card : cards) {
            System.out.println(card.cardInfo());
        }
    }

    public int getScore() {
        int score = 0;
        for (Card card : cards) {
            score += card.getScore();
        }
        return score;
    }
}