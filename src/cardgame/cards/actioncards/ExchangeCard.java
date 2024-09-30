package cardgame.cards.actioncards;

public class ExchangeCard extends ActionCard {

    public ExchangeCard() {
        super(10, false, false);
    }

    @Override
    public void executeAction() {
        System.out.println("Executing action: Exchange Card");
    }

    @Override
    public String cardInfo() {
        return super.cardInfo() + ", Action: Exchange Card";
    }
}