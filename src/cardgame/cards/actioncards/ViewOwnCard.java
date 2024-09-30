package cardgame.cards.actioncards;
public class ViewOwnCard extends ActionCard {

    public ViewOwnCard(int score) {
        super(score, false, false);
    }

    @Override
    public void executeAction() {
        System.out.println("Executing action: View Own Card");
    }

    @Override
    public String cardInfo() {
        return super.cardInfo() + ", Action: View Own Card";
    }
}