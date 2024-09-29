import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        System.out.println(".");

        Deck deck = new ClassicDeck();
        deck.shuffleDeck();
        // deck.printDeck();

        // System.out.println(deck.drawCard().cardInfo());

        Hand hand = new Hand();
        hand.initializeHand("Bigo", deck);
        hand.printHand();
        System.out.println(hand.getScore());
    }
}
enum Mode{
    Classic,
    Haramy,
    TwoVTwo;
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
    protected Stack<Card> playedPile;

    protected Deck() {
        deck = new Stack<>();
        playedPile = new Stack<>();
        initializeDeck(); 
    }

    protected abstract void initializeDeck();

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }
    public Card drawCard(){
        if(!deck.isEmpty())
        {
            return deck.pop();
        }
        return null;
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

class Hand{
    protected List<Card> cards;
    protected String playerID;
    protected void initializeHand(String playerID, Deck deck)
    {
        cards= new ArrayList<>();
        this.playerID = playerID;
        cards.add(deck.drawCard());
        cards.add(deck.drawCard());
        cards.add(deck.drawCard());
        cards.add(deck.drawCard());
    }
    public void printHand() {
        System.out.println(playerID+"'s Hand:");
        for (Card card : cards) {
            System.out.println(card.cardInfo());  
        }
    }
    public int getScore(){
        int score = 0;
        for(Card card: cards){
            score += card.getScore();
        }
        return score;
    }
}

abstract class Game {
    protected Deck gameDeck;       
    protected int numberOfPlayers;    
    protected List<Hand> playerHands;  
    protected int turnId;      
    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.gameDeck.initializeDeck();
        this.playerHands = new ArrayList<>();
        this.turnId = 0;  
    }
    protected void dealHands(){
        for (int i = 0; i < numberOfPlayers; i++) {
            Hand hand = new Hand();
            hand.initializeHand(""+i, gameDeck);
            playerHands.add(hand);
        }
    }
    public Deck getGameDeck() {
        return gameDeck;
    }
    public Hand getPlayerHand() {
        return playerHands.get(turnId);
    }
    public Hand getPlayerHand(int PlayerId) {
        return playerHands.get(PlayerId);
    }
    public void nextTurn() {
        turnId = (turnId + 1) % numberOfPlayers;
    }
    public void printAllHands() {
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Player "+i+"'s hand:");
            playerHands.get(i).printHand();
            System.out.println();
        }
    }
}
class ClassicGame extends Game {
    public ClassicGame(int numberOfPlayers) {
        super(numberOfPlayers);
        this.gameDeck = new ClassicDeck(); 
        this.gameDeck.initializeDeck();
        dealHands();
    }
}
class HaramyGame extends Game {
    public HaramyGame(int numberOfPlayers) {
        super(numberOfPlayers);
        this.gameDeck = new HaramyDeck(); 
        this.gameDeck.initializeDeck();
        dealHands();
    }
}
class TwoVTwoGame extends Game {
    public TwoVTwoGame(int numberOfPlayers) {
        super(numberOfPlayers);
        this.gameDeck = new TwoVTwoDeck(); 
        this.gameDeck.initializeDeck();
        dealHands();
    }
}

abstract class Room{
    String roomId;
    long hostSessionId;
    int numberOfPlayers;
    Mode mode ;
    Game game;

    protected Room(String roomId, long hostSessionId, int numberOfPlayers, Mode mode) {
        this.roomId = roomId;
        this.hostSessionId = hostSessionId;
        this.numberOfPlayers = numberOfPlayers;
        this.mode = mode;

        switch (mode) {
            case Classic -> this.game = new ClassicGame(numberOfPlayers);
            case Haramy -> this.game = new HaramyGame(numberOfPlayers);
            case TwoVTwo -> this.game = new TwoVTwoGame(numberOfPlayers);
            default -> throw new IllegalArgumentException("Unexpected mode: " + mode);
        }
    }
}