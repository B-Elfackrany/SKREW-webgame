package cardgame.cards;

public abstract class Card {

    private int score;
    private boolean inHand, isFlipped;

    protected Card(int score, boolean inHand, boolean isFlipped) {
        this.score = score;
        this.inHand = inHand;
        this.isFlipped = isFlipped;
    }

    protected Card(int score) {
        this(score, false, false);
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