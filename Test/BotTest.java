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
        Assert.assertEquals(2, bot.getHand().getHoldEm().size());
    }
    @Test
    public void calculatingStartingHandWeight() {
        Hand hand = new Hand(TwoOfSpades, ThreeOfClubs);
        bot.setHand(hand);
        bot.weighHoldEm();
        Assert.assertEquals(10, bot.handWeight);
    }
    @Test
    public void weighingTwoHighCards() {
        Hand hand = new Hand(AceOfSpades, TenOfClubs);
        bot.setHand(hand);
        bot.weighHoldEm();
        Assert.assertEquals(40, bot.handWeight);
    }
    @Test
    public void comparingTwoConsecutiveCards() {
        Hand hand = new Hand(EightOfSpades, NineOfClubs);
        bot.setHand(hand);
        bot.weighHoldEm();
        Assert.assertEquals(22, bot.handWeight);
    }
    @Test
    public void comparingLowPocketPair() {
        Hand hand = new Hand(NineOfClubs, NineOfSpades);
        bot.setHand(hand);
        bot.weighHoldEm();
        Assert.assertEquals(36, bot.handWeight);
    }
    @Test
    public void comparingHighPocketPair() {
        Hand hand = new Hand(AceOfSpades, AceOfClubs);
        bot.setHand(hand);
        bot.weighHoldEm();
        Assert.assertEquals(70, bot.handWeight);
    }
    @Test
    public void comparingSemiConnectedCards() {
        Hand hand = new Hand(TwoOfSpades, FourOfClubs);
        bot.setHand(hand);
        bot.weighHoldEm();
        Assert.assertEquals(8, bot.handWeight);
    }
    @Test
    public void comparingSuitedCards() {
        Hand hand = new Hand(TwoOfSpades, FourOfSpades);
        bot.setHand(hand);
        bot.weighHoldEm();
        Assert.assertEquals(16, bot.handWeight);
    }
    @Test
    public void addFlopToHand() {
        dealer.dealHand(bot, player);
        dealer.dealFlop(bot, player);
        Assert.assertEquals(5, bot.getHand().getPlayableCards().size());
    }
    @Test
    public void addRiverToHand() {
        dealer.dealHand(bot, player);
        dealer.dealRiver(bot, player);
        Assert.assertEquals(3, bot.getHand().getPlayableCards().size());
    }
    @Test
    public void originalDeltCardsAreAddedToPlayableHand() {
        dealer.dealHand(bot, player);
        Assert.assertEquals(2, bot.getHand().getPlayableCards().size());
    }

    @Test
    public void numberOfHoldEmInBestCombo() {
        dealer.dealHand(bot, player);
        bot.getHand().getHoldEm().clear();
        bot.getHand().getHoldEm().add(FourOfSpades);
        bot.getHand().getHoldEm().add(FiveOfHearts);
        bot.getHand().getBestFiveCards().add(FourOfSpades);
        bot.getHand().getBestFiveCards().add(FiveOfHearts);
        bot.getHand().getBestFiveCards().add(ThreeOfHearts);
        bot.getHand().getBestFiveCards().add(SixOfHearts);
        bot.getHand().getBestFiveCards().add(SevenOfHearts);
        Assert.assertEquals(2, bot.cardsFromHandInBestCombo());
    }

    @Test
    public void testHighCardWeighting() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(TwoOfSpades);
        bot.getHand().getPlayableCards().add(ThreeOfHearts);
        bot.getHand().getPlayableCards().add(AceOfHearts);
        bot.getHand().getPlayableCards().add(FiveOfClubs);
        bot.getHand().getPlayableCards().add(NineOfDiamonds);
        bot.getHand().getPlayableCards().add(EightOfSpades);
        bot.getHand().getPlayableCards().add(TenOfHearts);
        Assert.assertEquals(0, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testPairWeighting() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(TwoOfSpades);
        bot.getHand().getPlayableCards().add(ThreeOfHearts);
        bot.getHand().getPlayableCards().add(AceOfHearts);
        bot.getHand().getPlayableCards().add(AceOfClubs);
        bot.getHand().getPlayableCards().add(NineOfDiamonds);
        bot.getHand().getPlayableCards().add(EightOfSpades);
        bot.getHand().getPlayableCards().add(TenOfHearts);
        Assert.assertEquals(13, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testThreeOfKindWeighting() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(TwoOfSpades);
        bot.getHand().getPlayableCards().add(ThreeOfHearts);
        bot.getHand().getPlayableCards().add(AceOfHearts);
        bot.getHand().getPlayableCards().add(TenOfDiamonds);
        bot.getHand().getPlayableCards().add(NineOfSpades);
        bot.getHand().getPlayableCards().add(TenOfSpades);
        bot.getHand().getPlayableCards().add(TenOfHearts);
        Assert.assertEquals(35, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testFourOfKindWeighting() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(TwoOfSpades);
        bot.getHand().getPlayableCards().add(ThreeOfHearts);
        bot.getHand().getPlayableCards().add(AceOfHearts);
        bot.getHand().getPlayableCards().add(TenOfHearts);
        bot.getHand().getPlayableCards().add(TenOfDiamonds);
        bot.getHand().getPlayableCards().add(TenOfClubs);
        bot.getHand().getPlayableCards().add(TenOfSpades);
        Assert.assertEquals(87, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testTwoPairWeighting() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(TwoOfSpades);
        bot.getHand().getPlayableCards().add(ThreeOfHearts);
        bot.getHand().getPlayableCards().add(AceOfHearts);
        bot.getHand().getPlayableCards().add(TenOfDiamonds);
        bot.getHand().getPlayableCards().add(ThreeOfClubs);
        bot.getHand().getPlayableCards().add(SevenOfSpades);
        bot.getHand().getPlayableCards().add(TenOfHearts);
        Assert.assertEquals(22, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testThreeOfAKindWeighting() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(ThreeOfSpades);
        bot.getHand().getPlayableCards().add(ThreeOfHearts);
        bot.getHand().getPlayableCards().add(JackOfHearts);
        bot.getHand().getPlayableCards().add(TenOfDiamonds);
        bot.getHand().getPlayableCards().add(EightOfClubs);
        bot.getHand().getPlayableCards().add(ThreeOfSpades);
        bot.getHand().getPlayableCards().add(FiveOfHearts);

        Assert.assertEquals(28, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testFlushWeighting() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(ThreeOfSpades);
        bot.getHand().getPlayableCards().add(FiveOfSpades);
        bot.getHand().getPlayableCards().add(JackOfSpades);
        bot.getHand().getPlayableCards().add(TenOfDiamonds);
        bot.getHand().getPlayableCards().add(EightOfClubs);
        bot.getHand().getPlayableCards().add(ThreeOfSpades);
        bot.getHand().getPlayableCards().add(TenOfSpades);
        bot.passHandToEvaluator();
        bot.evaluator.categoriseAvailableHands();
        Assert.assertEquals(62, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testStraightFlushWeighting() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(ThreeOfSpades);
        bot.getHand().getPlayableCards().add(FiveOfSpades);
        bot.getHand().getPlayableCards().add(JackOfSpades);
        bot.getHand().getPlayableCards().add(TenOfSpades);
        bot.getHand().getPlayableCards().add(EightOfSpades);
        bot.getHand().getPlayableCards().add(NineOfSpades);
        bot.getHand().getPlayableCards().add(SevenOfSpades);
        Assert.assertEquals(101, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testStraightWeighting() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(ThreeOfSpades);
        bot.getHand().getPlayableCards().add(FiveOfSpades);
        bot.getHand().getPlayableCards().add(SixOfSpades);
        bot.getHand().getPlayableCards().add(TenOfDiamonds);
        bot.getHand().getPlayableCards().add(EightOfHearts);
        bot.getHand().getPlayableCards().add(NineOfClubs);
        bot.getHand().getPlayableCards().add(SevenOfSpades);
        Assert.assertEquals(48, Math.round(bot.getHandWeight()));
    }

    @Test
    public void testAlmostFlushPreTurn() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(ThreeOfSpades);
        bot.getHand().getPlayableCards().add(FiveOfSpades);
        bot.getHand().getPlayableCards().add(JackOfSpades);
        bot.getHand().getPlayableCards().add(TwoOfSpades);
        bot.getHand().getPlayableCards().add(KingOfHearts);
        Assert.assertEquals(true, bot.nearFlush());
    }

    @Test
    public void testAlmostFullHouse() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(ThreeOfSpades);
        bot.getHand().getPlayableCards().add(ThreeOfDiamonds);
        bot.getHand().getPlayableCards().add(JackOfSpades);
        bot.getHand().getPlayableCards().add(JackOfHearts);
        bot.getHand().getPlayableCards().add(KingOfHearts);
        Assert.assertEquals(true, bot.nearFullHouse());
    }


    @Test public void testNearStraight() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(ThreeOfSpades);
        bot.getHand().getPlayableCards().add(FiveOfSpades);
        bot.getHand().getPlayableCards().add(QueenOfSpades);
        bot.getHand().getPlayableCards().add(TenOfDiamonds);
        bot.getHand().getPlayableCards().add(EightOfHearts);
        bot.getHand().getPlayableCards().add(NineOfClubs);
        bot.getHand().getPlayableCards().add(SevenOfSpades);
        Assert.assertEquals(true, bot.nearStraight());
    }

    @Test public void testNotNearStraight() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(ThreeOfSpades);
        bot.getHand().getPlayableCards().add(FiveOfSpades);
        bot.getHand().getPlayableCards().add(QueenOfSpades);
        bot.getHand().getPlayableCards().add(TenOfDiamonds);
        bot.getHand().getPlayableCards().add(TwoOfHearts);
        bot.getHand().getPlayableCards().add(NineOfClubs);
        bot.getHand().getPlayableCards().add(SevenOfSpades);
        Assert.assertEquals(false, bot.nearStraight());
    }

    @Test
    public void testNearFlushBonus() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(TenOfSpades);
        bot.getHand().getPlayableCards().add(SixOfSpades);
        bot.getHand().getPlayableCards().add(EightOfSpades);
        bot.getHand().getPlayableCards().add(TwoOfSpades);
        bot.getHand().getPlayableCards().add(KingOfDiamonds);
        Assert.assertEquals(38, bot.getHandWeight());
    }


    @Test
    public void testNearStraightBonus() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(FiveOfClubs);
        bot.getHand().getPlayableCards().add(ThreeOfSpades);
        bot.getHand().getPlayableCards().add(FourOfDiamonds);
        bot.getHand().getPlayableCards().add(JackOfSpades);
        bot.getHand().getPlayableCards().add(SixOfSpades);
        Assert.assertEquals(23, bot.getHandWeight());
    }

    @Test
    public void nearBonusShouldApplyAfterTurn() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(FiveOfDiamonds);
        bot.getHand().getPlayableCards().add(TwoOfSpades);
        bot.getHand().getPlayableCards().add(FourOfDiamonds);
        bot.getHand().getPlayableCards().add(JackOfDiamonds);
        bot.getHand().getPlayableCards().add(SixOfSpades);
        bot.getHand().getPlayableCards().add(AceOfDiamonds);
        Assert.assertEquals(26, bot.getHandWeight());
    }

    @Test public void testNearStraightFlush() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(TenOfSpades);
        bot.getHand().getPlayableCards().add(JackOfSpades);
        bot.getHand().getPlayableCards().add(EightOfSpades);
        bot.getHand().getPlayableCards().add(NineOfSpades);
        bot.getHand().getPlayableCards().add(KingOfSpades);
        bot.getHand().getPlayableCards().add(AceOfSpades);
        bot.getHand().getPlayableCards().add(SevenOfClubs);
        Assert.assertEquals(true, bot.nearStraightFlush());
    }

    @Test public void testNotNearStraightFlush() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(TenOfSpades);
        bot.getHand().getPlayableCards().add(JackOfSpades);
        bot.getHand().getPlayableCards().add(FiveOfSpades);
        bot.getHand().getPlayableCards().add(NineOfSpades);
        bot.getHand().getPlayableCards().add(TwoOfHearts);
        bot.getHand().getPlayableCards().add(FourOfDiamonds);
        bot.getHand().getPlayableCards().add(SevenOfClubs);
        Assert.assertEquals(false, bot.nearStraightFlush());
    }


    @Test
    public void bonusForNumberOfCardsBotHasInBestFiveCards() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(FiveOfDiamonds);
        bot.getHand().getPlayableCards().add(TwoOfSpades);
        bot.getHand().getPlayableCards().add(FourOfDiamonds);
        bot.getHand().getPlayableCards().add(JackOfDiamonds);
        bot.getHand().getPlayableCards().add(SixOfSpades);
        bot.getHand().getPlayableCards().add(AceOfDiamonds);
        bot.getHand().getPlayableCards().add(ThreeOfDiamonds);
        bot.getHand().getHoldEm().add(AceOfDiamonds);
        bot.getHand().getHoldEm().add(TwoOfSpades);
        Assert.assertEquals(85, bot.getHandWeight());
    }

    @Test
    public void bonusForNumberOfCardsBotHasInBestFiveCardsTWOCARDS() {
        dealer.dealHand(bot, player);
        bot.getHand().getPlayableCards().clear();
        bot.getHand().getHoldEm().clear();
        bot.getHand().getPlayableCards().add(FiveOfDiamonds);
        bot.getHand().getPlayableCards().add(TwoOfSpades);
        bot.getHand().getPlayableCards().add(FourOfDiamonds);
        bot.getHand().getPlayableCards().add(JackOfDiamonds);
        bot.getHand().getPlayableCards().add(SixOfSpades);
        bot.getHand().getPlayableCards().add(AceOfDiamonds);
        bot.getHand().getPlayableCards().add(ThreeOfDiamonds);
        bot.getHand().getHoldEm().add(FiveOfDiamonds);
        bot.getHand().getHoldEm().add(FourOfDiamonds);
        Assert.assertEquals(98, bot.getHandWeight());
    }
}