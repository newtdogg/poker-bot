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

        if (this.bot1.evaluator.typeOfBestHand() == "PAIR" && this.bot2.evaluator.typeOfBestHand() == "PAIR") {
            for (int i = 2; i < bot1.evaluator.hand.bestFiveCards.size(); i++) {
                if (this.bot1.evaluator.hand.bestFiveCards.get(i).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(i).rank.ordinal()) {
                    return this.bot1;
                }
            }
            return this.bot2;
        } else if (this.bot1.evaluator.typeOfBestHand() == "TWOPAIR" && this.bot2.evaluator.typeOfBestHand() == "TWOPAIR") {
            for (int i = 4; i < bot1.evaluator.hand.bestFiveCards.size(); i++) {
                if (this.bot1.evaluator.hand.bestFiveCards.get(i).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(i).rank.ordinal()) {
                    return this.bot1;
                }
            }
            return this.bot2;
        } else if (this.bot1.evaluator.typeOfBestHand() == "THREEOFAKIND" && this.bot2.evaluator.typeOfBestHand() == "THREEOFAKIND") {
            for (int i = 3; i < bot1.evaluator.hand.bestFiveCards.size(); i++) {
                if (this.bot1.evaluator.hand.bestFiveCards.get(i).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(i).rank.ordinal()) {
                    return this.bot1;
                }
            }
            return this.bot2;
        } else if (this.bot1.evaluator.typeOfBestHand() == "FOUROFAKIND" && this.bot2.evaluator.typeOfBestHand() == "FOUROFAKIND") {
            for (int i = 4; i < bot1.evaluator.hand.bestFiveCards.size(); i++) {
                if (this.bot1.evaluator.hand.bestFiveCards.get(i).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(i).rank.ordinal()) {
                    return this.bot1;
                }
            }
            return this.bot2;
        }
        return null;
    }


}
