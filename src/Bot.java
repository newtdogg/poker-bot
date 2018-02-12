import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Hashtable;

public class Bot {
    public Hand hand;
    public Evaluator evaluator;
    public int handWeight;
    public Card card1;
    public Card card2;
    public int card1rank;
    public int card2rank;
    public Hashtable<String, Integer> primeRankMap = new Hashtable<String, Integer>();


    Bot() {
        this.hand = null;
        this.handWeight = 0;
        this.card1 = null;
        this.card2 = null;
        this.card1rank = 0;
        this.card2rank = 0;
        this.evaluator = new Evaluator();
    }

    public void passHandToEvaluator() {
        this.evaluator.hand = this.hand;
    }


    private void assignCards() {
        this.card1 = this.hand.holdEm.get(0);
        this.card2 = this.hand.holdEm.get(1);
        this.card1rank = this.card1.rank.ordinal();
        this.card2rank = this.card2.rank.ordinal();
    }

    public int weighHand() {
        assignCards();
        combineCardValue();
        cardPositions();
        highCardBonus();
        cardsAreSuited();
        return this.handWeight;
    }

    private void highCardBonus() {
        if (this.card1rank >= 8 && this.card2rank >= 8) {
            handWeight += 14;
        } else if (this.card1rank >= 8 || this.card2rank >= 8) {
            handWeight += 2;
        }
    }

    private void combineCardValue() {
        int cardOneValue = this.card1rank + 2;
        int cardTwoValue = this.card2rank + 2;
        handWeight += (cardOneValue + cardTwoValue);
    }

    private void cardPositions() {
        if (cardsAreConnected()) {
            handWeight += 5;
        } else if (cardsAreSemiConnected()) {
            handWeight += 2;
        } else if (pocketPairs()) {
            handWeight *= 2;
        }
    }

    private boolean cardsAreConnected() {
        return (this.card1rank == this.card2rank + 1 || this.card1rank == this.card2rank - 1);
    }

    private boolean cardsAreSemiConnected() {
        int difference = Math.abs(this.card1rank - this.card2rank);
        return (difference > 1 && difference < 5);
    }

    private boolean pocketPairs() {
        return this.card1rank == this.card2rank;
    }

    private void cardsAreSuited() {
        if (card1.suit == card2.suit) {
            handWeight += 8;
        }
    }

    public int cardsFromHandInBestCombo() {
        int cardsFromHand = 0;
        for (int i = 0; i < this.hand.holdEm.size(); i++) {
            if (hand.bestFiveCards.contains(this.hand.holdEm.get(i))) {
                cardsFromHand += 1;
            }
        }
        return cardsFromHand;
    }


    private void assignPrimeRanks() {
        primeRankMap.put("TWO", 3);
        primeRankMap.put("THREE", 5);
        primeRankMap.put("FOUR", 7);
        primeRankMap.put("FIVE", 11);
        primeRankMap.put("SIX", 13);
        primeRankMap.put("SEVEN", 17);
        primeRankMap.put("EIGHT", 19);
        primeRankMap.put("NINE", 23);
        primeRankMap.put("TEN", 29);
        primeRankMap.put("JACK", 31);
        primeRankMap.put("QUEEN", 37);
        primeRankMap.put("KING", 41);
        primeRankMap.put("ACE", 43);
    }

    public double handWeigthingRankFrequency() {
        assignPrimeRanks();
        this.hand.groupByRank(this.hand.playableCards);
        for (int f = Suit.values().length; f > 1; f--) {
            for (int i = this.hand.groupedByRank.size() - 1; i >= 0; --i) {
                String key = Rank.values()[i].name();
                if (this.hand.groupedByRank.get(key).size() == f) {
                    String rankPrime = this.hand.groupedByRank.get(key).get(0).rank.name();
                    return primeRankMap.get(rankPrime) * scaleRankFrequencyWinners();
                }
            }
        }
        return 0;
    }


    private double scaleRankFrequencyWinners() {
        passHandToEvaluator();
        this.evaluator.categoriseAvailableHands();
        double scalar = 0;
        if (this.evaluator.typeOfBestHand() == "PAIR") {
            scalar = Math.pow(2, 2);
        } else if (this.evaluator.typeOfBestHand() == "TWOPAIR") {
            scalar = Math.pow(2, 3);
        } else if (this.evaluator.typeOfBestHand() == "THREEOFAKIND") {
            scalar = Math.pow(2, 5);
        } else if (this.evaluator.typeOfBestHand() == "FOUROFAKIND") {
            scalar = Math.pow(2, 17);
        } else if (this.evaluator.typeOfBestHand() == "FULLHOUSE") {
            scalar = Math.pow(2, 13);
        }
        return scalar;
    }

    private double scaleSuitFrequencyWinners() {
        passHandToEvaluator();
        double scalar = 0;
        this.evaluator.categoriseAvailableHands();
        System.out.println(this.evaluator.typeOfBestHand());
        if (this.evaluator.typeOfBestHand() == "STRAIGHTFLUSH" || this.evaluator.typeOfBestHand() == "ROYALFLUSH") {
            scalar = Math.pow(2, 19);
        } else if (this.evaluator.typeOfBestHand() == "FLUSH") {
            scalar = Math.pow(2, 11);
        }
        return scalar;
    }

    private double scaleStraightWinners() {
        passHandToEvaluator();
        double scalar = 0;
        this.evaluator.categoriseAvailableHands();
        System.out.println(this.evaluator.typeOfBestHand());
        if (this.evaluator.typeOfBestHand() == "STRAIGHT") {
            scalar = Math.pow(2, 7);
        }
        return scalar;
    }

    public double handWeigthingSuitFrequency() {
        assignPrimeRanks();
        this.hand.groupBySuit(this.hand.playableCards);
        for (int i = 0; i < this.hand.groupedBySuit.size(); i++) {
            String key = Suit.values()[i].name();
            if (this.hand.groupedBySuit.get(key).size() >= 5) {
                String rankPrime = this.hand.groupedBySuit.get(key).get(0).rank.name();
                System.out.println(primeRankMap.get(rankPrime) * scaleSuitFrequencyWinners());
                return primeRankMap.get(rankPrime) * scaleSuitFrequencyWinners();
            }
        }
        return 0;
    }

    public double handWeigthingStraight() {
        assignPrimeRanks();
        this.evaluator.straight(this.hand);
        this.evaluator.aceLowStraight(this.hand);

        int highCardOrd = this.evaluator.highestCardOrdinalForStraight;

        System.out.println(primeRankMap.get(Rank.values()[highCardOrd].name()));

        return primeRankMap.get(Rank.values()[highCardOrd].name()) * scaleStraightWinners();
    }
}