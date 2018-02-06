import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;


public class EvaluatorTest {

    @Test public void highCardOnePlayer() {

        Card card1 = new Card(Rank.JACK, Suit.HEART);
        Card card2 = new Card(Rank.FOUR, Suit.HEART);
        Card card3 = new Card(Rank.FIVE, Suit.SPADE);
        Card card4 = new Card(Rank.SIX, Suit.HEART);
        Card card5 = new Card(Rank.ACE, Suit.HEART);
        Card card6 = new Card(Rank.KING, Suit.HEART);

//        System.out.println(card1.rank);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);

        Evaluator evaluator = new Evaluator();

        evaluator.hand = cards;

        Assert.assertEquals(card5, evaluator.highCard());

    }

//    @Test public void pairOnePlayer() {
//
//        Card card1 = new Card(Rank.JACK, Suit.HEART);
//        Card card2 = new Card(Rank.JACK, Suit.HEART);
//
////        System.out.println(card1.rank);
//
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(card1);
//        cards.add(card2);
//
//        Evaluator evaluator = new Evaluator();
//
//        evaluator.hand = cards;
//
//        Assert.assertEquals(true, evaluator.pair());
//
//    }
}