import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Evaluator {

    public ArrayList<Card> hand;
    public Hashtable<String, ArrayList<Card>> groupByRank;
    public Hashtable<String, ArrayList<Card>> groupBySuit;

    public Hashtable<String, ArrayList<Card>> handByRank(ArrayList<Card> inputHand) {
        groupByRank = new Hashtable<String, ArrayList<Card>>();

        for (int i = 0; i < Rank.values().length; i++) {
            String key = Rank.values()[i].name();
            groupByRank.put(key, new ArrayList<Card>());
        }

        Collections.sort(inputHand, Card.CardRankComparator);

        for (int i = 0; i < inputHand.size(); i++) {
            String rank = inputHand.get(i).rank.name();
            groupByRank.get(rank).add(inputHand.get(i));
        }
        
//        THIS BIT WOULD SORT BY SUIT, LEAVING UNSORTED FOR NOW
//
//        for (int i = 0; i < groupByRank.size(); i++) {
//            String rank = inputHand.get(i).rank.name();
//            groupByRank.get(rank).add(inputHand.get(i));
//        }

        return groupByRank;
    }

    public Hashtable<String, ArrayList<Card>> handBySuit(ArrayList<Card> inputHand) {
        groupBySuit = new Hashtable<String, ArrayList<Card>>();

        for (int i = 0; i < Suit.values().length; i++) {
            String key = Suit.values()[i].name();
            groupBySuit.put(key, new ArrayList<Card>());
        }

//        Collections.sort(inputHand, Card.CardRankComparator);

        for (int i = 0; i < inputHand.size(); i++) {
            String suit = inputHand.get(i).suit.name();
            groupBySuit.get(suit).add(inputHand.get(i));
        }

        return groupBySuit;
    }


    public Card highCard(){
        Collections.sort(hand, Card.CardRankComparator);
        return hand.get(0);
    }

    public boolean pair(){

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