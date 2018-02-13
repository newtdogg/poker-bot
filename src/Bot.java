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

    public void weighHoldEm() {
        assignCards();
        combineCardValue();
        cardPositions();
        highCardBonus();
        cardsAreSuited();
        respondToHoldEm();
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

    public void respondToHoldEm(){
        if (this.handWeight <= 20){
            this.status = "Check/Fold";
        } else if (this.handWeight > 21 && this.handWeight <= 30){
            this.status = "Call";
        } else if (this.handWeight > 30){
            this.status = "Raise";
        }
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

    public boolean nearFlush() {
        passHandToEvaluator();
        evaluator.categoriseAvailableHands();
        String key = this.evaluator.typeOfBestHand();
        if (WinningHands.valueOf(key).ordinal() < WinningHands.valueOf("THREEOFAKIND").ordinal()) {
            this.evaluator.hand.groupBySuit(this.hand.playableCards);
            for (int i = 0; i < this.evaluator.hand.groupedBySuit.size(); i++){
                String suitKey = Suit.values()[i].name();
                if (this.evaluator.hand.groupedBySuit.get(suitKey).size() == 4) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean nearFullHouse() {
        passHandToEvaluator();
        evaluator.categoriseAvailableHands();
        return this.evaluator.typeOfBestHand() == "TWOPAIR";
    }

    public boolean nearStraight() {
        for (int n = 0; n <= this.hand.playableCards.size()-4; n++) {
            hand.sortHand();
            int counter = 1;
            for (int i = 1; i < this.hand.sortedHighToLow.size(); i++) {
                int highestCardOrdinal = this.hand.sortedHighToLow.get(n).rank.ordinal();
                if(highestCardOrdinal - counter == this.hand.sortedHighToLow.get(i).rank.ordinal()) {
                    counter += 1;
                }
            }
            if (counter == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean nearStraightFlush() {
        this.hand.groupBySuit(this.hand.playableCards);

        for (int i = 0; i < this.hand.groupedBySuit.size(); i++){
            String key = Suit.values()[i].name();
            ArrayList<Card> suit = this.hand.groupedBySuit.get(key);
            if (suit.size() >= 4 ) {
                for (int m = 0; m <= suit.size()-4; m++) {
                    int highestCardOrdinal = suit.get(m).rank.ordinal();
                    int counter = 1;
                    for (int n = m+1; n < suit.size(); n++) {
                        if(highestCardOrdinal - counter == suit.get(n).rank.ordinal()) {
                            counter += 1;
                        }
                    }
                    if (counter == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}