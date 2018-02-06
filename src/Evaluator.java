import java.util.ArrayList;

public class Evaluator {

    public ArrayList<Card> hand;

    public Card highCard(){

        int max = Rank.valueOf(hand.get(0).rank.name()).ordinal();
        int maxIndex = 0;

        for (int i = 0; i < hand.size(); i++) {
            if(Rank.valueOf(hand.get(i).rank.name()).ordinal() > max) {
                max = Rank.valueOf(hand.get(i).rank.name()).ordinal();
                maxIndex = i;
            }
        }
        return hand.get(maxIndex);
    }


}
