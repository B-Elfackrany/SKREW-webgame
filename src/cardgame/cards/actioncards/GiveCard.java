package cardgame.cards.actioncards;
public class GiveCard extends ActionCard {

    public GiveCard() {
        super(10, false, false);
    }

    @Override
    public void executeAction() {
        System.out.println("Executing action: Give Card");
    }

    @Override
    public String cardInfo() {
        return super.cardInfo() + ", Action: Give Card";
    }
}