import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;

public class Comparison {

    ArrayList<Card> hand1, hand2;
    String besthand1, besthand2;
    Bot bot1, bot2;

    Comparison(Bot bot1, Bot bot2) {
        this.bot1 = bot1;
        this.bot2 = bot2;
    }

    public Bot compareHands() {

        this.bot1.passHandToEvaluator();
        this.bot2.passHandToEvaluator();

        this.bot1.evaluator.categoriseAvailableHands();
        this.bot2.evaluator.categoriseAvailableHands();

        this.bot1.evaluator.selectBestFiveCards();
        this.bot2.evaluator.selectBestFiveCards();

        String bot1BestHand = this.bot1.evaluator.typeOfBestHand();
        String bot2BestHand = this.bot2.evaluator.typeOfBestHand();

        System.out.println(bot1BestHand);
        System.out.println(bot2BestHand);

        System.out.println(bot1BestHand == "HIGHCARD" && bot2BestHand == "HIGHCARD");

        if (bot1BestHand == "HIGHCARD" && bot2BestHand == "HIGHCARD") {
            if ( compareHighCard() == 1 ) {
                return this.bot1;
            } else if ( compareHighCard() == 2 ) {
                return this.bot2;
            }
        }
//      else if (bot1BestHand == "PAIR" && bot2BestHand == "PAIR") {
//            for (int i = 2; i < bot1.evaluator.hand.bestFiveCards.size(); i++) {
//                if (this.bot1.evaluator.hand.bestFiveCards.get(i).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(i).rank.ordinal()) {
//                    return this.bot1;
//                }
//            }
//            return this.bot2;
//        } else if (bot1BestHand == "TWOPAIR" && bot2BestHand == "TWOPAIR") {
//            for (int i = 4; i < bot1.evaluator.hand.bestFiveCards.size(); i++) {
//                if (this.bot1.evaluator.hand.bestFiveCards.get(i).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(i).rank.ordinal()) {
//                    return this.bot1;
//                }
//            }
//            return this.bot2;
//        } else if (bot1BestHand == "THREEOFAKIND" && bot2BestHand == "THREEOFAKIND") {
//            for (int i = 3; i < bot1.evaluator.hand.bestFiveCards.size(); i++) {
//                if (this.bot1.evaluator.hand.bestFiveCards.get(i).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(i).rank.ordinal()) {
//                    return this.bot1;
//                }
//            }
//            return this.bot2;
//        } else if (bot1BestHand == "FOUROFAKIND" && bot2BestHand == "FOUROFAKIND") {
//            for (int i = 4; i < bot1.evaluator.hand.bestFiveCards.size(); i++) {
//                if (this.bot1.evaluator.hand.bestFiveCards.get(i).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(i).rank.ordinal()) {
//                    return this.bot1;
//                }
//            }
//            return this.bot2;
//        }
        return null;
    }

    public int compareHighCard() {
        for (int i = 0; i < this.bot1.evaluator.hand.bestFiveCards.size(); i++) {
            int bot1Rank = this.bot1.evaluator.hand.bestFiveCards.get(i).rank.ordinal();
            int bot2Rank = this.bot2.evaluator.hand.bestFiveCards.get(i).rank.ordinal();
            if ( bot1Rank > bot2Rank ) {
                return 1;
            } else if( i == this.bot1.evaluator.hand.bestFiveCards.size()-1 && !(bot1Rank > bot2Rank) ) {
                return 0;
            }
        }
        return 2;
    }

}
