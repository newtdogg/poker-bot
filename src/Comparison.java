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

    public void compareHands() {

        bot1.passHandToEvaluator();
        bot2.passHandToEvaluator();

        this.bot1.evaluator.categoriseAvailableHands();
        this.bot2.evaluator.categoriseAvailableHands();

        if (this.bot1.evaluator.typeOfBestHand() == "PAIR" && this.bot1.evaluator.typeOfBestHand() == "PAIR") {
            compareKickers();
        } else if (this.bot1.evaluator.typeOfBestHand() == "TWOPAIR" && this.bot1.evaluator.typeOfBestHand() == "TWOPAIR") {
            compareKickers();
        } else if (this.bot1.evaluator.typeOfBestHand() == "THREEOFAKIND" && this.bot1.evaluator.typeOfBestHand() == "THREEOFAKIND") {
            compareKickers();
        } else if (this.bot1.evaluator.typeOfBestHand() == "FOUROFAKIND" && this.bot1.evaluator.typeOfBestHand() == "FOUROFAKIND") {
            compareKickers();
        }
    }

    public void compareKickers() {
        int highestKicker
    }
}
