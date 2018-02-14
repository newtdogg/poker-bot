import java.util.ArrayList;

public class Comparison {
    Bot bot1, bot2;

    Comparison(Bot bot1, Bot bot2) {
        this.bot1 = bot1;
        this.bot2 = bot2;
    }

    public String compareHands() {

        this.bot1.passHandToEvaluator();
        this.bot2.passHandToEvaluator();

        this.bot1.evaluator.categoriseAvailableHands();
        this.bot2.evaluator.categoriseAvailableHands();

        this.bot1.evaluator.selectBestFiveCards();
        this.bot2.evaluator.selectBestFiveCards();

        String bot1BestHand = this.bot1.evaluator.typeOfBestHand();
        String bot2BestHand = this.bot2.evaluator.typeOfBestHand();

        int bot1best = WinningHands.valueOf(bot1BestHand).ordinal();
        int bot2best = WinningHands.valueOf(bot2BestHand).ordinal();

        String win1 = "Bot 1 wins!";
        String win2 = "Bot 2 wins!";

        if (bot1best == bot2best) {
            return compareSameTypeHands();
        } else if (bot1best > bot2best) {
            return win1;
        } else {
            return win2;
        }
    }

    public String compareSameTypeHands() {

        this.bot1.passHandToEvaluator();
        this.bot2.passHandToEvaluator();

        this.bot1.evaluator.categoriseAvailableHands();
        this.bot2.evaluator.categoriseAvailableHands();

        this.bot1.evaluator.selectBestFiveCards();
        this.bot2.evaluator.selectBestFiveCards();

        String bot1BestHand = this.bot1.evaluator.typeOfBestHand();
        String bot2BestHand = this.bot2.evaluator.typeOfBestHand();

//        System.out.println(bot1BestHand);
//        System.out.println(bot2BestHand);

        String draw = "It's a draw!";


        Boolean highCard = (bot1BestHand == "HIGHCARD" && bot2BestHand == "HIGHCARD");
        Boolean pair = (bot1BestHand == "PAIR" && bot2BestHand == "PAIR");
        Boolean twoPair = (bot1BestHand == "TWOPAIR" && bot2BestHand == "TWOPAIR");
        Boolean threeOf = (bot1BestHand == "THREEOFAKIND" && bot2BestHand == "THREEOFAKIND");
        Boolean fullHouse = (bot1BestHand == "FULLHOUSE" && bot2BestHand == "FULLHOUSE");
        Boolean fourOf = (bot1BestHand == "FOUROFAKIND" && bot2BestHand == "FOUROFAKIND");

        if (highCard){
            return compare();
        } else if (pair) {
            return compare();
        } else if (twoPair) {
            return compare();
        } else if (threeOf) {
            return compare();
        } else if (fullHouse) {
            return compare();
        } else if (fourOf) {
            return compare();
        }
        return draw;
    }

    private String compare() {
        String win1 = "Bot 1 wins!";
        String win2 = "Bot 2 wins!";
        String draw = "It's a draw!";

        for (int i = 0; i < this.bot1.evaluator.hand.bestFiveCards.size(); i++) {
            int bot1Rank = this.bot1.evaluator.hand.bestFiveCards.get(i).rank.ordinal();
            int bot2Rank = this.bot2.evaluator.hand.bestFiveCards.get(i).rank.ordinal();
            if ( bot1Rank > bot2Rank ) {
                return win1;
            } else if( i == this.bot1.evaluator.hand.bestFiveCards.size()-1 && bot1Rank == bot2Rank) {
                return draw;
            }
        }
        return win2;
    }
}
