import java.util.ArrayList;

public class Bot {
     ArrayList<Card> handArray = new ArrayList<Card>();
     public ArrayList<Card> hand;
     public int handWeight;


    Bot() {
        this.hand = handArray;
        this.handWeight = 0;
    }

    public int weighHand(ArrayList<Card> hand) {
        combineCardValue(hand);
        highCardBonus(hand);
        return this.handWeight;
    }

    private void highCardBonus(ArrayList<Card> hand) {
        if (hand.get(0).rank.ordinal() >= 8 && hand.get(1).rank.ordinal() >= 8) {
            handWeight += 10;
        } else if (hand.get(0).rank.ordinal() >= 8 || hand.get(1).rank.ordinal() >= 8) {
            handWeight += 2;
        }
    }

    private void combineCardValue(ArrayList<Card> hand) {
        int cardOneValue = hand.get(0).rank.ordinal() + 2;
        int cardTwoValue = hand.get(1).rank.ordinal() + 2;
        this.handWeight += (cardOneValue + cardTwoValue);
    }
}
