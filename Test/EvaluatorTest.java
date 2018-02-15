import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;


public class EvaluatorTest extends DeckHelper {

    public Evaluator evaluator;
    public ArrayList<Card> cards;

    @Before
    public void initialize() {
        evaluator = new Evaluator();
        cards = new ArrayList<Card>();
    }

    @Test
    public void highCardOnePlayer() {
        evaluator.hand = new Hand(JackOfHearts, FourOfHearts);
        cards.add(JackOfHearts);
        cards.add(FourOfHearts);
        cards.add(FiveOfSpades);
        cards.add(SixOfHearts);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(AceOfHearts, evaluator.highCard());
    }

    @Test
    public void testIsThereIsAPair() {
        evaluator.hand = new Hand(KingOfDiamonds, FourOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(JackOfHearts);
        cards.add(SevenOfClubs);
        cards.add(NineOfClubs);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.pair(evaluator.hand));

    }

    @Test
    public void testIsThereIsThreeOfKind() {
        evaluator.hand = new Hand(TwoOfClubs, ThreeOfSpades);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(SevenOfHearts);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.threeOfAKind(evaluator.hand));
    }

    @Test
    public void testIsThereIsFourOfKind() {
        evaluator.hand = new Hand(KingOfClubs, AceOfSpades);
        cards.add(SixOfClubs);
        cards.add(SixOfSpades);
        cards.add(SixOfHearts);
        cards.add(SixOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.fourOfAKind(evaluator.hand));
    }

    @Test
    public void threeOfKindFailsIfFourOfKind() {
        evaluator.hand = new Hand(SevenOfClubs, JackOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(SixOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(false, evaluator.threeOfAKind(evaluator.hand));
    }

    @Test
    public void checkThereisFullHouse() {
        evaluator.hand = new Hand(SevenOfClubs, JackOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(NineOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.fullHouse(evaluator.hand));
    }

    @Test
    public void checkThereisNotFullHouse() {
        evaluator.hand = new Hand(SevenOfClubs, JackOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(TwoOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(false, evaluator.fullHouse(evaluator.hand));
    }

    @Test
    public void checkTwoPair() {
        evaluator.hand = new Hand(SevenOfClubs, JackOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(TwoOfClubs);
        cards.add(TwoOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.twoPair(evaluator.hand));
    }

    @Test
    public void checkHandIsFlush() {
        evaluator.hand = new Hand(AceOfDiamonds, FourOfHearts);
        cards.add(SixOfHearts);
        cards.add(SevenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TwoOfHearts);
        cards.add(KingOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.flush(evaluator.hand));
    }

    @Test
    public void checkHandIsRoyalFlush() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.royalFlush(evaluator.hand));
    }

    @Test
    public void checkHandIsStraightFlush() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(NineOfHearts);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.straightFlush(evaluator.hand));
    }

    @Test
    public void testStraight() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(QueenOfHearts);
        cards.add(JackOfClubs);
        cards.add(TenOfHearts);
        cards.add(EightOfHearts);
        cards.add(TwoOfClubs);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.straight(evaluator.hand));
    }

    @Test
    public void testStraightAce() {
        evaluator.hand = new Hand(SevenOfClubs, QueenOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(TwoOfHearts);
        cards.add(ThreeOfSpades);
        cards.add(FourOfDiamonds);
        cards.add(FiveOfClubs);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.aceLowStraight(evaluator.hand));
    }

    @Test
    public void addingPairToAllAvailableHands() {
        evaluator.hand = new Hand(KingOfDiamonds, FourOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(JackOfHearts);
        cards.add(SevenOfClubs);
        cards.add(NineOfClubs);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.PAIR.toString()).size());
    }

    @Test
    public void addingThreeOfAKindToAllAvailableHands() {
        evaluator.hand = new Hand(TwoOfClubs, ThreeOfSpades);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(SevenOfHearts);
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        evaluator.hand.playableCards = cards;

        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.THREEOFAKIND.toString()).size());
        Assert.assertEquals(0, evaluator.allAvailableHands.get(WinningHands.PAIR.toString()).size());
    }

    @Test
    public void addingFourOfAKindToAllAvailableHands() {
        evaluator.hand = new Hand(SevenOfClubs, JackOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(SixOfDiamonds);
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.FOUROFAKIND.toString()).size());
    }

    @Test
    public void addingTwoPairToAllAvailableHands() {
        evaluator.hand = new Hand(SevenOfClubs, JackOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(TwoOfClubs);
        cards.add(TwoOfDiamonds);
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.TWOPAIR.toString()).size());
        Assert.assertEquals(0, evaluator.allAvailableHands.get(WinningHands.PAIR.toString()).size());
    }

    @Test
    public void addingFlushToAllAvailableHands() {
        evaluator.hand = new Hand(AceOfDiamonds, FourOfHearts);
        cards.add(SixOfHearts);
        cards.add(SevenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TwoOfHearts);
        cards.add(KingOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(FourOfSpades);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.FLUSH.toString()).size());
    }

    @Test
    public void addingStraightToAllAvailableHands() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(QueenOfHearts);
        cards.add(JackOfClubs);
        cards.add(TenOfHearts);
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.STRAIGHT.toString()).size());
    }

    @Test
    public void addingStraightFlushToAllAvailableHandsMeansHandIsAddedToStraightAndFlush() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(NineOfHearts);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TenOfHearts);
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.STRAIGHT.toString()).size());
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.FLUSH.toString()).size());

    }

    @Test
    public void returningTheBestHandofTwoHands() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(QueenOfHearts);
        cards.add(JackOfClubs);
        cards.add(TenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TwoOfClubs);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        Assert.assertEquals("STRAIGHT", evaluator.typeOfBestHand());
    }

    @Test
    public void returningTheBestHandofTwoHandsSecondTest() {
        evaluator.hand = new Hand(KingOfDiamonds, FourOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(JackOfHearts);
        cards.add(SevenOfClubs);
        cards.add(NineOfClubs);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        Assert.assertEquals("PAIR", evaluator.typeOfBestHand());
    }

    @Test
    public void accessBestFiveCardsInRoyalFlushArrayAndReturnArrayList() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
    }

    @Test
    public void testHighShrink() {
        evaluator.hand = new Hand(TwoOfClubs, KingOfDiamonds);
        cards.add(TwoOfClubs);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        cards.add(ThreeOfSpades);
        cards.add(QueenOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(KingOfDiamonds));
        Assert.assertEquals(false, evaluator.hand.bestFiveCards.contains(TwoOfClubs));
    }

    @Test
    public void testPairShrink() {
        evaluator.hand = new Hand(TwoOfClubs, KingOfHearts);
        cards.add(TwoOfClubs);
        cards.add(ThreeOfSpades);
        cards.add(KingOfClubs);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(KingOfClubs));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(KingOfHearts));
    }

    @Test
    public void testTwoPairShrink() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(TwoOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfDiamonds));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfClubs));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(TwoOfClubs));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(TwoOfHearts));
    }

    @Test
    public void testThreeOfAKindShrink() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(FiveOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfDiamonds));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfClubs));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfHearts));

    }

    @Test
    public void testFullHouseShrink() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        cards.add(KingOfDiamonds);
        cards.add(KingOfHearts);
        cards.add(FiveOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfDiamonds));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfClubs));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfHearts));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(KingOfDiamonds));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(KingOfHearts));

    }

    @Test
    public void testFourOfAKindShrink() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        cards.add(FiveOfClubs);
        cards.add(FiveOfSpades);
        cards.add(FiveOfHearts);
        cards.add(ThreeOfSpades);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfDiamonds));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfClubs));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfHearts));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfSpades));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(TenOfHearts));

    }

    @Test
    public void accessBestFiveCardsInStraightArrayAndReturnArrayList() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(TenOfHearts);
        cards.add(NineOfDiamonds);
        cards.add(EightOfClubs);
        cards.add(SevenOfHearts);
        cards.add(SixOfClubs);
        cards.add(FiveOfClubs);
        cards.add(KingOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(TenOfHearts, evaluator.hand.bestFiveCards.get(0));
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
    }

    @Test
    public void accessBestFiveCardsInAceLowStraightArrayAndReturnArrayList() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(KingOfClubs);
        cards.add(SevenOfHearts);
        cards.add(ThreeOfSpades);
        cards.add(TwoOfDiamonds);
        cards.add(FiveOfClubs);
        cards.add(FourOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(FiveOfClubs, evaluator.hand.bestFiveCards.get(0));
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
    }

    @Test
    public void accessBestFiveCardsInAceLowStraightArrayAndReturnArrayListtwo() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(AceOfClubs);
        cards.add(SevenOfHearts);
        cards.add(ThreeOfSpades);
        cards.add(TwoOfDiamonds);
        cards.add(FiveOfClubs);
        cards.add(FourOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(FiveOfClubs, evaluator.hand.bestFiveCards.get(0));
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
    }

    @Test
    public void addNextBestCardsUpTo5() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(TenOfHearts);
        cards.add(NineOfHearts);
        cards.add(EightOfHearts);
        cards.add(SevenOfHearts);
        cards.add(SixOfHearts);
        cards.add(FiveOfClubs);
        cards.add(JackOfDiamonds);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(TenOfHearts, evaluator.hand.bestFiveCards.get(0));
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
    }

    @Test
    public void testingSelectBestFiveCardsHighCard() {
        evaluator.hand = new Hand(TwoOfClubs, ThreeOfSpades);
        cards.add(FiveOfDiamonds);
        cards.add(SixOfHearts);
        cards.add(NineOfHearts);
        cards.add(AceOfSpades);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(false, evaluator.hand.bestFiveCards.contains(TwoOfClubs));
    }

    @Test
    public void testingbestfivecardsresents() {
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(FiveOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfDiamonds));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfClubs));
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfHearts));
        cards.add(FiveOfSpades);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size());
        Assert.assertEquals(true, evaluator.hand.bestFiveCards.contains(FiveOfSpades));
    }
}