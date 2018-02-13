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

    public boolean compareHands() {

        this.bot1.passHandToEvaluator();
        this.bot2.passHandToEvaluator();

        this.bot1.evaluator.categoriseAvailableHands();
        this.bot2.evaluator.categoriseAvailableHands();

        this.bot1.evaluator.selectBestFiveCards();
        this.bot2.evaluator.selectBestFiveCards();

        if (this.bot1.evaluator.typeOfBestHand() == "PAIR" && this.bot1.evaluator.typeOfBestHand() == "PAIR") {
            if(this.bot1.evaluator.hand.bestFiveCards.get(2).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(2).rank.ordinal()) {
                return true;
            }
        } else if (this.bot1.evaluator.typeOfBestHand() == "TWOPAIR" && this.bot1.evaluator.typeOfBestHand() == "TWOPAIR") {
            if(this.bot1.evaluator.hand.bestFiveCards.get(4).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(4).rank.ordinal()) {
                return true;
            }
        } else if (this.bot1.evaluator.typeOfBestHand() == "THREEOFAKIND" && this.bot1.evaluator.typeOfBestHand() == "THREEOFAKIND") {
            if(this.bot1.evaluator.hand.bestFiveCards.get(3).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(3).rank.ordinal()) {
                return true;
            }
        } else if (this.bot1.evaluator.typeOfBestHand() == "FOUROFAKIND" && this.bot1.evaluator.typeOfBestHand() == "FOUROFAKIND") {
            if(this.bot1.evaluator.hand.bestFiveCards.get(4).rank.ordinal() > this.bot2.evaluator.hand.bestFiveCards.get(4).rank.ordinal()) {
                return true;
            }
        }
        return false;
    }


}
