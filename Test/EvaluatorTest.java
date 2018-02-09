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


        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);

        evaluator.hand.playableCards = cards;

        Assert.assertEquals(card5, evaluator.highCard());

    }

    @Test public void testIsThereIsAPair() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.JACK, Suit.HEART);
        Card card4 = new Card(Rank.SEVEN, Suit.HEART);
        Card card5 = new Card(Rank.NINE, Suit.HEART);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.pair());


    }

    @Test public void testIsThereIsThreeOfKind() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.HEART);
        Card card4 = new Card(Rank.SEVEN, Suit.HEART);
        Card card5 = new Card(Rank.NINE, Suit.HEART);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.threeOfAKind());
    }

    @Test public void testIsThereIsFourOfKind() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.CLUB);
        Card card4 = new Card(Rank.SIX, Suit.DIAMOND);
        Card card5 = new Card(Rank.NINE, Suit.HEART);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.fourOfAKind());
    }

    @Test public void threeOfKindFailsIfFourOfKind() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.CLUB);
        Card card4 = new Card(Rank.SIX, Suit.DIAMOND);
        Card card5 = new Card(Rank.NINE, Suit.HEART);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(false, evaluator.threeOfAKind());
    }

    @Test public void checkThereisFullHouse() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.CLUB);
        Card card4 = new Card(Rank.NINE, Suit.DIAMOND);
        Card card5 = new Card(Rank.NINE, Suit.HEART);


        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.fullHouse());
    }

    @Test public void checkThereisNotFullHouse() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.CLUB);
        Card card4 = new Card(Rank.NINE, Suit.DIAMOND);
        Card card5 = new Card(Rank.SEVEN, Suit.HEART);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(false, evaluator.fullHouse());
    }

    @Test public void checkTwoPair() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.EIGHT, Suit.CLUB);
        Card card4 = new Card(Rank.NINE, Suit.DIAMOND);
        Card card5 = new Card(Rank.NINE, Suit.HEART);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

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

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;

        Assert.assertEquals(true, evaluator.flush());
    }

    @Test public void testStraight(){
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.ACE, Suit.HEART);
        Card card2 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card3 = new Card(Rank.EIGHT, Suit.HEART);
        Card card4 = new Card(Rank.NINE, Suit.SPADE);
        Card card5 = new Card(Rank.JACK, Suit.HEART);
        Card card6 = new Card(Rank.TEN, Suit.HEART);
        Card card7 = new Card(Rank.QUEEN, Suit.DIAMOND);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.straight());
    }

    @Test public void testStraightAce() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.ACE, Suit.HEART);
        Card card2 = new Card(Rank.FIVE, Suit.SPADE);
        Card card3 = new Card(Rank.KING, Suit.HEART);
        Card card4 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card5 = new Card(Rank.FOUR, Suit.HEART);
        Card card6 = new Card(Rank.THREE, Suit.HEART);
        Card card7 = new Card(Rank.TWO, Suit.DIAMOND);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.aceLowStraight());
    }

    @Test public void testNotStraight() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.ACE, Suit.HEART);
        Card card2 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card3 = new Card(Rank.EIGHT, Suit.HEART);
        Card card4 = new Card(Rank.NINE, Suit.SPADE);
        Card card5 = new Card(Rank.THREE, Suit.HEART);
        Card card6 = new Card(Rank.TEN, Suit.HEART);
        Card card7 = new Card(Rank.QUEEN, Suit.DIAMOND);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(false, evaluator.straight());
    }

    @Test public void testFlush() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.ACE, Suit.HEART);
        Card card2 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card3 = new Card(Rank.EIGHT, Suit.HEART);
        Card card4 = new Card(Rank.JACK, Suit.SPADE);
        Card card5 = new Card(Rank.KING, Suit.HEART);
        Card card6 = new Card(Rank.TEN, Suit.HEART);
        Card card7 = new Card(Rank.FOUR, Suit.DIAMOND);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;
        Assert.assertEquals(false, evaluator.straight());
    }

}