import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BotTest {
    Deck deck;

    private Evaluator evaluator;
    private ArrayList<Card> cards;
    private Card AceOfSpades;
    private Card TwoOfSpades;
    private Card ThreeOfSpades;
    private Card FourOfSpades;
    private Card FiveOfSpades;
    private Card SixOfSpades;
    private Card SevenOfSpades;
    private Card EightOfSpades;
    private Card NineOfSpades;
    private Card TenOfSpades;
    private Card JackOfSpades;
    private Card QueenOfSpades;
    private Card KingOfSpades;
    private Card AceOfDiamonds;
    private Card TwoOfDiamonds;
    private Card ThreeOfDiamonds;
    private Card FourOfDiamonds;
    private Card FiveOfDiamonds;
    private Card SixOfDiamonds;
    private Card SevenOfDiamonds;
    private Card EightOfDiamonds;
    private Card NineOfDiamonds;
    private Card TenOfDiamonds;
    private Card JackOfDiamonds;
    private Card QueenOfDiamonds;
    private Card KingOfDiamonds;
    private Card AceOfClubs;
    private Card TwoOfClubs;
    private Card ThreeOfClubs;
    private Card FourOfClubs;
    private Card FiveOfClubs;
    private Card SixOfClubs;
    private Card SevenOfClubs;
    private Card EightOfClubs;
    private Card NineOfClubs;
    private Card TenOfClubs;
    private Card JackOfClubs;
    private Card QueenOfClubs;
    private Card KingOfClubs;
    private Card AceOfHearts;
    private Card TwoOfHearts;
    private Card ThreeOfHearts;
    private Card FourOfHearts;
    private Card FiveOfHearts;
    private Card SixOfHearts;
    private Card SevenOfHearts;
    private Card EightOfHearts;
    private Card NineOfHearts;
    private Card TenOfHearts;
    private Card JackOfHearts;
    private Card QueenOfHearts;
    private Card KingOfHearts;
    private Player player;
    private Bot bot;
    private Dealer dealer;



    @Before
    public void initialize() {
        deck = new Deck();
        cards = new ArrayList<Card>();
        AceOfSpades = new Card(Rank.ACE, Suit.SPADE);
        TwoOfSpades = new Card(Rank.TWO, Suit.SPADE);
        ThreeOfSpades = new Card(Rank.THREE, Suit.SPADE);
        FourOfSpades = new Card(Rank.FOUR, Suit.SPADE);
        FiveOfSpades = new Card(Rank.FIVE, Suit.SPADE);
        SixOfSpades = new Card(Rank.SIX, Suit.SPADE);
        SevenOfSpades = new Card(Rank.SEVEN, Suit.SPADE);
        EightOfSpades = new Card(Rank.EIGHT, Suit.SPADE);
        NineOfSpades = new Card(Rank.NINE, Suit.SPADE);
        TenOfSpades = new Card(Rank.TEN, Suit.SPADE);
        JackOfSpades = new Card(Rank.JACK, Suit.SPADE);
        QueenOfSpades = new Card(Rank.QUEEN, Suit.SPADE);
        KingOfSpades = new Card(Rank.KING, Suit.SPADE);
        AceOfDiamonds = new Card(Rank.ACE, Suit.DIAMOND);
        TwoOfDiamonds = new Card(Rank.TWO, Suit.DIAMOND);
        ThreeOfDiamonds = new Card(Rank.THREE, Suit.DIAMOND);
        FourOfDiamonds = new Card(Rank.FOUR, Suit.DIAMOND);
        FiveOfDiamonds = new Card(Rank.FIVE, Suit.DIAMOND);
        SixOfDiamonds = new Card(Rank.SIX, Suit.DIAMOND);
        SevenOfDiamonds = new Card(Rank.SEVEN, Suit.DIAMOND);
        EightOfDiamonds = new Card(Rank.EIGHT, Suit.DIAMOND);
        NineOfDiamonds = new Card(Rank.NINE, Suit.DIAMOND);
        TenOfDiamonds = new Card(Rank.TEN, Suit.DIAMOND);
        JackOfDiamonds = new Card(Rank.JACK, Suit.DIAMOND);
        QueenOfDiamonds = new Card(Rank.QUEEN, Suit.DIAMOND);
        KingOfDiamonds = new Card(Rank.KING, Suit.DIAMOND);
        AceOfHearts = new Card(Rank.ACE, Suit.HEART);
        TwoOfHearts = new Card(Rank.TWO, Suit.HEART);
        ThreeOfHearts = new Card(Rank.THREE, Suit.HEART);
        FourOfHearts = new Card(Rank.FOUR, Suit.HEART);
        FiveOfHearts = new Card(Rank.FIVE, Suit.HEART);
        SixOfHearts = new Card(Rank.SIX, Suit.HEART);
        SevenOfHearts = new Card(Rank.SEVEN, Suit.HEART);
        EightOfHearts = new Card(Rank.EIGHT, Suit.HEART);
        NineOfHearts = new Card(Rank.NINE, Suit.HEART);
        TenOfHearts = new Card(Rank.TEN, Suit.HEART);
        JackOfHearts = new Card(Rank.JACK, Suit.HEART);
        QueenOfHearts = new Card(Rank.QUEEN, Suit.HEART);
        KingOfHearts = new Card(Rank.KING, Suit.HEART);
        AceOfClubs = new Card(Rank.ACE, Suit.CLUB);
        TwoOfClubs = new Card(Rank.TWO, Suit.CLUB);
        ThreeOfClubs = new Card(Rank.THREE, Suit.CLUB);
        FourOfClubs = new Card(Rank.FOUR, Suit.CLUB);
        FiveOfClubs = new Card(Rank.FIVE, Suit.CLUB);
        SixOfClubs = new Card(Rank.SIX, Suit.CLUB);
        SevenOfClubs = new Card(Rank.SEVEN, Suit.CLUB);
        EightOfClubs = new Card(Rank.EIGHT, Suit.CLUB);
        NineOfClubs = new Card(Rank.NINE, Suit.CLUB);
        TenOfClubs = new Card(Rank.TEN, Suit.CLUB);
        JackOfClubs = new Card(Rank.JACK, Suit.CLUB);
        QueenOfClubs = new Card(Rank.QUEEN, Suit.CLUB);
        KingOfClubs = new Card(Rank.KING, Suit.CLUB);
        player = new Player();
        bot = new Bot();
        dealer = new Dealer();
    }

    @Test
    public void botCanHoldTwoCards() {
        dealer.dealHand(bot, player);
        Assert.assertEquals(2, bot.hand.holdEm.size());
    }
    @Test
    public void calculatingStartingHandWeight() {
        Hand hand = new Hand(TwoOfSpades, ThreeOfClubs);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(10, bot.handWeight);
    }
    @Test
    public void weighingTwoHighCards() {
        Hand hand = new Hand(AceOfSpades, TenOfClubs);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(40, bot.handWeight);
    }
    @Test
    public void comparingTwoConsecutiveCards() {
        Hand hand = new Hand(EightOfSpades, NineOfClubs);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(22, bot.handWeight);
    }
    @Test
    public void comparingLowPocketPair() {
        Hand hand = new Hand(NineOfClubs, NineOfSpades);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(36, bot.handWeight);
    }
    @Test
    public void comparingHighPocketPair() {
        Hand hand = new Hand(AceOfSpades, AceOfClubs);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(70, bot.handWeight);
    }
    @Test
    public void comparingSemiConnectedCards() {
        Hand hand = new Hand(TwoOfSpades, FourOfClubs);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(8, bot.handWeight);
    }
    @Test
    public void comparingSuitedCards() {
        Hand hand = new Hand(TwoOfSpades, FourOfSpades);
        bot.hand = hand;
        bot.weighHoldEm();
        Assert.assertEquals(16, bot.handWeight);
    }
    @Test
    public void addFlopToHand() {
        dealer.dealHand(bot, player);
        dealer.dealFlop(bot);
        Assert.assertEquals(5, bot.hand.playableCards.size());
    }
    @Test
    public void addRiverToHand() {
        dealer.dealHand(bot, player);
        dealer.dealRiver(bot);
        Assert.assertEquals(3, bot.hand.playableCards.size());
    }
    @Test
    public void originalDeltCardsAreAddedToPlayableHand() {
        dealer.dealHand(bot, player);
        Assert.assertEquals(2, bot.hand.playableCards.size());
    }

    @Test
    public void numberOfHoldEmInBestCombo() {
        dealer.dealHand(bot, player);
        bot.hand.holdEm.clear();
        bot.hand.holdEm.add(FourOfSpades);
        bot.hand.holdEm.add(FiveOfHearts);
        bot.hand.bestFiveCards.add(FourOfSpades);
        bot.hand.bestFiveCards.add(FiveOfHearts);
        bot.hand.bestFiveCards.add(ThreeOfHearts);
        bot.hand.bestFiveCards.add(SixOfHearts);
        bot.hand.bestFiveCards.add(SevenOfHearts);
        Assert.assertEquals(2, bot.cardsFromHandInBestCombo());
    }

    @Test
    public void testHighCardWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(TwoOfSpades);
        bot.hand.playableCards.add(ThreeOfHearts);
        bot.hand.playableCards.add(AceOfHearts);
        bot.hand.playableCards.add(FiveOfClubs);
        bot.hand.playableCards.add(NineOfDiamonds);
        bot.hand.playableCards.add(EightOfSpades);
        bot.hand.playableCards.add(TenOfHearts);
        Assert.assertEquals(0, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testPairWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(TwoOfSpades);
        bot.hand.playableCards.add(ThreeOfHearts);
        bot.hand.playableCards.add(AceOfHearts);
        bot.hand.playableCards.add(AceOfClubs);
        bot.hand.playableCards.add(NineOfDiamonds);
        bot.hand.playableCards.add(EightOfSpades);
        bot.hand.playableCards.add(TenOfHearts);
        Assert.assertEquals(13, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testThreeOfKindWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(TwoOfSpades);
        bot.hand.playableCards.add(ThreeOfHearts);
        bot.hand.playableCards.add(AceOfHearts);
        bot.hand.playableCards.add(TenOfDiamonds);
        bot.hand.playableCards.add(NineOfSpades);
        bot.hand.playableCards.add(TenOfSpades);
        bot.hand.playableCards.add(TenOfHearts);
        Assert.assertEquals(35, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testFourOfKindWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(TwoOfSpades);
        bot.hand.playableCards.add(ThreeOfHearts);
        bot.hand.playableCards.add(AceOfHearts);
        bot.hand.playableCards.add(TenOfHearts);
        bot.hand.playableCards.add(TenOfDiamonds);
        bot.hand.playableCards.add(TenOfClubs);
        bot.hand.playableCards.add(TenOfSpades);
        Assert.assertEquals(87, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testTwoPairWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(TwoOfSpades);
        bot.hand.playableCards.add(ThreeOfHearts);
        bot.hand.playableCards.add(AceOfHearts);
        bot.hand.playableCards.add(TenOfDiamonds);
        bot.hand.playableCards.add(ThreeOfClubs);
        bot.hand.playableCards.add(SevenOfSpades);
        bot.hand.playableCards.add(TenOfHearts);
        Assert.assertEquals(22, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testThreeOfAKindWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(ThreeOfSpades);
        bot.hand.playableCards.add(ThreeOfHearts);
        bot.hand.playableCards.add(JackOfHearts);
        bot.hand.playableCards.add(TenOfDiamonds);
        bot.hand.playableCards.add(EightOfClubs);
        bot.hand.playableCards.add(ThreeOfSpades);
        bot.hand.playableCards.add(FiveOfHearts);

        Assert.assertEquals(28, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testFlushWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(ThreeOfSpades);
        bot.hand.playableCards.add(FiveOfSpades);
        bot.hand.playableCards.add(JackOfSpades);
        bot.hand.playableCards.add(TenOfDiamonds);
        bot.hand.playableCards.add(EightOfClubs);
        bot.hand.playableCards.add(ThreeOfSpades);
        bot.hand.playableCards.add(TenOfSpades);
        bot.passHandToEvaluator();
        bot.evaluator.categoriseAvailableHands();
        Assert.assertEquals(62, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testStraightFlushWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(ThreeOfSpades);
        bot.hand.playableCards.add(FiveOfSpades);
        bot.hand.playableCards.add(JackOfSpades);
        bot.hand.playableCards.add(TenOfSpades);
        bot.hand.playableCards.add(EightOfSpades);
        bot.hand.playableCards.add(NineOfSpades);
        bot.hand.playableCards.add(SevenOfSpades);
        Assert.assertEquals(101, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testStraightWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(ThreeOfSpades);
        bot.hand.playableCards.add(FiveOfSpades);
        bot.hand.playableCards.add(SixOfSpades);
        bot.hand.playableCards.add(TenOfDiamonds);
        bot.hand.playableCards.add(EightOfHearts);
        bot.hand.playableCards.add(NineOfClubs);
        bot.hand.playableCards.add(SevenOfSpades);
        Assert.assertEquals(48, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testAlmostFlushPreTurn() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(ThreeOfSpades);
        bot.hand.playableCards.add(FiveOfSpades);
        bot.hand.playableCards.add(JackOfSpades);
        bot.hand.playableCards.add(TwoOfSpades);
        bot.hand.playableCards.add(KingOfHearts);
        Assert.assertEquals(true, bot.nearFlush());
    }

    @Test
    public void testAlmostFullHouse() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(ThreeOfSpades);
        bot.hand.playableCards.add(ThreeOfDiamonds);
        bot.hand.playableCards.add(JackOfSpades);
        bot.hand.playableCards.add(JackOfHearts);
        bot.hand.playableCards.add(KingOfHearts);
        Assert.assertEquals(true, bot.nearFullHouse());
    }


    @Test public void testNearStraight() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(ThreeOfSpades);
        bot.hand.playableCards.add(FiveOfSpades);
        bot.hand.playableCards.add(QueenOfSpades);
        bot.hand.playableCards.add(TenOfDiamonds);
        bot.hand.playableCards.add(EightOfHearts);
        bot.hand.playableCards.add(NineOfClubs);
        bot.hand.playableCards.add(SevenOfSpades);
        Assert.assertEquals(true, bot.nearStraight());
    }

    @Test public void testNotNearStraight() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(ThreeOfSpades);
        bot.hand.playableCards.add(FiveOfSpades);
        bot.hand.playableCards.add(QueenOfSpades);
        bot.hand.playableCards.add(TenOfDiamonds);
        bot.hand.playableCards.add(TwoOfHearts);
        bot.hand.playableCards.add(NineOfClubs);
        bot.hand.playableCards.add(SevenOfSpades);
        Assert.assertEquals(false, bot.nearStraight());
    }

    @Test
    public void testNearFlushBonus() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(TenOfSpades);
        bot.hand.playableCards.add(SixOfSpades);
        bot.hand.playableCards.add(EightOfSpades);
        bot.hand.playableCards.add(TwoOfSpades);
        bot.hand.playableCards.add(KingOfDiamonds);
        Assert.assertEquals(38, bot.getHandWeight());
    }


    @Test
    public void testNearStraightBonus() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(FiveOfClubs);
        bot.hand.playableCards.add(ThreeOfSpades);
        bot.hand.playableCards.add(FourOfDiamonds);
        bot.hand.playableCards.add(JackOfSpades);
        bot.hand.playableCards.add(SixOfSpades);
        Assert.assertEquals(23, bot.getHandWeight());
    }

    @Test
    public void nearBonusShouldApplyAfterTurn() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(FiveOfDiamonds);
        bot.hand.playableCards.add(TwoOfSpades);
        bot.hand.playableCards.add(FourOfDiamonds);
        bot.hand.playableCards.add(JackOfDiamonds);
        bot.hand.playableCards.add(SixOfSpades);
        bot.hand.playableCards.add(AceOfDiamonds);
        Assert.assertEquals(26, bot.getHandWeight());
    }

    @Test public void testNearStraightFlush() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(TenOfSpades);
        bot.hand.playableCards.add(JackOfSpades);
        bot.hand.playableCards.add(EightOfSpades);
        bot.hand.playableCards.add(NineOfSpades);
        bot.hand.playableCards.add(KingOfSpades);
        bot.hand.playableCards.add(AceOfSpades);
        bot.hand.playableCards.add(SevenOfClubs);
        Assert.assertEquals(true, bot.nearStraightFlush());
    }

    @Test public void testNotNearStraightFlush() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(TenOfSpades);
        bot.hand.playableCards.add(JackOfSpades);
        bot.hand.playableCards.add(FiveOfSpades);
        bot.hand.playableCards.add(NineOfSpades);
        bot.hand.playableCards.add(TwoOfHearts);
        bot.hand.playableCards.add(FourOfDiamonds);
        bot.hand.playableCards.add(SevenOfClubs);
        Assert.assertEquals(false, bot.nearStraightFlush());
    }


    @Test
    public void bonusForNumberOfCardsBotHasInBestFiveCards() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(FiveOfDiamonds);
        bot.hand.playableCards.add(TwoOfSpades);
        bot.hand.playableCards.add(FourOfDiamonds);
        bot.hand.playableCards.add(JackOfDiamonds);
        bot.hand.playableCards.add(SixOfSpades);
        bot.hand.playableCards.add(AceOfDiamonds);
        bot.hand.playableCards.add(ThreeOfDiamonds);
        bot.hand.holdEm.add(AceOfDiamonds);
        bot.hand.holdEm.add(TwoOfSpades);
        Assert.assertEquals(85, bot.getHandWeight());
    }

    @Test
    public void bonusForNumberOfCardsBotHasInBestFiveCardsTWOCARDS() {
        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        bot.hand.playableCards.add(FiveOfDiamonds);
        bot.hand.playableCards.add(TwoOfSpades);
        bot.hand.playableCards.add(FourOfDiamonds);
        bot.hand.playableCards.add(JackOfDiamonds);
        bot.hand.playableCards.add(SixOfSpades);
        bot.hand.playableCards.add(AceOfDiamonds);
        bot.hand.playableCards.add(ThreeOfDiamonds);
        bot.hand.holdEm.add(FiveOfDiamonds);
        bot.hand.holdEm.add(FourOfDiamonds);
        Assert.assertEquals(98, bot.getHandWeight());
    }
}