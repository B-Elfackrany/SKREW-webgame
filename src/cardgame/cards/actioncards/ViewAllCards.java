package cardgame.cards.actioncards;
public class ViewAllCards extends ActionCard {

    public ViewAllCards() {
        super(10, false, false);
    }

    @Override
    public void executeAction() {
        System.out.println("Executing action: View All Card");
    }

    @Override
    public String cardInfo() {
        return super.cardInfo() + ", Action: View All Card";
    }
}