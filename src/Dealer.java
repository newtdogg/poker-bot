
import java.util.ArrayList;
import java.util.Random;

public class Dealer {

    public ArrayList<Card> deck;
    public ArrayList<Card> board;
    public Bot bot;
    Random r = new Random();

    public Dealer() {
        this.deck = new Deck().createDeck();
        this.board = new ArrayList<Card>();
    }

    public void dealCards(Bot bot){
        int index1 = r.nextInt(this.deck.size() - 1);
        int index2 = r.nextInt(this.deck.size() - 2);
        Card card1 = this.deck.get(index1);
        this.deck.remove(card1);
        bot.hand.add(card1);
        Card card2 = this.deck.get(index2);
        this.deck.remove(card2);
        bot.hand.add(card2);
    }

    public void dealFlop(Bot bot) {
        int index1 = r.nextInt(this.deck.size() - 3);
        int index2 = r.nextInt(this.deck.size() - 4);
        int index3 = r.nextInt(this.deck.size() - 5);
        Card card1 = this.deck.get(index1);
        this.deck.remove(card1);
        this.board.add(card1);
        bot.playableHand.add(card1);
        Card card2 = this.deck.get(index2);
        this.deck.remove(card2);
        this.board.add(card2);
        bot.playableHand.add(card2);
        Card card3 = this.deck.get(index3);
        this.deck.remove(card3);
        this.board.add(card3);
        bot.playableHand.add(card3);
    }

    public void dealTurn(Bot bot){
        int index1 = r.nextInt(this.deck.size() - 6);
        Card card1 = this.deck.get(index1);
        this.deck.remove(card1);
        this.board.add(card1);
        bot.playableHand.add(card1);
    }

    public void dealRiver(Bot bot){
        int index1 = r.nextInt(this.deck.size() - 7);
        Card card1 = this.deck.get(index1);
        this.deck.remove(card1);
        this.board.add(card1);
        bot.playableHand.add(card1);
    }

}
