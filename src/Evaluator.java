import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

public class Evaluator {

    public ArrayList<Card> hand;
    public ArrayList<Card> sortedHand;
    public Hashtable<String, ArrayList<Card>> groupByRank;
    public Hashtable<String, ArrayList<Card>> groupBySuit;

    private ArrayList<Card> sortHand() {
        sortedHand = hand;
        Collections.sort(sortedHand, Card.CardRankComparator);
        return sortedHand;
    }

    public Hashtable<String, ArrayList<Card>> handByRank(ArrayList<Card> inputHand) {
        createHandByRankHashTable();
        inputCardsIntoByRankHashTable(inputHand);
        sortBySuitInByRank();
        return groupByRank;
    }

    private void createHandByRankHashTable() {
        groupByRank = new Hashtable<String, ArrayList<Card>>();
        for (int i = 0; i < Rank.values().length; i++) {
            String key = Rank.values()[i].name();
            groupByRank.put(key, new ArrayList<Card>());
        }
    }

    private void inputCardsIntoByRankHashTable(ArrayList<Card> inputHand) {
        for (int i = 0; i < inputHand.size(); i++) {
            Card card = inputHand.get(i);
            String rank = card.rank.name();
            groupByRank.get(rank).add(card);
        }
    }

    private void sortBySuitInByRank() {
        for (int i = 0; i < groupByRank.size(); i++) {
            String rank = Rank.values()[i].name();
            Collections.sort(groupByRank.get(rank), Card.CardSuitComparator);
        }
    }

    public Hashtable<String, ArrayList<Card>> handBySuit(ArrayList<Card> inputHand) {
        createHandBySuitHashTable();
        inputHandIntoBySuitHashtable(inputHand);
        sortByRankInSuitHashTable();
        return groupBySuit;
    }

    private void createHandBySuitHashTable() {
        groupBySuit = new Hashtable<String, ArrayList<Card>>();
        for (int i = 0; i < Suit.values().length; i++) {
            String key = Suit.values()[i].name();
            groupBySuit.put(key, new ArrayList<Card>());
        }
    }

    private void inputHandIntoBySuitHashtable(ArrayList<Card> inputHand) {
        for (int i = 0; i < inputHand.size(); i++) {
            Card card = inputHand.get(i);
            String suit = card.suit.name();
            groupBySuit.get(suit).add(card);
        }
    }

    private void sortByRankInSuitHashTable(){
        for (int i = 0; i < groupBySuit.size(); i++) {
            String suit = Suit.values()[i].name();
            Collections.sort(groupBySuit.get(suit), Card.CardRankComparator);
        }
    }


    public Card highCard(){
        Collections.sort(hand, Card.CardRankComparator);
        return hand.get(0);
    }

    public boolean pair(){
        handByRank(hand);
        for (int i = groupByRank.size()-1; i >= 0; --i) {
            String key = Rank.values()[i].name();
            if (groupByRank.get(key).size() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean twoPair() {
        handByRank(hand);
        int pairCount = 0;
        for (int i = groupByRank.size()-1; i >= 0; --i) {
            String key = Rank.values()[i].name();
            if (groupByRank.get(key).size() == 2) {
                pairCount += 1;
            }
        }
        return pairCount == 2;
    }

    public boolean threeOfAKind(){
        handByRank(hand);
        for (int i = groupByRank.size()-1; i >= 0; --i) {
            String key = Rank.values()[i].name();
            if (groupByRank.get(key).size() == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean highStraight(){
        sortHand();
        int highestCardOrdinal = sortedHand.get(0).rank.ordinal();
        int counter = 0;
        for (int j = 1; j < 5; j++) {
            for (int i = 1; i < sortedHand.size(); i++) {
                 if(highestCardOrdinal - j == sortedHand.get(i).rank.ordinal()) {
                     counter += 1;
                 }
            }
        }
        return counter == 4;
    }

    public boolean flush(){
        handBySuit(hand);

        for (int i = 0; i < groupBySuit.size(); i++){
            String key = Suit.values()[i].name();
            if (groupBySuit.get(key).size() >= 4){
                return true;
            }
        }
        return false;
    }

    public boolean fullHouse() {
        handByRank(hand);
        if (threeOfAKind() && pair()) {
            return true;
        }
        return false;
    }

    public boolean fourOfAKind(){
        handByRank(hand);
        for (int i = groupByRank.size()-1; i >= 0; --i) {
            String key = Rank.values()[i].name();
            if (groupByRank.get(key).size() == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean highestPair(){

//        // descending sort
//        for (int i = 0; i < hand.size(); i++) {
//            if(Rank.valueOf(hand.get(i).rank.name()).ordinal() < Rank.valueOf(hand.get(i + 1).rank.name()).ordinal()) {
//                temp = Rank.valueOf(hand.get(i).rank.name());
//            }
//        }

        int comp = 0;
        for (int i = 0; i < hand.size(); i++) {
            comp = Rank.valueOf(hand.get(i).rank.name()).ordinal();
            for (int j = i + 1; j < hand.size(); j++) {
                if(comp == Rank.valueOf(hand.get(j).rank.name()).ordinal()) {
                    return true;
                }
            }
        }
        return false;
    }

}