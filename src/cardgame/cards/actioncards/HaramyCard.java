package cardgame.cards.actioncards;
public class HaramyCard extends ActionCard {

    public HaramyCard() {
        super(10, false, false);
    }

    @Override
    public void executeAction() {
        System.out.println("Executing action: HaramyCard");
    }

    @Override
    public String cardInfo() {
        return super.cardInfo() + ", Action: Haramy";
    }
}