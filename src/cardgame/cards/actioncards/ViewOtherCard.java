package cardgame.cards.actioncards;

public class ViewOtherCard extends ActionCard {

    public ViewOtherCard(int score) {
        super(score, false, false);
    }

    @Override
    public void executeAction() {
        System.out.println("Executing action: View Other Card");
    }

    @Override
    public String cardInfo() {
        return super.cardInfo() + ", Action: View Other Card";
    }
}