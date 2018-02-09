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

        bot.hand.playableCards = cards;

        bot.categoriseAvailableHands();
    }
}