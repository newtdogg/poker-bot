import java.util.ArrayList;

public class Bot {
     ArrayList<Card> handArray = new ArrayList<Card>();
     ArrayList<Card> playableHandArray = new ArrayList<Card>();
     public ArrayList<Card> hand;
     public ArrayList<Card> playableHand;
     public int handWeight;
     public Card card1;
     public Card card2;
     public int card1rank;
     public int card2rank;


    Bot() {
        this.hand = handArray;
        this.playableHand = playableHandArray;
        this.handWeight = 0;
        this.card1 = null;
        this.card2 = null;
        this.card1rank = 0;
        this.card2rank = 0;
    }

    public void dealFlop() {

    }

    private void assignCards(ArrayList<Card> hand) {
        this.card1 = hand.get(0);
        this.card2 = hand.get(1);
        this.card1rank = this.card1.rank.ordinal();
        this.card2rank = this.card2.rank.ordinal();
    }

    public int weighHand() {
        assignCards(this.hand);
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
        if (cardsAreConnected()){
            handWeight += 5;
        } else if (cardsAreSemiConnected()){
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
        return (difference > 1 && difference < 5 );
    }

    private boolean pocketPairs() {
        return this.card1rank == this.card2rank;
    }

    private void cardsAreSuited(){
        if (card1.suit == card2.suit) {
            handWeight += 8;
        }
    }


}
