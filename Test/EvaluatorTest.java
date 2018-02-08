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
        evaluator.hand.playableCards = cards;

        Assert.assertEquals(card5, evaluator.highCard());

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
        evaluator.hand.playableCards = cards;
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
        evaluator.hand.playableCards = cards;
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
        evaluator.hand.playableCards = cards;
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
        evaluator.hand.playableCards = cards;
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
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.fullHouse());
    }

    @Test public void checkThereisNotFullHouse() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.CLUB);
        Card card4 = new Card(Rank.NINE, Suit.DIAMOND);
        Card card5 = new Card(Rank.SEVEN, Suit.HEART);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Evaluator evaluator = new Evaluator();
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(false, evaluator.fullHouse());
    }

    @Test public void checkTwoPair() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.EIGHT, Suit.CLUB);
        Card card4 = new Card(Rank.NINE, Suit.DIAMOND);
        Card card5 = new Card(Rank.NINE, Suit.HEART);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        Evaluator evaluator = new Evaluator();
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.twoPair());
    }

    @Test public void checkHandIsFlush(){
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SEVEN, Suit.SPADE);
        Card card3 = new Card(Rank.JACK, Suit.HEART);
        Card card4 = new Card(Rank.TWO, Suit.HEART);
        Card card5 = new Card(Rank.KING, Suit.HEART);
        Card card6 = new Card(Rank.FOUR, Suit.HEART);
        Card card7 = new Card(Rank.ACE, Suit.DIAMOND);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        Evaluator evaluator = new Evaluator();

        evaluator.hand.playableCards = cards;

        Assert.assertEquals(true, evaluator.flush());
    }

    @Test public void checkHandIsHighStraight(){
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SEVEN, Suit.SPADE);
        Card card3 = new Card(Rank.TEN, Suit.HEART);
        Card card4 = new Card(Rank.JACK, Suit.SPADE);
        Card card5 = new Card(Rank.QUEEN, Suit.HEART);
        Card card6 = new Card(Rank.KING, Suit.HEART);
        Card card7 = new Card(Rank.ACE, Suit.DIAMOND);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        Evaluator evaluator = new Evaluator();

        evaluator.hand.playableCards = cards;

        Assert.assertEquals(true, evaluator.highStraight());
    }

    @Test public void checkHandIsMedStraight(){
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card3 = new Card(Rank.TEN, Suit.HEART);
        Card card4 = new Card(Rank.JACK, Suit.SPADE);
        Card card5 = new Card(Rank.QUEEN, Suit.HEART);
        Card card6 = new Card(Rank.NINE, Suit.HEART);
        Card card7 = new Card(Rank.ACE, Suit.DIAMOND);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        Evaluator evaluator = new Evaluator();

        evaluator.hand.playableCards = cards;

        Assert.assertEquals(true, evaluator.mediumStraight());
    }

    @Test public void checkHandIsLowStraight(){
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SEVEN, Suit.SPADE);
        Card card3 = new Card(Rank.EIGHT, Suit.HEART);
        Card card4 = new Card(Rank.TEN, Suit.SPADE);
        Card card5 = new Card(Rank.QUEEN, Suit.HEART);
        Card card6 = new Card(Rank.NINE, Suit.HEART);
        Card card7 = new Card(Rank.ACE, Suit.DIAMOND);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        Evaluator evaluator = new Evaluator();

        evaluator.hand.playableCards = cards;

        Assert.assertEquals(true, evaluator.lowStraight());
    }

    @Test public void checkingStraightTypeWithAllStraightMethods(){
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.ACE, Suit.HEART);
        Card card2 = new Card(Rank.ACE, Suit.SPADE);
        Card card3 = new Card(Rank.KING, Suit.HEART);
        Card card4 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card5 = new Card(Rank.JACK, Suit.HEART);
        Card card6 = new Card(Rank.TEN, Suit.HEART);
        Card card7 = new Card(Rank.EIGHT, Suit.DIAMOND);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        Evaluator evaluator = new Evaluator();

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.highStraight());
        Assert.assertEquals(true, evaluator.mediumStraight());
        Assert.assertEquals(false, evaluator.lowStraight());
    }

    @Test public void testNotAStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.ACE, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.KING, Suit.HEART);
        Card card4 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card5 = new Card(Rank.FOUR, Suit.HEART);
        Card card6 = new Card(Rank.THREE, Suit.HEART);
        Card card7 = new Card(Rank.TWO, Suit.DIAMOND);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        Evaluator evaluator = new Evaluator();

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(false, evaluator.highStraight());
        Assert.assertEquals(false, evaluator.mediumStraight());
        Assert.assertEquals(false, evaluator.lowStraight());
    }
    @Test public void testLowestStraightAce() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.ACE, Suit.HEART);
        Card card2 = new Card(Rank.FIVE, Suit.SPADE);
        Card card3 = new Card(Rank.KING, Suit.HEART);
        Card card4 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card5 = new Card(Rank.FOUR, Suit.HEART);
        Card card6 = new Card(Rank.THREE, Suit.HEART);
        Card card7 = new Card(Rank.TWO, Suit.DIAMOND);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        Evaluator evaluator = new Evaluator();

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(false, evaluator.highStraight());
        Assert.assertEquals(false, evaluator.mediumStraight());
        Assert.assertEquals(false, evaluator.lowStraight());
        Assert.assertEquals(true, evaluator.aceLowStraight());
    }


}