import java.util.ArrayList;

public class Player {
    private Hand hand;
    int chips;
    public Evaluator evaluator;

    public Player() {

        this.hand = null;
        this.chips = 100;
        this.evaluator = new Evaluator();
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand newHand) {
        this.hand = newHand;
    }

    public void passHandToEvaluator() {
        this.evaluator.setHand(this.hand);
//        this.evaluator.hand = this.hand;
    }

    public void getBestFive() {
//        System.out.println(this.evaluator.hand);
        passHandToEvaluator();
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();


    }
}
