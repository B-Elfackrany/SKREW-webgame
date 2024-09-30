package cardgame.decks;
import cardgame.cards.actioncards.ViewOwnCard;
import cardgame.cards.*;
import cardgame.cards.actioncards.*;

public class ClassicDeck extends Deck {

    public ClassicDeck() {
        super();
    }

    @Override
    public void initializeDeck() {
        // Adding regular cards
        for (int j = 1; j <= 4; j++) { // 4x cards
            for (int i = 1; i <= 10; i++) { // regular numbers
                switch (i) {
                    case 7, 8 ->
                        deck.push(new ViewOwnCard(i));
                    case 9, 10 ->
                        deck.push(new ViewOtherCard(i));
                    default ->
                        deck.push(new RegularCard(i));
                }
            }
            deck.push(new ExchangeCard()); // 5od w Hat
            deck.push(new RegularCard(20)); // +20
        }

        // Adding other action cards
        for (int i = 0; i < 2; i++) { // 2x cards
            deck.push(new RegularCard(0)); // Zero
            deck.push(new RegularCard(25)); // 25
            deck.push(new ViewAllCards()); // Ka3b Dayer
            deck.push(new RemoveCard()); // Basra
        }

        // 1x cards
        deck.push(new RegularCard(-1)); // -1
        deck.push(new GiveCard()); // 5od Bas
        deck.push(new SeeSwapCard()); // See Swap
    }
}