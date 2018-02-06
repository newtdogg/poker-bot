import java.util.ArrayList;

public class Evaluator {

    public Card highCard(ArrayList<Card> CardArray){
        for (Card card : CardArray){
            System.out.println(card.rank.ordinal());
        }
    }
}

