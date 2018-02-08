import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

public class Evaluator {

    public ArrayList<Card> sortedHand;
    public Hashtable<String, ArrayList<Card>> groupByRank;
    public Hashtable<String, ArrayList<Card>> groupBySuit;
    public Hand hand;

    public Evaluator(){
        this.hand = null;
    }

    public Card highCard(){
        Collections.sort(hand.playableCards, Card.CardRankComparator);
        return hand.playableCards.get(0);
    }

    public boolean pair(){
        hand.groupByRank(hand.playableCards);
        for (int i = groupByRank.size()-1; i >= 0; --i) {
            String key = Rank.values()[i].name();
            if (groupByRank.get(key).size() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean twoPair() {
        hand.groupByRank(hand.playableCards);
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
        hand.groupByRank(hand.playableCards);
        for (int i = groupByRank.size()-1; i >= 0; --i) {
            String key = Rank.values()[i].name();
            if (groupByRank.get(key).size() == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean highStraight(){
        hand.sortHand();
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

    public boolean mediumStraight() {
        hand.sortHand();
        int secondHighestCardOrdinal = sortedHand.get(1).rank.ordinal();
        int counter = 0;
        for (int j = 1; j < 5; j++) {
            for (int i = 1; i < sortedHand.size(); i++) {
                if(secondHighestCardOrdinal - j == sortedHand.get(i).rank.ordinal()) {
                    counter += 1;
                }
            }
        }
        System.out.println(counter);
        return counter == 4;
    }

    public boolean lowStraight() {
        hand.sortHand();
        int thirdHighestCardOrdinal = sortedHand.get(2).rank.ordinal();
        int counter = 0;
        for (int j = 1; j < 5; j++) {
            for (int i = 1; i < sortedHand.size(); i++) {
                if(thirdHighestCardOrdinal - j == sortedHand.get(i).rank.ordinal()) {
                    counter += 1;
                }
            }
        }
        System.out.println(counter);
        return counter == 4;
    }

    public boolean aceLowStraight() {
        hand.sortHand();
        int thirdHighestCardOrdinal = sortedHand.get(3).rank.ordinal();
        int counter = 0;
        for (int j = 1; j < 4; j++) {
            for (int i = 1; i < sortedHand.size(); i++) {
                if(thirdHighestCardOrdinal - j == sortedHand.get(i).rank.ordinal()) {
                    counter += 1;
                }
            }
        }
        System.out.println(counter);
        return counter == 3 && sortedHand.get(0).rank == Rank.ACE;
    }

    public boolean flush(){
        hand.groupBySuit(hand.playableCards);

        for (int i = 0; i < groupBySuit.size(); i++){
            String key = Suit.values()[i].name();
            if (groupBySuit.get(key).size() >= 4){
                return true;
            }
        }
        return false;
    }

    public boolean fullHouse() {
        hand.groupByRank(hand.playableCards);
        if (threeOfAKind() && pair()) {
            return true;
        }
        return false;
    }

    public boolean fourOfAKind(){
        hand.groupByRank(hand.playableCards);
        for (int i = groupByRank.size()-1; i >= 0; --i) {
            String key = Rank.values()[i].name();
            if (groupByRank.get(key).size() == 4) {
                return true;
            }
        }
        return false;
    }

//    public boolean highestPair(){
//
//        // descending sort
//        for (int i = 0; i < hand.size(); i++) {
//            if(Rank.valueOf(hand.get(i).rank.name()).ordinal() < Rank.valueOf(hand.get(i + 1).rank.name()).ordinal()) {
//                temp = Rank.valueOf(hand.get(i).rank.name());
//            }
//        }
//
//        int comp = 0;
//        for (int i = 0; i < hand.size(); i++) {
//            comp = Rank.valueOf(hand.get(i).rank.name()).ordinal();
//            for (int j = i + 1; j < hand.size(); j++) {
//                if(comp == Rank.valueOf(hand.get(j).rank.name()).ordinal()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

}