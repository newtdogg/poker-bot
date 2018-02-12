import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BotTest {
    Deck deck;
    @Before
    public void initialize() {
        deck = new Deck();
    }
    @Test
    public void botCanHoldTwoCards() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();
        dealer.dealHand(bot);
        Assert.assertEquals(2, bot.hand.holdEm.size());
    }
    @Test
    public void calculatingStartingHandWeight() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        Assert.assertEquals(10, bot.weighHand());
    }
    @Test
    public void weighingTwoHighCards() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.ACE, Suit.SPADE);
        Card card2 = new Card(Rank.TEN, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        Assert.assertEquals(40, bot.weighHand());
    }
    @Test
    public void comparingTwoConsecutiveCards() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card2 = new Card(Rank.NINE, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        Assert.assertEquals(22, bot.weighHand());
    }
    @Test
    public void comparingLowPocketPair() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.NINE, Suit.SPADE);
        Card card2 = new Card(Rank.NINE, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        Assert.assertEquals(36, bot.weighHand());
    }
    @Test
    public void comparingHighPocketPair() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.ACE, Suit.SPADE);
        Card card2 = new Card(Rank.ACE, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        Assert.assertEquals(70, bot.weighHand());
    }
    @Test
    public void comparingSemiConnectedCards() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.FOUR, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        Assert.assertEquals(8, bot.weighHand());
    }
    @Test
    public void comparingSuitedCards() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.FOUR, Suit.SPADE);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        Assert.assertEquals(16, bot.weighHand());
    }
    @Test
    public void addFlopToHand() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot);
        dealer.dealFlop(bot);
        Assert.assertEquals(5, bot.hand.playableCards.size());
    }
    @Test
    public void addRiverToHand() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot);
        dealer.dealRiver(bot);
        Assert.assertEquals(3, bot.hand.playableCards.size());
    }
    @Test
    public void originalDeltCardsAreAddedToPlayableHand() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot);
        Assert.assertEquals(2, bot.hand.playableCards.size());
    }
    @Test
    public void evaluateHand() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.FOUR, Suit.SPADE);
        Card card2 = new Card(Rank.FOUR, Suit.SPADE);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
//        System.out.println(bot.hand.playableCards);
//        System.out.println(bot.evaluator.hand.playableCards);
//        Assert.assertEquals("Pair", bot.evaluateHand());
    }

    @Test
    public void numberOfHoldEmInBestCombo() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot);

        Card card1 = new Card(Rank.FOUR, Suit.SPADE);
        Card card2 = new Card(Rank.FIVE, Suit.HEART);
        Card card3 = new Card(Rank.THREE, Suit.HEART);
        Card card4 = new Card(Rank.SIX, Suit.HEART);
        Card card5 = new Card(Rank.SEVEN, Suit.HEART);


        bot.hand.holdEm.clear();
        bot.hand.holdEm.add(card1);
        bot.hand.holdEm.add(card2);
        System.out.println(bot.hand.holdEm);


        bot.hand.bestFiveCards.add(card1);
        bot.hand.bestFiveCards.add(card2);

        bot.hand.bestFiveCards.add(card3);
        bot.hand.bestFiveCards.add(card4);
        bot.hand.bestFiveCards.add(card5);

        Assert.assertEquals(2, bot.cardsFromHandInBestCombo());
    }

    @Test
    public void testHandWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.HEART);
        Card card3 = new Card(Rank.ACE, Suit.HEART);
        Card card4 = new Card(Rank.ACE, Suit.HEART);
        Card card5 = new Card(Rank.NINE, Suit.DIAMOND);
        Card card6 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card7 = new Card(Rank.TEN, Suit.HEART);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(172, Math.round(bot.handWeigthingRankFrequency()));
    }

    @Test
    public void testThreeOfKindWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.HEART);
        Card card3 = new Card(Rank.ACE, Suit.HEART);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.NINE, Suit.SPADE);
        Card card6 = new Card(Rank.TEN, Suit.SPADE);
        Card card7 = new Card(Rank.TEN, Suit.HEART);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(928, Math.round(bot.handWeigthingRankFrequency()));
    }

    @Test
    public void testFourOfKindWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.HEART);
        Card card3 = new Card(Rank.ACE, Suit.HEART);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.TEN, Suit.CLUB);
        Card card6 = new Card(Rank.TEN, Suit.SPADE);
        Card card7 = new Card(Rank.TEN, Suit.HEART);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(3801088, Math.round(bot.handWeigthingRankFrequency()));
    }

    @Test
    public void testTwoPairWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.HEART);
        Card card3 = new Card(Rank.ACE, Suit.HEART);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.THREE, Suit.CLUB);
        Card card6 = new Card(Rank.SEVEN, Suit.SPADE);
        Card card7 = new Card(Rank.TEN, Suit.HEART);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(232, Math.round(bot.handWeigthingRankFrequency()));
    }

    @Test
    public void testThreeOfAKindWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.HEART);
        Card card3 = new Card(Rank.JACK, Suit.HEART);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.EIGHT, Suit.CLUB);
        Card card6 = new Card(Rank.THREE, Suit.SPADE);
        Card card7 = new Card(Rank.TEN, Suit.HEART);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(40960, Math.round(bot.handWeigthingRankFrequency()));
    }

    @Test
    public void testFlushWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.FIVE, Suit.SPADE);
        Card card3 = new Card(Rank.JACK, Suit.SPADE);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.EIGHT, Suit.CLUB);
        Card card6 = new Card(Rank.THREE, Suit.SPADE);
        Card card7 = new Card(Rank.TEN, Suit.SPADE);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(63488, Math.round(bot.handWeigthingSuitFrequency()));
    }

    @Test
    public void testStraightFlushWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.FIVE, Suit.SPADE);
        Card card3 = new Card(Rank.JACK, Suit.SPADE);
        Card card4 = new Card(Rank.TEN, Suit.SPADE);
        Card card5 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card6 = new Card(Rank.NINE, Suit.SPADE);
        Card card7 = new Card(Rank.SEVEN, Suit.SPADE);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(16252928, Math.round(bot.handWeigthingSuitFrequency()));
    }

}