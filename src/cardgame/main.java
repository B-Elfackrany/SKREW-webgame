package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import cardgame.cards.*;
import cardgame.cards.actioncards.*;
import cardgame.enums.*;
import cardgame.decks.*;
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

    protected void dealHands() {
        for (int i = 0; i < numberOfPlayers; i++) {
            Hand hand = new Hand();
            hand.initializeHand("" + i, gameDeck);
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
            System.out.println("Player " + i + "'s hand:");
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

abstract class Room {

    String roomId;
    long hostSessionId;
    int numberOfPlayers;
    gameMode mode;
    Game game;

    protected Room(String roomId, long hostSessionId, int numberOfPlayers, gameMode mode) {
        this.roomId = roomId;
        this.hostSessionId = hostSessionId;
        this.numberOfPlayers = numberOfPlayers;
        this.mode = mode;

        switch (mode) {
            case Classic ->
                this.game = new ClassicGame(numberOfPlayers);
            case Haramy ->
                this.game = new HaramyGame(numberOfPlayers);
            case TwoVTwo ->
                this.game = new TwoVTwoGame(numberOfPlayers);
            default ->
                throw new IllegalArgumentException("Unexpected mode: " + mode);
        }
    }
}
