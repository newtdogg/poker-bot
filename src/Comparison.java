import java.util.ArrayList;

public class Comparison {
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


        if ( compare() == 1 ) {
            return this.bot1;
        } else if ( compare() == 2 ) {
            return this.bot2;
        }
        return null;
    }

    private int compare() {
        for (int i = 0; i < this.bot1.evaluator.hand.bestFiveCards.size(); i++) {
            int bot1Rank = this.bot1.evaluator.hand.bestFiveCards.get(i).rank.ordinal();
            int bot2Rank = this.bot2.evaluator.hand.bestFiveCards.get(i).rank.ordinal();
            if ( bot1Rank > bot2Rank ) {
                return 1;
            } else if( i == this.bot1.evaluator.hand.bestFiveCards.size()-1 && bot1Rank == bot2Rank) {
                return 0;
            }
        }
        return 2;
    }
}
