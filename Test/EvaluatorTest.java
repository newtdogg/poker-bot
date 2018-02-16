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
        evaluator.setHand(new Hand(JackOfHearts, FourOfHearts));
        cards.add(JackOfHearts);
        cards.add(FourOfHearts);
        cards.add(FiveOfSpades);
        cards.add(SixOfHearts);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(AceOfHearts, evaluator.highCard());
    }

    @Test
    public void setHandMethod() {
        Hand firstHand = new Hand(KingOfDiamonds, FourOfHearts);
        evaluator.setHand(firstHand);
        evaluator.setHand(new Hand(JackOfHearts, FourOfSpades));
        Assert.assertEquals(true , evaluator.getHand().getPlayableCards().contains(JackOfHearts));
    }

    @Test
    public void testIsThereIsAPair() {
        evaluator.setHand(new Hand(KingOfDiamonds, FourOfHearts));
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(JackOfHearts);
        cards.add(SevenOfClubs);
        cards.add(NineOfClubs);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(true, evaluator.pair(evaluator.getHand()));

    }

    @Test
    public void testIsThereIsThreeOfKind() {
        evaluator.setHand(new Hand(TwoOfClubs, ThreeOfSpades));
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(SevenOfHearts);
        cards.add(NineOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(true, evaluator.threeOfAKind(evaluator.getHand()));
    }

    @Test
    public void testIsThereIsFourOfKind() {
        evaluator.setHand(new Hand(KingOfClubs, AceOfSpades));
        cards.add(SixOfClubs);
        cards.add(SixOfSpades);
        cards.add(SixOfHearts);
        cards.add(SixOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(true, evaluator.fourOfAKind(evaluator.getHand()));
    }

    @Test
    public void threeOfKindFailsIfFourOfKind() {
        evaluator.setHand(new Hand(SevenOfClubs, JackOfHearts));
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(SixOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(false, evaluator.threeOfAKind(evaluator.getHand()));
    }

    @Test
    public void checkThereisFullHouse() {
        evaluator.setHand(new Hand(SevenOfClubs, JackOfHearts));
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(NineOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(true, evaluator.fullHouse(evaluator.getHand()));
    }

    @Test
    public void checkThereisNotFullHouse() {
        evaluator.setHand(new Hand(SevenOfClubs, JackOfHearts));
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(TwoOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(false, evaluator.fullHouse(evaluator.getHand()));
    }

    @Test
    public void checkTwoPair() {
        evaluator.setHand(new Hand(SevenOfClubs, JackOfHearts));
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(TwoOfClubs);
        cards.add(TwoOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(true, evaluator.twoPair(evaluator.getHand()));
    }

    @Test
    public void checkHandIsFlush() {
        evaluator.setHand(new Hand(AceOfDiamonds, FourOfHearts));
        cards.add(SixOfHearts);
        cards.add(SevenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TwoOfHearts);
        cards.add(KingOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(true, evaluator.flush(evaluator.getHand()));
    }

    @Test
    public void checkHandIsRoyalFlush() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TenOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(true, evaluator.royalFlush(evaluator.getHand()));
    }

    @Test
    public void checkHandIsStraightFlush() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(NineOfHearts);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TenOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(true, evaluator.straightFlush(evaluator.getHand()));
    }

    @Test
    public void testStraight() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(QueenOfHearts);
        cards.add(JackOfClubs);
        cards.add(TenOfHearts);
        cards.add(EightOfHearts);
        cards.add(TwoOfClubs);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(true, evaluator.straight(evaluator.getHand()));
    }

    @Test
    public void testStraightAce() {
        evaluator.setHand(new Hand(SevenOfClubs, QueenOfDiamonds));
        cards.add(AceOfHearts);
        cards.add(TwoOfHearts);
        cards.add(ThreeOfSpades);
        cards.add(FourOfDiamonds);
        cards.add(FiveOfClubs);
        evaluator.getHand().setPlayableCards(cards);
        Assert.assertEquals(true, evaluator.aceLowStraight(evaluator.getHand()));
    }

    @Test
    public void addingPairToAllAvailableHands() {
        evaluator.setHand(new Hand(KingOfDiamonds, FourOfHearts));
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(JackOfHearts);
        cards.add(SevenOfClubs);
        cards.add(NineOfClubs);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.PAIR.toString()).size());
    }

    @Test
    public void addingThreeOfAKindToAllAvailableHands() {
        evaluator.setHand(new Hand(TwoOfClubs, ThreeOfSpades));
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(SevenOfHearts);
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        evaluator.getHand().setPlayableCards(cards);

        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.THREEOFAKIND.toString()).size());
        Assert.assertEquals(0, evaluator.allAvailableHands.get(WinningHands.PAIR.toString()).size());
    }

    @Test
    public void addingFourOfAKindToAllAvailableHands() {
        evaluator.setHand(new Hand(SevenOfClubs, JackOfHearts));
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(SixOfDiamonds);
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.FOUROFAKIND.toString()).size());
    }

    @Test
    public void addingTwoPairToAllAvailableHands() {
        evaluator.setHand(new Hand(SevenOfClubs, JackOfHearts));
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(TwoOfClubs);
        cards.add(TwoOfDiamonds);
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.TWOPAIR.toString()).size());
        Assert.assertEquals(0, evaluator.allAvailableHands.get(WinningHands.PAIR.toString()).size());
    }

    @Test
    public void addingFlushToAllAvailableHands() {
        evaluator.setHand(new Hand(AceOfDiamonds, FourOfHearts));
        cards.add(SixOfHearts);
        cards.add(SevenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TwoOfHearts);
        cards.add(KingOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(FourOfSpades);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.FLUSH.toString()).size());
    }

    @Test
    public void addingStraightToAllAvailableHands() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(QueenOfHearts);
        cards.add(JackOfClubs);
        cards.add(TenOfHearts);
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.STRAIGHT.toString()).size());
    }

    @Test
    public void addingStraightFlushToAllAvailableHandsMeansHandIsAddedToStraightAndFlush() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(NineOfHearts);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TenOfHearts);
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.STRAIGHT.toString()).size());
        Assert.assertEquals(7, evaluator.allAvailableHands.get(WinningHands.FLUSH.toString()).size());

    }

    @Test
    public void returningTheBestHandofTwoHands() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(NineOfHearts);
        cards.add(KingOfDiamonds);
        cards.add(QueenOfHearts);
        cards.add(JackOfClubs);
        cards.add(TenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TwoOfClubs);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        Assert.assertEquals("STRAIGHT", evaluator.typeOfBestHand());
    }

    @Test
    public void returningTheBestHandofTwoHandsSecondTest() {
        evaluator.setHand(new Hand(KingOfDiamonds, FourOfHearts));
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(JackOfHearts);
        cards.add(SevenOfClubs);
        cards.add(NineOfClubs);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        Assert.assertEquals("PAIR", evaluator.typeOfBestHand());
    }

    @Test
    public void accessBestFiveCardsInRoyalFlushArrayAndReturnArrayList() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TenOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
    }

    @Test
    public void testHighShrink() {
        evaluator.setHand(new Hand(TwoOfClubs, KingOfDiamonds));
        cards.add(TwoOfClubs);
        cards.add(KingOfDiamonds);
        cards.add(FourOfHearts);
        cards.add(ThreeOfSpades);
        cards.add(QueenOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(KingOfDiamonds));
        Assert.assertEquals(false, evaluator.getHand().getBestFiveCards().contains(TwoOfClubs));
    }

    @Test
    public void testPairShrink() {
        evaluator.setHand(new Hand(TwoOfClubs, KingOfHearts));
        cards.add(TwoOfClubs);
        cards.add(ThreeOfSpades);
        cards.add(KingOfClubs);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(KingOfClubs));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(KingOfHearts));
    }

    @Test
    public void testTwoPairShrink() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(TwoOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfDiamonds));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfClubs));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(TwoOfClubs));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(TwoOfHearts));
    }

    @Test
    public void testThreeOfAKindShrink() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(FiveOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfDiamonds));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfClubs));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfHearts));

    }

    @Test
    public void testFullHouseShrink() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        cards.add(KingOfDiamonds);
        cards.add(KingOfHearts);
        cards.add(FiveOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfDiamonds));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfClubs));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfHearts));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(KingOfDiamonds));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(KingOfHearts));

    }

    @Test
    public void testFourOfAKindShrink() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        cards.add(FiveOfClubs);
        cards.add(FiveOfSpades);
        cards.add(FiveOfHearts);
        cards.add(ThreeOfSpades);
        cards.add(TenOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfDiamonds));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfClubs));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfHearts));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfSpades));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(TenOfHearts));

    }

    @Test
    public void accessBestFiveCardsInStraightArrayAndReturnArrayList() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(TenOfHearts);
        cards.add(NineOfDiamonds);
        cards.add(EightOfClubs);
        cards.add(SevenOfHearts);
        cards.add(SixOfClubs);
        cards.add(FiveOfClubs);
        cards.add(KingOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(TenOfHearts, evaluator.getHand().getBestFiveCards().get(0));
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
    }

    @Test
    public void accessBestFiveCardsInAceLowStraightArrayAndReturnArrayList() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(AceOfHearts);
        cards.add(KingOfClubs);
        cards.add(SevenOfHearts);
        cards.add(ThreeOfSpades);
        cards.add(TwoOfDiamonds);
        cards.add(FiveOfClubs);
        cards.add(FourOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(FiveOfClubs, evaluator.getHand().getBestFiveCards().get(0));
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
    }

    @Test
    public void accessBestFiveCardsInAceLowStraightArrayAndReturnArrayListtwo() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(AceOfHearts);
        cards.add(AceOfClubs);
        cards.add(SevenOfHearts);
        cards.add(ThreeOfSpades);
        cards.add(TwoOfDiamonds);
        cards.add(FiveOfClubs);
        cards.add(FourOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(FiveOfClubs, evaluator.getHand().getBestFiveCards().get(0));
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
    }

    @Test
    public void addNextBestCardsUpTo5() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(TenOfHearts);
        cards.add(NineOfHearts);
        cards.add(EightOfHearts);
        cards.add(SevenOfHearts);
        cards.add(SixOfHearts);
        cards.add(FiveOfClubs);
        cards.add(JackOfDiamonds);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(TenOfHearts, evaluator.getHand().getBestFiveCards().get(0));
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
    }

    @Test
    public void testingSelectBestFiveCardsHighCard() {
        evaluator.setHand(new Hand(TwoOfClubs, ThreeOfSpades));
        cards.add(FiveOfDiamonds);
        cards.add(SixOfHearts);
        cards.add(NineOfHearts);
        cards.add(AceOfSpades);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(false, evaluator.getHand().getBestFiveCards().contains(TwoOfClubs));
    }

    @Test
    public void testingbestfivecardsresents() {
        evaluator.setHand(new Hand(TwoOfClubs, FiveOfDiamonds));
        cards.add(TwoOfClubs);
        cards.add(FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(FiveOfHearts);
        cards.add(FiveOfClubs);
        cards.add(TenOfHearts);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfDiamonds));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfClubs));
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfHearts));
        cards.add(FiveOfSpades);
        evaluator.getHand().setPlayableCards(cards);
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards();
        Assert.assertEquals(5, evaluator.getHand().getBestFiveCards().size());
        Assert.assertEquals(true, evaluator.getHand().getBestFiveCards().contains(FiveOfSpades));
    }
}