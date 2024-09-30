package cardgame.cards.actioncards;

import cardgame.cards.Card;

public abstract class ActionCard extends Card {

    protected ActionCard(int score, boolean inHand, boolean isFlipped) {
        super(score, inHand, isFlipped);
    }

    public abstract void executeAction();
}