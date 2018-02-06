import java.util.ArrayList;

public class Bot {
     ArrayList<Card> handArray = new ArrayList<Card>();
     public ArrayList<Card> hand;
     public int handWeight;
     public Card card1;
     public Card card2;


    Bot() {
        this.hand = handArray;
        this.handWeight = 0;
        this.card1 = null;
        this.card2 = null;
    }

    public void assignCards(ArrayList<Card> hand) {
        this.card1 = hand.get(0);
        this.card2 = hand.get(1);
    }

    public int weighHand() {
        combineCardValue();
        cardPositions();
        highCardBonus();
        return this.handWeight;
    }

    private void highCardBonus() {
        if (this.card1.rank.ordinal() >= 8 && this.card2.rank.ordinal() >= 8) {
            handWeight += 14;
        } else if (this.card1.rank.ordinal() >= 8 || this.card2.rank.ordinal() >= 8) {
            handWeight += 2;
        }
    }

    private void combineCardValue() {
        int cardOneValue = this.card1.rank.ordinal() + 2;
        int cardTwoValue = this.card2.rank.ordinal() + 2;
        handWeight += (cardOneValue + cardTwoValue);
    }

    private void cardPositions() {
        if (this.card1.rank.ordinal() == this.card2.rank.ordinal() + 1 || this.card1.rank.ordinal() == this.card2.rank.ordinal() - 1){
            handWeight += 5;
        } else if (this.card1.rank.ordinal() == this.card2.rank.ordinal()) {
            handWeight *= 2;
        }
    }
}
