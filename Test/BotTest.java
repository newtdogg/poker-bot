import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BotTest extends DeckHelper {
    Deck deck;

    private Evaluator evaluator;
    private ArrayList<Card> cards;

    private Player player;
    private Bot bot;
    private Dealer dealer;



    @Before
    public void initialize() {
        deck = new Deck();
        cards = new ArrayList<Card>();
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
        dealer.dealFlop(bot, player);
        Assert.assertEquals(5, bot.hand.playableCards.size());
    }
    @Test
    public void addRiverToHand() {
        dealer.dealHand(bot, player);
        dealer.dealRiver(bot, player);
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