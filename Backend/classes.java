import java.util.Collection;
import java.util.Stack;
import java.util.Collections;
import java.util.List;

public class main{
    public static void main(String[] args) {
        Deck deck = new Deck();
        //deck.printDeck();
    }
}

public enum actions{
    none,
    viewOwnCard,
    viewOtherCard,
    exchangeCard,
    viewAllCards,
    removeCard,
    giveCard,
    seeSwap
} 

class Card{
    private int score;
    private boolean inHand, isFlipped;
    private actions action;
    protected Card(int score, boolean inHand, boolean isFlipped, actions action){
        this.score=score;
        this.inHand=inHand;
        this.isFlipped=isFlipped;
        this.action=action;
    }
    protected Card(int score, boolean inHand, boolean isFlipped){
        this(score,inHand,isFlipped,actions.none);
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
    public actions action() {
        return this.action;
    }
    public String cardInfo(){
        return "Score: " + this.score + ", Action: " + this.action; 
    }
}
class Deck{
    Stack<Card> deck = new Stack<>();
    protected Deck(){
        for(int j=1;j<=4;j++){ // 4x cards
            for(int i=1;i<=10;i++){ // regular numbers
                actions action=actions.none;
                if(i==7||i==8)
                    action=actions.viewOwnCard;
                else if(i==9||i==10)
                    action=actions.viewOtherCard;
                deck.push(new Card(i,false,false,action));
            }
            deck.push(new Card(10,false,false,actions.exchangeCard)); //5od we hat
            deck.push(new Card(20,false,false)); // +20
        }
        for(int i=0;i<2;i++){ // 2x cards
            deck.push(new Card(0,false,false)); //  zero
            deck.push(new Card(25,false,false)); // 25 
            deck.push(new Card(10,false,false,actions.viewAllCards)); // ka3b dayer
            deck.push(new Card(10,false,false,actions.removeCard)); // basra
        }
        //1x cards
        deck.push(new Card(-1,false,false)); // -1 
        deck.push(new Card(10,false,false,actions.giveCard)); // 5od bas
        deck.push(new Card(10,false,false,actions.seeSwap)); //see swap
        shuffleDeck();
    }
    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }
    public void printDeck(){ //for testing
        int count=0;
        for(Card card : deck){
            count++;
            System.out.println(card.cardInfo());
        }
        System.out.println("Deck count: " + count);
    }
}

