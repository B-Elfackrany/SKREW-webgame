package cardgame.cards.actioncards;
public class RemoveCard extends ActionCard {

    public RemoveCard() {
        super(10, false, false);
    }

    @Override
    public void executeAction() {
        System.out.println("Executing action: Remove Card");
    }

    @Override
    public String cardInfo() {
        return super.cardInfo() + ", Action: Remove Card";
    }
}