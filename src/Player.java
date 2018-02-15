import java.util.ArrayList;

public class Player {
    public Hand hand;
    int chips;
    public Evaluator evaluator;

    public Player() {

        this.hand = null;
        this.chips = 1000;
        this.evaluator = new Evaluator();
    }

    public void passHandToEvaluator() {
        this.evaluator.hand = this.hand;
    }

    public void getBestFive() {
//        System.out.println(this.evaluator.hand);
        passHandToEvaluator();
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();


    }
}
