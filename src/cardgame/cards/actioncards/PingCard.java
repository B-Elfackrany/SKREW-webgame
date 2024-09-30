package cardgame.cards.actioncards;
public class PingCard extends ActionCard {

    public PingCard() {
        super(10, false, false);
    }

    @Override
    public void executeAction() {
        System.out.println("Executing action: PingCard");
    }

    @Override
    public String cardInfo() {
        return super.cardInfo() + ", Action: PingCard";
    }
}