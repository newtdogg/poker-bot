import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

public class Evaluator {

    public Hashtable<String, ArrayList<Card>> allAvailableHands;
    public Hand hand;

    public Evaluator(){
        this.hand = null;
    }

    public Card highCard(){
        Collections.sort(hand.playableCards, Card.CardRankComparator);
        return hand.playableCards.get(0);
    }

    public boolean pair(Hand hand){
        hand.groupByRank(hand.playableCards);
        for (int i = hand.groupedByRank.size()-1; i >= 0; --i) {
            String key = Rank.values()[i].name();
            if (hand.groupedByRank.get(key).size() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean twoPair(Hand hand) {
        hand.groupByRank(hand.playableCards);
        int pairCount = 0;
        for (int i = hand.groupedByRank.size()-1; i >= 0; --i) {
            String key = Rank.values()[i].name();
            if (hand.groupedByRank.get(key).size() == 2) {
                pairCount += 1;
            }
        }
        return pairCount == 2;
    }

    public boolean threeOfAKind(Hand hand){
        hand.groupByRank(hand.playableCards);
        for (int i = hand.groupedByRank.size()-1; i >= 0; --i) {
            String key = Rank.values()[i].name();
            if (hand.groupedByRank.get(key).size() == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean straight(Hand hand){
        for (int n = 0; n < 3; n++) {
            hand.sortHand();
            int highestCardOrdinal = hand.sortedHighToLow.get(n).rank.ordinal();
            int counter = 1;
            for (int i = 1; i < hand.sortedHighToLow.size(); i++) {
                if(highestCardOrdinal - counter == hand.sortedHighToLow.get(i).rank.ordinal()) {
                    counter += 1;
                }
            }
            System.out.println(counter);
            if (counter == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean aceLowStraight(Hand hand) {
        hand.sortHand();
        int highestCardOrdinal = 0;
        for(int n = 0; n < hand.sortedHighToLow.size(); n++) {
            if(hand.sortedHighToLow.get(n).rank.ordinal() == 3){
                highestCardOrdinal = hand.sortedHighToLow.get(n).rank.ordinal();
            }
        }

        if(hand.sortedHighToLow.get(0).rank == Rank.ACE) {
            int counter = 1;
            for (int i = 0; i < hand.sortedHighToLow.size(); i++) {
                if (highestCardOrdinal - counter == hand.sortedHighToLow.get(i).rank.ordinal()) {
                    counter += 1;
                }
            }
            return counter == 4;
        }
        else {
            return false;
        }
    }

    public boolean flush(Hand hand){
        hand.groupBySuit(hand.playableCards);

        for (int i = 0; i < hand.groupedBySuit.size(); i++){
            String key = Suit.values()[i].name();
            if (hand.groupedBySuit.get(key).size() >= 4){
                return true;
            }
        }
        return false;
    }

    public boolean fullHouse(Hand hand) {
        hand.groupByRank(hand.playableCards);
        if (threeOfAKind(hand) && pair(hand)) {
            return true;
        }
        return false;
    }

    public boolean fourOfAKind(Hand hand){
        hand.groupByRank(hand.playableCards);
        for (int i = hand.groupedByRank.size()-1; i >= 0; --i) {
            String key = Rank.values()[i].name();
            if (hand.groupedByRank.get(key).size() == 4) {
                return true;
            }
        }
        return false;
    }

    public void categoriseAvailableHands() {
        createAllAvailableHandsHashTable();

        ////////////////////////////////////////////////////////////
        //   also need to do this from royal flush down to pair   //
        ////////////////////////////////////////////////////////////

        if (pair(this.hand)) {
            addPairToAllAvailableHands();
        }
        if (threeOfAKind(this.hand)) {
            addThreeOfAKindToAllAvailableHands();
        }
        if (fullHouse(this.hand)) {
            addFullHouseToAllAvailableHands();
        }
    }

    private void addPairToAllAvailableHands() {
        int sizeOfPlayableCards = this.hand.playableCards.size();
        for (int i = 0; i < sizeOfPlayableCards; i++) {
            Card card = this.hand.playableCards.get(i);
            String typeOfHand = WinningHands.PAIR.toString();
            allAvailableHands.get(typeOfHand).add(card);
        }
    }

    private void addThreeOfAKindToAllAvailableHands() {
        int sizeOfPlayableCards = this.hand.playableCards.size();
        for (int i = 0; i < sizeOfPlayableCards; i++) {
            Card card = this.hand.playableCards.get(i);
            String typeOfHand = WinningHands.THREEOFAKIND.toString();
            allAvailableHands.get(typeOfHand).add(card);
        }
    }

    private void addFullHouseToAllAvailableHands() {
        int sizeOfPlayableCards = this.hand.playableCards.size();
        for (int i = 0; i < sizeOfPlayableCards; i++) {
            Card card = this.hand.playableCards.get(i);
            String typeOfHand = WinningHands.FULLHOUSE.toString();
            allAvailableHands.get(typeOfHand).add(card);
        }
    }

    public void createAllAvailableHandsHashTable(){
        allAvailableHands = new Hashtable<>();
        for (int i = 0; i < WinningHands.values().length; i++) {
            String key = WinningHands.values()[i].name();
            System.out.println(key);
            allAvailableHands.put(key, new ArrayList<Card>());
        }
    }

}