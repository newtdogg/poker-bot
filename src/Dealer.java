
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
        bot.playableHand.add(card1);
        bot.playableHand.add(card2);

    }

    public void dealFlop(Bot bot) {
        for (int i = 3; i <= 5; i++) {
            int index = r.nextInt(this.deck.size() - i);
            Card card = this.deck.get(index);
            this.deck.remove(card);
            this.board.add(card);
            bot.playableHand.add(card);
        }
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
