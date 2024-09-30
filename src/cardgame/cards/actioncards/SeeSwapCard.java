package cardgame.cards.actioncards;
public class SeeSwapCard extends ActionCard {

    public SeeSwapCard() {
        super(10, false, false);
    }

    @Override
    public void executeAction() {
        System.out.println("Executing action: Seaa and Swap");
    }

    @Override
    public String cardInfo() {
        return super.cardInfo() + ", Action: See and Swap";
    }
}