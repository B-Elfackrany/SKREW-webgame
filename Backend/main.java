import java.util.Collections;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        Deck deck = new ClassicDeck();
        deck.shuffleDeck();
        deck.printDeck();
    }
}

abstract class Card {
    private int score;
    private boolean inHand, isFlipped;

    protected Card(int score, boolean inHand, boolean isFlipped) {
        this.score = score;
        this.inHand = inHand;
        this.isFlipped = isFlipped;
    }

    public int getScore() {
        return this.score;
    }

    public boolean inHand() {
        return this.inHand;
    }

    public boolean isFlipped() {
        return this.isFlipped;
    }

    public String cardInfo() {
        return "Score: " + this.score;
    }
}
abstract class ActionCard extends Card {
    protected ActionCard(int score, boolean inHand, boolean isFlipped) {
        super(score, inHand, isFlipped);
    }
    public abstract void executeAction();
}
class ViewOwnCard extends ActionCard {
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
class ViewOtherCard extends ActionCard {
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
class ViewAllCards extends ActionCard {
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
class RemoveCard extends ActionCard {
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
class ExchangeCard extends ActionCard {
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
class GiveCard extends ActionCard {
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
class SeeSwapCard extends ActionCard {
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
class HaramyCard extends ActionCard {
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
class PingCard extends ActionCard {
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
class PongCard extends ActionCard {
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
class RegularCard extends Card {
    public RegularCard(int score) {
        super(score, false, false);
    }
}


abstract class Deck {
    protected Stack<Card> deck;

    protected Deck() {
        deck = new Stack<>();
        initializeDeck(); 
    }

    protected abstract void initializeDeck();

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public void printDeck() { 
        int count = 0;
        for (Card card : deck) {
            count++;
            System.out.println(card.cardInfo());
        }
        System.out.println("Deck count: " + count);
    }
}
class ClassicDeck extends Deck {
   
    protected ClassicDeck(){
        super();
    }
    @Override
    protected void initializeDeck() {
        // Adding regular cards
        for (int j = 1; j <= 4; j++) { // 4x cards
            for (int i = 1; i <= 10; i++) { // regular numbers
                switch (i) {
                    case 7, 8 -> deck.push(new ViewOwnCard(i));
                    case 9, 10 -> deck.push(new ViewOtherCard(i));
                    default -> deck.push(new RegularCard(i));
                }
            }
            deck.push(new ExchangeCard()); // 5od w Hat
            deck.push(new RegularCard(20)); // +20
        }

        // Adding other action cards
        for (int i = 0; i < 2; i++) { // 2x cards
            deck.push(new RegularCard(0)); // Zero
            deck.push(new RegularCard(25)); // 25
            deck.push(new ViewAllCards()); // Ka3b Dayer
            deck.push(new RemoveCard()); // Basra
        }

        // 1x cards
        deck.push(new RegularCard(-1)); // -1
        deck.push(new GiveCard()); // 5od Bas
        deck.push(new SeeSwapCard()); // See Swap
    }
}
class HaramyDeck extends ClassicDeck {
   
    protected HaramyDeck(){
        super();
        deck.push(new HaramyCard());
    }
}
class TwoVTwoDeck extends ClassicDeck{
    protected TwoVTwoDeck(){
        super();
        deck.push(new PingCard());
        deck.push(new PingCard());
        deck.push(new PongCard());
        deck.push(new PongCard());
    }
}