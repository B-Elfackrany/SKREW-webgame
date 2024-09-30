package cardgame.cards.actioncards;
public class PongCard extends ActionCard {

    public PongCard() {
        super(10, false, false);
    }

    @Override
    public void executeAction() {
        System.out.println("Executing action: PongCard");
    }

    @Override
    public String cardInfo() {
        return super.cardInfo() + ", Action: PongCard";
    }
}