
import java.util.ArrayList;
import java.util.Random;

public class Dealer {

    public ArrayList<Card> deck;
    public Bot bot;
    Random r = new Random();

    public Dealer() {
        this.deck = new Deck().createDeck();
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

}
