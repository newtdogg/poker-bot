import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Hashtable;

public class Bot {
    public String status;
    public Hand hand;
    public Evaluator evaluator;
    public int handWeight;
    public Card card1;
    public Card card2;
    public int card1rank;
    public int card2rank;
    public int chips;


    Bot() {
        this.hand = null;
        this.handWeight = 0;
        this.card1 = null;
        this.card2 = null;
        this.card1rank = 0;
        this.card2rank = 0;
        this.chips = 100;
        this.evaluator = new Evaluator();
        this.status = "N/A";
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

    public int weighHoldEm() {
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

    public int getHandWeight() {
        passHandToEvaluator();
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards(this.hand);

        int scalar = Rank.values().length;
        String typeOfWinningHand = this.evaluator.typeOfBestHand();
        int typeOfHandValue = WinningHands.valueOf(typeOfWinningHand).ordinal();
        int valueOfHighestCard = this.evaluator.hand.bestFiveCards.get(0).rank.ordinal() + 1;

        handWeight = scalar *(typeOfHandValue) + valueOfHighestCard;
        return handWeight;
    }

    public void respondToHand() {
        passHandToEvaluator();
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards(this.hand);
        if (getHandWeight() <= 21) {
            this.status = "Check/Fold";
        } else if (getHandWeight() < 40) {
            this.status =  "Call";
        } else if (getHandWeight() < 66 ) {
            this.status =  "Small Raise";
        } else if (getHandWeight() < 87 ) {
            this.status =  "Large Raise";
        } else {
            this.status =  "All in";
        }
    }

}