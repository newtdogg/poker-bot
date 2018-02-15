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
        Assert.assertEquals(2, bot.hand.getHoldEm().size());
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
        Assert.assertEquals(5, bot.hand.getPlayableCards().size());
    }
    @Test
    public void addRiverToHand() {
        dealer.dealHand(bot, player);
        dealer.dealRiver(bot, player);
        Assert.assertEquals(3, bot.hand.getPlayableCards().size());
    }
    @Test
    public void originalDeltCardsAreAddedToPlayableHand() {
        dealer.dealHand(bot, player);
        Assert.assertEquals(2, bot.hand.getPlayableCards().size());
    }

    @Test
    public void numberOfHoldEmInBestCombo() {
        dealer.dealHand(bot, player);
        bot.hand.getHoldEm().clear();
        bot.hand.getHoldEm().add(FourOfSpades);
        bot.hand.getHoldEm().add(FiveOfHearts);
        bot.hand.getBestFiveCards().add(FourOfSpades);
        bot.hand.getBestFiveCards().add(FiveOfHearts);
        bot.hand.getBestFiveCards().add(ThreeOfHearts);
        bot.hand.getBestFiveCards().add(SixOfHearts);
        bot.hand.getBestFiveCards().add(SevenOfHearts);
        Assert.assertEquals(2, bot.cardsFromHandInBestCombo());
    }

    @Test
    public void testHighCardWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(TwoOfSpades);
        bot.hand.getPlayableCards().add(ThreeOfHearts);
        bot.hand.getPlayableCards().add(AceOfHearts);
        bot.hand.getPlayableCards().add(FiveOfClubs);
        bot.hand.getPlayableCards().add(NineOfDiamonds);
        bot.hand.getPlayableCards().add(EightOfSpades);
        bot.hand.getPlayableCards().add(TenOfHearts);
        Assert.assertEquals(0, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testPairWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(TwoOfSpades);
        bot.hand.getPlayableCards().add(ThreeOfHearts);
        bot.hand.getPlayableCards().add(AceOfHearts);
        bot.hand.getPlayableCards().add(AceOfClubs);
        bot.hand.getPlayableCards().add(NineOfDiamonds);
        bot.hand.getPlayableCards().add(EightOfSpades);
        bot.hand.getPlayableCards().add(TenOfHearts);
        Assert.assertEquals(13, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testThreeOfKindWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(TwoOfSpades);
        bot.hand.getPlayableCards().add(ThreeOfHearts);
        bot.hand.getPlayableCards().add(AceOfHearts);
        bot.hand.getPlayableCards().add(TenOfDiamonds);
        bot.hand.getPlayableCards().add(NineOfSpades);
        bot.hand.getPlayableCards().add(TenOfSpades);
        bot.hand.getPlayableCards().add(TenOfHearts);
        Assert.assertEquals(35, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testFourOfKindWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(TwoOfSpades);
        bot.hand.getPlayableCards().add(ThreeOfHearts);
        bot.hand.getPlayableCards().add(AceOfHearts);
        bot.hand.getPlayableCards().add(TenOfHearts);
        bot.hand.getPlayableCards().add(TenOfDiamonds);
        bot.hand.getPlayableCards().add(TenOfClubs);
        bot.hand.getPlayableCards().add(TenOfSpades);
        Assert.assertEquals(87, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testTwoPairWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(TwoOfSpades);
        bot.hand.getPlayableCards().add(ThreeOfHearts);
        bot.hand.getPlayableCards().add(AceOfHearts);
        bot.hand.getPlayableCards().add(TenOfDiamonds);
        bot.hand.getPlayableCards().add(ThreeOfClubs);
        bot.hand.getPlayableCards().add(SevenOfSpades);
        bot.hand.getPlayableCards().add(TenOfHearts);
        Assert.assertEquals(22, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testThreeOfAKindWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(ThreeOfSpades);
        bot.hand.getPlayableCards().add(ThreeOfHearts);
        bot.hand.getPlayableCards().add(JackOfHearts);
        bot.hand.getPlayableCards().add(TenOfDiamonds);
        bot.hand.getPlayableCards().add(EightOfClubs);
        bot.hand.getPlayableCards().add(ThreeOfSpades);
        bot.hand.getPlayableCards().add(FiveOfHearts);

        Assert.assertEquals(28, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testFlushWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(ThreeOfSpades);
        bot.hand.getPlayableCards().add(FiveOfSpades);
        bot.hand.getPlayableCards().add(JackOfSpades);
        bot.hand.getPlayableCards().add(TenOfDiamonds);
        bot.hand.getPlayableCards().add(EightOfClubs);
        bot.hand.getPlayableCards().add(ThreeOfSpades);
        bot.hand.getPlayableCards().add(TenOfSpades);
        bot.passHandToEvaluator();
        bot.evaluator.categoriseAvailableHands();
        Assert.assertEquals(62, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testStraightFlushWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(ThreeOfSpades);
        bot.hand.getPlayableCards().add(FiveOfSpades);
        bot.hand.getPlayableCards().add(JackOfSpades);
        bot.hand.getPlayableCards().add(TenOfSpades);
        bot.hand.getPlayableCards().add(EightOfSpades);
        bot.hand.getPlayableCards().add(NineOfSpades);
        bot.hand.getPlayableCards().add(SevenOfSpades);
        Assert.assertEquals(101, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testStraightWeighting() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(ThreeOfSpades);
        bot.hand.getPlayableCards().add(FiveOfSpades);
        bot.hand.getPlayableCards().add(SixOfSpades);
        bot.hand.getPlayableCards().add(TenOfDiamonds);
        bot.hand.getPlayableCards().add(EightOfHearts);
        bot.hand.getPlayableCards().add(NineOfClubs);
        bot.hand.getPlayableCards().add(SevenOfSpades);
        Assert.assertEquals(48, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testAlmostFlushPreTurn() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(ThreeOfSpades);
        bot.hand.getPlayableCards().add(FiveOfSpades);
        bot.hand.getPlayableCards().add(JackOfSpades);
        bot.hand.getPlayableCards().add(TwoOfSpades);
        bot.hand.getPlayableCards().add(KingOfHearts);
        Assert.assertEquals(true, bot.nearFlush());
    }

    @Test
    public void testAlmostFullHouse() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(ThreeOfSpades);
        bot.hand.getPlayableCards().add(ThreeOfDiamonds);
        bot.hand.getPlayableCards().add(JackOfSpades);
        bot.hand.getPlayableCards().add(JackOfHearts);
        bot.hand.getPlayableCards().add(KingOfHearts);
        Assert.assertEquals(true, bot.nearFullHouse());
    }


    @Test public void testNearStraight() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(ThreeOfSpades);
        bot.hand.getPlayableCards().add(FiveOfSpades);
        bot.hand.getPlayableCards().add(QueenOfSpades);
        bot.hand.getPlayableCards().add(TenOfDiamonds);
        bot.hand.getPlayableCards().add(EightOfHearts);
        bot.hand.getPlayableCards().add(NineOfClubs);
        bot.hand.getPlayableCards().add(SevenOfSpades);
        Assert.assertEquals(true, bot.nearStraight());
    }

    @Test public void testNotNearStraight() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(ThreeOfSpades);
        bot.hand.getPlayableCards().add(FiveOfSpades);
        bot.hand.getPlayableCards().add(QueenOfSpades);
        bot.hand.getPlayableCards().add(TenOfDiamonds);
        bot.hand.getPlayableCards().add(TwoOfHearts);
        bot.hand.getPlayableCards().add(NineOfClubs);
        bot.hand.getPlayableCards().add(SevenOfSpades);
        Assert.assertEquals(false, bot.nearStraight());
    }

    @Test
    public void testNearFlushBonus() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(TenOfSpades);
        bot.hand.getPlayableCards().add(SixOfSpades);
        bot.hand.getPlayableCards().add(EightOfSpades);
        bot.hand.getPlayableCards().add(TwoOfSpades);
        bot.hand.getPlayableCards().add(KingOfDiamonds);
        Assert.assertEquals(38, bot.getHandWeight());
    }


    @Test
    public void testNearStraightBonus() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(FiveOfClubs);
        bot.hand.getPlayableCards().add(ThreeOfSpades);
        bot.hand.getPlayableCards().add(FourOfDiamonds);
        bot.hand.getPlayableCards().add(JackOfSpades);
        bot.hand.getPlayableCards().add(SixOfSpades);
        Assert.assertEquals(23, bot.getHandWeight());
    }

    @Test
    public void nearBonusShouldApplyAfterTurn() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(FiveOfDiamonds);
        bot.hand.getPlayableCards().add(TwoOfSpades);
        bot.hand.getPlayableCards().add(FourOfDiamonds);
        bot.hand.getPlayableCards().add(JackOfDiamonds);
        bot.hand.getPlayableCards().add(SixOfSpades);
        bot.hand.getPlayableCards().add(AceOfDiamonds);
        Assert.assertEquals(26, bot.getHandWeight());
    }

    @Test public void testNearStraightFlush() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(TenOfSpades);
        bot.hand.getPlayableCards().add(JackOfSpades);
        bot.hand.getPlayableCards().add(EightOfSpades);
        bot.hand.getPlayableCards().add(NineOfSpades);
        bot.hand.getPlayableCards().add(KingOfSpades);
        bot.hand.getPlayableCards().add(AceOfSpades);
        bot.hand.getPlayableCards().add(SevenOfClubs);
        Assert.assertEquals(true, bot.nearStraightFlush());
    }

    @Test public void testNotNearStraightFlush() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(TenOfSpades);
        bot.hand.getPlayableCards().add(JackOfSpades);
        bot.hand.getPlayableCards().add(FiveOfSpades);
        bot.hand.getPlayableCards().add(NineOfSpades);
        bot.hand.getPlayableCards().add(TwoOfHearts);
        bot.hand.getPlayableCards().add(FourOfDiamonds);
        bot.hand.getPlayableCards().add(SevenOfClubs);
        Assert.assertEquals(false, bot.nearStraightFlush());
    }


    @Test
    public void bonusForNumberOfCardsBotHasInBestFiveCards() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(FiveOfDiamonds);
        bot.hand.getPlayableCards().add(TwoOfSpades);
        bot.hand.getPlayableCards().add(FourOfDiamonds);
        bot.hand.getPlayableCards().add(JackOfDiamonds);
        bot.hand.getPlayableCards().add(SixOfSpades);
        bot.hand.getPlayableCards().add(AceOfDiamonds);
        bot.hand.getPlayableCards().add(ThreeOfDiamonds);
        bot.hand.getHoldEm().add(AceOfDiamonds);
        bot.hand.getHoldEm().add(TwoOfSpades);
        Assert.assertEquals(85, bot.getHandWeight());
    }

    @Test
    public void bonusForNumberOfCardsBotHasInBestFiveCardsTWOCARDS() {
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        bot.hand.getPlayableCards().add(FiveOfDiamonds);
        bot.hand.getPlayableCards().add(TwoOfSpades);
        bot.hand.getPlayableCards().add(FourOfDiamonds);
        bot.hand.getPlayableCards().add(JackOfDiamonds);
        bot.hand.getPlayableCards().add(SixOfSpades);
        bot.hand.getPlayableCards().add(AceOfDiamonds);
        bot.hand.getPlayableCards().add(ThreeOfDiamonds);
        bot.hand.getHoldEm().add(FiveOfDiamonds);
        bot.hand.getHoldEm().add(FourOfDiamonds);
        Assert.assertEquals(98, bot.getHandWeight());
    }
}