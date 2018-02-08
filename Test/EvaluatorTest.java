import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;


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


    @Test public void groupHandByRank() {
        Card card1 = new Card(Rank.JACK, Suit.HEART);
        Card card3 = new Card(Rank.SIX, Suit.SPADE);
        Card card4 = new Card(Rank.SIX, Suit.HEART);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card3);
        cards.add(card4);

        Evaluator evaluator = new Evaluator();

        evaluator.hand = cards;

        Hashtable<String, ArrayList<Card>> groupByRankTest = evaluator.handByRank(evaluator.hand);

        Assert.assertEquals(card1, groupByRankTest.get(Rank.JACK.name()).get(0));
        Assert.assertEquals(card4, groupByRankTest.get(Rank.SIX.name()).get(0));
        Assert.assertEquals(card3, groupByRankTest.get(Rank.SIX.name()).get(1));
        Assert.assertEquals(1, groupByRankTest.get(Rank.JACK.name()).size());
        Assert.assertEquals(2, groupByRankTest.get(Rank.SIX.name()).size());

    }

    @Test public void groupHandBySuit() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card3 = new Card(Rank.SIX, Suit.SPADE);
        Card card4 = new Card(Rank.JACK, Suit.HEART);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card3);
        cards.add(card4);

        Evaluator evaluator = new Evaluator();

        evaluator.hand = cards;

        for (int i = 0; i < Suit.values().length; i++) {
            String key = Suit.values()[i].name();
            System.out.println(key);
        }

        Hashtable<String, ArrayList<Card>> groupBySuitTest = evaluator.handBySuit(evaluator.hand);

        System.out.println(groupBySuitTest);

        Assert.assertEquals(card4, groupBySuitTest.get(Suit.HEART.name()).get(0));
        Assert.assertEquals(card1, groupBySuitTest.get(Suit.HEART.name()).get(1));
        Assert.assertEquals(card3, groupBySuitTest.get(Suit.SPADE.name()).get(0));
        Assert.assertEquals(2, groupBySuitTest.get(Suit.HEART.name()).size());
        Assert.assertEquals(1, groupBySuitTest.get(Suit.SPADE.name()).size());
    }

    @Test public void testIsThereIsAPair() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.JACK, Suit.HEART);
        Card card4 = new Card(Rank.SEVEN, Suit.HEART);
        Card card5 = new Card(Rank.NINE, Suit.HEART);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = cards;
        Assert.assertEquals(true, evaluator.pair());


    }

    @Test public void testIsThereIsThreeOfKind() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.HEART);
        Card card4 = new Card(Rank.SEVEN, Suit.HEART);
        Card card5 = new Card(Rank.NINE, Suit.HEART);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = cards;
        Assert.assertEquals(true, evaluator.threeOfAKind());
    }

    @Test public void testIsThereIsFourOfKind() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.CLUB);
        Card card4 = new Card(Rank.SIX, Suit.DIAMOND);
        Card card5 = new Card(Rank.NINE, Suit.HEART);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = cards;
        Assert.assertEquals(true, evaluator.fourOfAKind());
    }

    @Test public void threeOfKindFailsIfFourOfKind() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.CLUB);
        Card card4 = new Card(Rank.SIX, Suit.DIAMOND);
        Card card5 = new Card(Rank.NINE, Suit.HEART);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = cards;
        Assert.assertEquals(false, evaluator.threeOfAKind());
    }

    @Test public void checkThereisFullHouse() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.CLUB);
        Card card4 = new Card(Rank.NINE, Suit.DIAMOND);
        Card card5 = new Card(Rank.NINE, Suit.HEART);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = cards;
        Assert.assertEquals(true, evaluator.fullHouse());
    }
}