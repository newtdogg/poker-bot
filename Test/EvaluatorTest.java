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
        Assert.assertEquals(true, evaluator.pair(evaluator.hand));


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
        Assert.assertEquals(true, evaluator.threeOfAKind(evaluator.hand));
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
        Assert.assertEquals(true, evaluator.fourOfAKind(evaluator.hand));
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
        Assert.assertEquals(false, evaluator.threeOfAKind(evaluator.hand));
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
        Assert.assertEquals(true, evaluator.fullHouse(evaluator.hand));
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
        Assert.assertEquals(false, evaluator.fullHouse(evaluator.hand));
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
        Assert.assertEquals(true, evaluator.twoPair(evaluator.hand));
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

        Assert.assertEquals(true, evaluator.flush(evaluator.hand));
    }

    @Test public void checkHandIsRoyalFlush(){
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.SIX, Suit.SPADE);
        Card card2 = new Card(Rank.QUEEN, Suit.HEART);
        Card card3 = new Card(Rank.JACK, Suit.HEART);
        Card card4 = new Card(Rank.TEN, Suit.HEART);
        Card card5 = new Card(Rank.KING, Suit.HEART);
        Card card6 = new Card(Rank.FOUR, Suit.DIAMOND);
        Card card7 = new Card(Rank.ACE, Suit.HEART);

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

        Assert.assertEquals(true, evaluator.royalFlush(evaluator.hand));
    }

    @Test public void checkHandIsStraightFlush(){
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card1 = new Card(Rank.SIX, Suit.SPADE);
        Card card2 = new Card(Rank.QUEEN, Suit.HEART);
        Card card3 = new Card(Rank.JACK, Suit.HEART);
        Card card4 = new Card(Rank.TEN, Suit.HEART);
        Card card5 = new Card(Rank.KING, Suit.HEART);
        Card card6 = new Card(Rank.FOUR, Suit.DIAMOND);
        Card card7 = new Card(Rank.NINE, Suit.HEART);

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

        Assert.assertEquals(true, evaluator.straightFlush(evaluator.hand));
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
        Assert.assertEquals(true, evaluator.straight(evaluator.hand));
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
        Assert.assertEquals(true, evaluator.aceLowStraight(evaluator.hand));
    }

    @Test public void addingPairToAllAvailableHands() {
        Bot bot = new Bot();

        Card card1 = new Card(Rank.FOUR, Suit.SPADE);
        Card card2 = new Card(Rank.FOUR, Suit.CLUB);
        Card card3 = new Card(Rank.ACE, Suit.SPADE);
        Card card4 = new Card(Rank.TEN, Suit.CLUB);
        Card card5 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.KING, Suit.DIAMOND);

        bot.hand = new Hand(card1, card2);
        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;

        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.PAIR.toString()).size());
    }

    @Test public void addingThreeOfAKindToAllAvailableHands() {
        Bot bot = new Bot();

        Card card1 = new Card(Rank.FOUR, Suit.SPADE);
        Card card2 = new Card(Rank.FOUR, Suit.CLUB);
        Card card3 = new Card(Rank.FOUR, Suit.DIAMOND);
        Card card4 = new Card(Rank.TEN, Suit.CLUB);
        Card card5 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.KING, Suit.DIAMOND);

        bot.hand = new Hand(card1, card2);
        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;

        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.THREEOFAKIND.toString()).size());
        Assert.assertEquals(0, evaluator.allAvailableHands.get(WinningHands.PAIR.toString()).size());
    }

    @Test public void addingFourOfAKindToAllAvailableHands() {
        Bot bot = new Bot();

        Card card1 = new Card(Rank.FOUR, Suit.SPADE);
        Card card2 = new Card(Rank.FOUR, Suit.CLUB);
        Card card3 = new Card(Rank.FOUR, Suit.DIAMOND);
        Card card4 = new Card(Rank.FOUR, Suit.CLUB);
        Card card5 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.KING, Suit.DIAMOND);

        bot.hand = new Hand(card1, card2);
        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;

        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.FOUROFAKIND.toString()).size());
    }

    @Test public void addingTwoPairToAllAvailableHands() {
        Bot bot = new Bot();

        Card card1 = new Card(Rank.FOUR, Suit.SPADE);
        Card card2 = new Card(Rank.FOUR, Suit.CLUB);
        Card card3 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card4 = new Card(Rank.TEN, Suit.CLUB);
        Card card5 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.KING, Suit.DIAMOND);

        bot.hand = new Hand(card1, card2);
        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();

        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.TWOPAIR.toString()).size());
        Assert.assertEquals(0, evaluator.allAvailableHands.get(WinningHands.PAIR.toString()).size());
    }

    @Test public void addingFlushToAllAvailableHands() {
        Bot bot = new Bot();

        Card card1 = new Card(Rank.FOUR, Suit.SPADE);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.JACK, Suit.SPADE);
        Card card4 = new Card(Rank.TEN, Suit.SPADE);
        Card card5 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.KING, Suit.DIAMOND);

        bot.hand = new Hand(card1, card2);
        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();

        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.FLUSH.toString()).size());
    }

    @Test public void addingStraightToAllAvailableHands() {
        Bot bot = new Bot();

        Card card1 = new Card(Rank.FOUR, Suit.SPADE);
        Card card2 = new Card(Rank.SEVEN, Suit.CLUB);
        Card card3 = new Card(Rank.SIX, Suit.DIAMOND);
        Card card4 = new Card(Rank.TEN, Suit.CLUB);
        Card card5 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.KING, Suit.DIAMOND);

        bot.hand = new Hand(card1, card2);
        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;

        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.STRAIGHT.toString()).size());
    }

    @Test public void addingStraightFlushToAllAvailableHandsMeansHandIsAddedToStraightAndFlush() {
        Bot bot = new Bot();

        Card card1 = new Card(Rank.FOUR, Suit.SPADE);
        Card card2 = new Card(Rank.SEVEN, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.SPADE);
        Card card4 = new Card(Rank.TEN, Suit.SPADE);
        Card card5 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card6 = new Card(Rank.NINE, Suit.SPADE);
        Card card7 = new Card(Rank.KING, Suit.SPADE);

        bot.hand = new Hand(card1, card2);
        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;

        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.STRAIGHT.toString()).size());
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.FLUSH.toString()).size());

    }

    @Test public void returningTheBestHandofTwoHands(){
        Card card1 = new Card(Rank.KING, Suit.DIAMOND);
        Card card2 = new Card(Rank.SEVEN, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.SPADE);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.KING, Suit.SPADE);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;

        evaluator.categoriseAvailableHands();

        Assert.assertEquals("STRAIGHT", evaluator.typeOfBestHand());
    }

    @Test public void returningTheBestHandofTwoHandsSecondTest(){
        Card card1 = new Card(Rank.KING, Suit.DIAMOND);
        Card card2 = new Card(Rank.TWO, Suit.SPADE);
        Card card3 = new Card(Rank.THREE, Suit.SPADE);
        Card card4 = new Card(Rank.SIX, Suit.DIAMOND);
        Card card5 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.KING, Suit.SPADE);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;

        evaluator.categoriseAvailableHands();

        Assert.assertEquals("PAIR", evaluator.typeOfBestHand());
    }

    @Test public void accessBestFiveCardsInRoyalFlushArrayAndReturnArrayList(){
        Card card1 = new Card(Rank.KING, Suit.DIAMOND);
        Card card2 = new Card(Rank.ACE, Suit.DIAMOND);
        Card card3 = new Card(Rank.QUEEN, Suit.DIAMOND);
        Card card4 = new Card(Rank.JACK, Suit.DIAMOND);
        Card card5 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card6 = new Card(Rank.NINE, Suit.DIAMOND);
        Card card7 = new Card(Rank.EIGHT, Suit.DIAMOND);

        Evaluator evaluator = new Evaluator();
        evaluator.hand = new Hand(card1, card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        cards.add(card6);
        cards.add(card7);

        evaluator.hand.playableCards = cards;

        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards(evaluator.hand);
        System.out.println(evaluator.hand.bestFiveCards);


        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size() );
    }

}