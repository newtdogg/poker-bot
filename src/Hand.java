import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Hand {

    public ArrayList<Card> holdEm;
    public ArrayList<Card> holdEmArray = new ArrayList<Card>();
    public ArrayList<Card> playableCards;
    public ArrayList<Card> playableCardsArray = new ArrayList<Card>();
    public ArrayList<Card> sortedHighToLow;
    public Hashtable<String, ArrayList<Card>> groupedByRank;
    public Hashtable<String, ArrayList<Card>> groupedBySuit;


    public Hand(Card card1, Card card2){
        this.holdEm = holdEmArray;
        this.playableCards = playableCardsArray;
        playableCards.add(card1);
        playableCards.add(card2);
        holdEm.add(card1);
        holdEm.add(card2);
    }

    public ArrayList<Card> sortHand() {
        sortedHighToLow = playableCards;
        Collections.sort(sortedHighToLow, Card.CardRankComparator);
        return sortedHighToLow;
    }

    public Hashtable<String, ArrayList<Card>> groupByRank(ArrayList<Card> inputHand) {
        createHandByRankHashTable();
        inputCardsIntoByRankHashTable(inputHand);
        sortBySuitInByRank();
        return groupedByRank;
    }

    public Hashtable<String, ArrayList<Card>> groupBySuit(ArrayList<Card> inputHand) {
        createHandBySuitHashTable();
        inputHandIntoBySuitHashtable(inputHand);
        sortByRankInSuitHashTable();
        return groupedBySuit;
    }

    private void createHandByRankHashTable() {
        groupedByRank = new Hashtable<String, ArrayList<Card>>();
        for (int i = 0; i < Rank.values().length; i++) {
            String key = Rank.values()[i].name();
            groupedByRank.put(key, new ArrayList<Card>());
        }
    }

    private void inputCardsIntoByRankHashTable(ArrayList<Card> inputHand) {
        for (int i = 0; i < inputHand.size(); i++) {
            Card card = inputHand.get(i);
            String rank = card.rank.name();
            groupedByRank.get(rank).add(card);
        }
    }

    private void sortBySuitInByRank() {
        for (int i = 0; i < groupedByRank.size(); i++) {
            String rank = Rank.values()[i].name();
            Collections.sort(groupedByRank.get(rank), Card.CardSuitComparator);
        }
    }

    private void createHandBySuitHashTable() {
        groupedBySuit = new Hashtable<String, ArrayList<Card>>();
        for (int i = 0; i < Suit.values().length; i++) {
            String key = Suit.values()[i].name();
            groupedBySuit.put(key, new ArrayList<Card>());
        }
    }
    //
    private void inputHandIntoBySuitHashtable(ArrayList<Card> inputHand) {
        for (int i = 0; i < inputHand.size(); i++) {
            Card card = inputHand.get(i);
            String suit = card.suit.name();
            groupedBySuit.get(suit).add(card);
        }
    }

    private void sortByRankInSuitHashTable(){
        for (int i = 0; i < groupedBySuit.size(); i++) {
            String suit = Suit.values()[i].name();
            Collections.sort(groupedBySuit.get(suit), Card.CardRankComparator);
        }
    }
}