import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
public class Dealer {
    public ArrayList<Card> deck;
    public ArrayList<Card> board;
    public Hashtable<String, Character> newSuitSymbol = new Hashtable<String, Character>();
    public Hashtable suitSymbol;
    public Hashtable<String, String> newRankSymbol = new Hashtable<String, String>();
    public Hashtable rankSymbol;
    Random r = new Random();

    public Dealer() {
        this.deck = new Deck().createDeck();
        this.board = new ArrayList<Card>();
        this.suitSymbol = newSuitSymbol;
        this.rankSymbol = newRankSymbol;
    }

    public void dealHand(Bot bot, Player player){
        int index1 = r.nextInt(this.deck.size() - 1);
        Card card1 = this.deck.get(index1);
        this.deck.remove(card1);
        int index2 = r.nextInt(this.deck.size() - 2);
        Card card2 = this.deck.get(index2);
        this.deck.remove(card2);
        int index3 = r.nextInt(this.deck.size() - 3);
        Card card3 = this.deck.get(index3);
        this.deck.remove(card3);
        int index4 = r.nextInt(this.deck.size() - 4);
        Card card4 = this.deck.get(index4);
        this.deck.remove(card4);
        Hand handa = new Hand(card1, card2);
        Hand handb = new Hand(card3, card4);
        bot.setHand(handa);
        player.setHand(handb);
    }

    public void dealFlop(Bot bot, Player player) {
        for (int i = 7; i <= 9; i++) {
            int index = r.nextInt(this.deck.size() - i);
            Card card = this.deck.get(index);
            this.deck.remove(card);
            this.board.add(card);
            bot.getHand().getPlayableCards().add(card);
            player.getHand().getPlayableCards().add(card);
        }
    }

    public void dealTurn(Bot bot, Player player){
        int index = r.nextInt(this.deck.size() - 10);
        Card card = this.deck.get(index);
        this.deck.remove(card);
        this.board.add(card);
        bot.getHand().getPlayableCards().add(card);
        player.getHand().getPlayableCards().add(card);
    }

    public void dealRiver(Bot bot, Player player){
        int index = r.nextInt(this.deck.size() - 11);
        Card card = this.deck.get(index);
        this.deck.remove(card);
        this.board.add(card);
        bot.getHand().getPlayableCards().add(card);
        player.getHand().getPlayableCards().add(card);
    }

    public void generateSuitSymbols() {
        newSuitSymbol.put("HEART", '\u2665');
        newSuitSymbol.put("DIAMOND", '\u2666');
        newSuitSymbol.put("SPADE", '\u2660');
        newSuitSymbol.put("CLUB", '\u2663');
    }

    public void generateRankSymbols() {
        newRankSymbol.put("ACE", "A");
        newRankSymbol.put("TWO", "2");
        newRankSymbol.put("THREE", "3");
        newRankSymbol.put("FOUR", "4");
        newRankSymbol.put("FIVE", "5");
        newRankSymbol.put("SIX", "6");
        newRankSymbol.put("SEVEN", "7");
        newRankSymbol.put("EIGHT", "8");
        newRankSymbol.put("NINE", "9");
        newRankSymbol.put("TEN", "10");
        newRankSymbol.put("JACK", "J");
        newRankSymbol.put("QUEEN", "Q");
        newRankSymbol.put("KING", "K");
    }

}
