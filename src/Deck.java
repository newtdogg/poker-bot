import java.util.ArrayList;

public class Deck {
    ArrayList<Card> cards = new ArrayList<Card>();
    public ArrayList<Card> cardsArray;

    Deck() {
        this.cardsArray = cards;
    }
    public ArrayList<Card> createDeck(){
        for(int suit = 0; suit < Suit.values().length; suit++) {
            for(int rank = 0; rank < Rank.values().length; rank++) {
                Card card = new Card(Rank.values()[rank], Suit.values()[suit]);
                this.cardsArray.add(card);
            }
        }
        return this.cardsArray;
    }

}
