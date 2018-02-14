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
    public Player player = new Player();
    @Test
    public void botCanHoldTwoCards() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();
        dealer.dealHand(bot, player);
        Assert.assertEquals(2, bot.hand.holdEm.size());
    }
    @Test
    public void calculatingStartingHandWeight() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(10, bot.handWeight);
    }
    @Test
    public void weighingTwoHighCards() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.ACE, Suit.SPADE);
        Card card2 = new Card(Rank.TEN, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(40, bot.handWeight);
    }
    @Test
    public void comparingTwoConsecutiveCards() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card2 = new Card(Rank.NINE, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(22, bot.handWeight);
    }
    @Test
    public void comparingLowPocketPair() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.NINE, Suit.SPADE);
        Card card2 = new Card(Rank.NINE, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(36, bot.handWeight);
    }
    @Test
    public void comparingHighPocketPair() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.ACE, Suit.SPADE);
        Card card2 = new Card(Rank.ACE, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(70, bot.handWeight);
    }
    @Test
    public void comparingSemiConnectedCards() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.FOUR, Suit.CLUB);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(8, bot.handWeight);
    }
    @Test
    public void comparingSuitedCards() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.FOUR, Suit.SPADE);
        Hand hand = new Hand(card1, card2);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(16, bot.handWeight);
    }
    @Test
    public void addFlopToHand() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        dealer.dealFlop(bot);
        Assert.assertEquals(5, bot.hand.playableCards.size());
    }
    @Test
    public void addRiverToHand() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        dealer.dealRiver(bot);
        Assert.assertEquals(3, bot.hand.playableCards.size());
    }
    @Test
    public void originalDeltCardsAreAddedToPlayableHand() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
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

        dealer.dealHand(bot, player);

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
    public void testHighCardWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.HEART);
        Card card3 = new Card(Rank.ACE, Suit.HEART);
        Card card4 = new Card(Rank.FIVE, Suit.CLUB);
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

        Assert.assertEquals(0, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testPairWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
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

        Assert.assertEquals(13, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testThreeOfKindWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
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
        Assert.assertEquals(35, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testFourOfKindWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
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

        Assert.assertEquals(87, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testTwoPairWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
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

        Assert.assertEquals(22, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testThreeOfAKindWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.HEART);
        Card card3 = new Card(Rank.JACK, Suit.HEART);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.EIGHT, Suit.CLUB);
        Card card6 = new Card(Rank.THREE, Suit.SPADE);
        Card card7 = new Card(Rank.FIVE, Suit.HEART);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(28, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testFlushWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
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
        bot.passHandToEvaluator();
        bot.evaluator.categoriseAvailableHands();

        Assert.assertEquals(62, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testStraightFlushWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
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

        Assert.assertEquals(101, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testStraightWeighting() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.FIVE, Suit.SPADE);
        Card card3 = new Card(Rank.SIX, Suit.SPADE);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.SEVEN, Suit.SPADE);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(48, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testAlmostFlushPreTurn() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.FIVE, Suit.SPADE);
        Card card3 = new Card(Rank.JACK, Suit.SPADE);
        Card card4 = new Card(Rank.TWO, Suit.SPADE);
        Card card5 = new Card(Rank.KING, Suit.HEART);


        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        Assert.assertEquals(true, bot.nearFlush());
    }

    @Test
    public void testAlmostFullHouse() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.DIAMOND);
        Card card3 = new Card(Rank.JACK, Suit.SPADE);
        Card card4 = new Card(Rank.JACK, Suit.HEART);
        Card card5 = new Card(Rank.KING, Suit.HEART);


        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        Assert.assertEquals(true, bot.nearFullHouse());
    }


    @Test public void testNearStraight() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.FIVE, Suit.SPADE);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.SEVEN, Suit.SPADE);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(true, bot.nearStraight());
    }

    @Test public void testNotNearStraight() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.FIVE, Suit.SPADE);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.TWO, Suit.HEART);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.SEVEN, Suit.SPADE);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(false, bot.nearStraight());
    }

    @Test
    public void testNearFlushBonus() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.TEN, Suit.SPADE);
        Card card2 = new Card(Rank.SIX, Suit.SPADE);
        Card card3 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card4 = new Card(Rank.TWO, Suit.SPADE);
        Card card5 = new Card(Rank.KING, Suit.DIAMOND);


        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);


        Assert.assertEquals(38, bot.getHandWeight());
    }


    @Test
    public void testNearStraightBonus() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.FIVE, Suit.CLUB);
        Card card2 = new Card(Rank.THREE, Suit.SPADE);
        Card card3 = new Card(Rank.FOUR, Suit.DIAMOND);
        Card card4 = new Card(Rank.JACK, Suit.SPADE);
        Card card5 = new Card(Rank.SIX, Suit.SPADE);


        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);

        Assert.assertEquals(23, bot.getHandWeight());
    }

    @Test
    public void nearBonusShouldApplyAfterTurn() {

        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.FIVE, Suit.DIAMOND);
        Card card2 = new Card(Rank.TWO, Suit.SPADE);
        Card card3 = new Card(Rank.FOUR, Suit.DIAMOND);
        Card card4 = new Card(Rank.JACK, Suit.DIAMOND);
        Card card5 = new Card(Rank.SIX, Suit.SPADE);
        Card card6 = new Card(Rank.ACE, Suit.DIAMOND);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);

        Assert.assertEquals(26, bot.getHandWeight());
    }

    @Test public void testNearStraightFlush() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.TEN, Suit.SPADE);
        Card card2 = new Card(Rank.JACK, Suit.SPADE);
        Card card3 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card4 = new Card(Rank.NINE, Suit.SPADE);
        Card card5 = new Card(Rank.KING, Suit.SPADE);
        Card card6 = new Card(Rank.ACE, Suit.SPADE);
        Card card7 = new Card(Rank.SEVEN, Suit.CLUB);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(true, bot.nearStraightFlush());
    }

    @Test public void testNotNearStraightFlush() {
        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.TEN, Suit.SPADE);
        Card card2 = new Card(Rank.JACK, Suit.SPADE);
        Card card3 = new Card(Rank.FIVE, Suit.SPADE);
        Card card4 = new Card(Rank.NINE, Suit.SPADE);
        Card card5 = new Card(Rank.TWO, Suit.HEART);
        Card card6 = new Card(Rank.FOUR, Suit.DIAMOND);
        Card card7 = new Card(Rank.SEVEN, Suit.CLUB);

        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);

        Assert.assertEquals(false, bot.nearStraightFlush());
    }


    @Test
    public void bonusForNumberOfCardsBotHasInBestFiveCards() {

        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.FIVE, Suit.DIAMOND);
        Card card2 = new Card(Rank.TWO, Suit.SPADE);
        Card card3 = new Card(Rank.FOUR, Suit.DIAMOND);
        Card card4 = new Card(Rank.JACK, Suit.DIAMOND);
        Card card5 = new Card(Rank.SIX, Suit.SPADE);
        Card card6 = new Card(Rank.ACE, Suit.DIAMOND);
        Card card7 = new Card(Rank.THREE, Suit.DIAMOND);


        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);


        bot.hand.holdEm.add(card6);
        bot.hand.holdEm.add(card2);

        Assert.assertEquals(85, bot.getHandWeight());
    }

    @Test
    public void bonusForNumberOfCardsBotHasInBestFiveCardsTWOCARDS() {

        Bot bot = new Bot();
        Dealer dealer = new Dealer();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.FIVE, Suit.DIAMOND);
        Card card2 = new Card(Rank.TWO, Suit.SPADE);
        Card card3 = new Card(Rank.FOUR, Suit.DIAMOND);
        Card card4 = new Card(Rank.JACK, Suit.DIAMOND);
        Card card5 = new Card(Rank.SIX, Suit.SPADE);
        Card card6 = new Card(Rank.ACE, Suit.DIAMOND);
        Card card7 = new Card(Rank.THREE, Suit.DIAMOND);


        bot.hand.playableCards.add(card1);
        bot.hand.playableCards.add(card2);
        bot.hand.playableCards.add(card3);
        bot.hand.playableCards.add(card4);
        bot.hand.playableCards.add(card5);
        bot.hand.playableCards.add(card6);
        bot.hand.playableCards.add(card7);


        bot.hand.holdEm.add(card1);
        bot.hand.holdEm.add(card3);

        Assert.assertEquals(98, bot.getHandWeight());
    }
}