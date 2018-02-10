import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;


public class EvaluatorTest {

    public Evaluator evaluator;
    public ArrayList<Card> cards;
    public Card AceOfSpades;
    public Card TwoOfSpades;
    public Card ThreeOfSpades;
    public Card FourOfSpades;
    public Card FiveOfSpades;
    public Card SixOfSpades;
    public Card SevenOfSpades;
    public Card EightOfSpades;
    public Card NineOfSpades;
    public Card TenOfSpades;
    public Card JackOfSpades;
    public Card QueenOfSpades;
    public Card KingOfSpades;
    public Card AceOfDiamonds;
    public Card TwoOfDiamonds;
    public Card ThreeOfDiamonds;
    public Card FourOfDiamonds;
    public Card FiveOfDiamonds;
    public Card SixOfDiamonds;
    public Card SevenOfDiamonds;
    public Card EightOfDiamonds;
    public Card NineOfDiamonds;
    public Card TenOfDiamonds;
    public Card JackOfDiamonds;
    public Card QueenOfDiamonds;
    public Card KingOfDiamonds;
    public Card AceOfClubs;
    public Card TwoOfClubs;
    public Card ThreeOfClubs;
    public Card FourOfClubs;
    public Card FiveOfClubs;
    public Card SixOfClubs;
    public Card SevenOfClubs;
    public Card EightOfClubs;
    public Card NineOfClubs;
    public Card TenOfClubs;
    public Card JackOfClubs;
    public Card QueenOfClubs;
    public Card KingOfClubs;
    public Card AceOfHearts;
    public Card TwoOfHearts;
    public Card ThreeOfHearts;
    public Card FourOfHearts;
    public Card FiveOfHearts;
    public Card SixOfHearts;
    public Card SevenOfHearts;
    public Card EightOfHearts;
    public Card NineOfHearts;
    public Card TenOfHearts;
    public Card JackOfHearts;
    public Card QueenOfHearts;
    public Card KingOfHearts;

    @Before public void initialize(){
        evaluator = new Evaluator();
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
    }

    @Test public void highCardOnePlayer() {
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

    @Test public void testIsThereIsAPair() {
        evaluator.hand = new Hand(KingOfDiamonds, FourOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(JackOfHearts);
        cards.add(SevenOfClubs);
        cards.add(NineOfClubs);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.pair(evaluator.hand));

    }

    @Test public void testIsThereIsThreeOfKind() {
        evaluator.hand = new Hand(TwoOfClubs, ThreeOfSpades);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(SevenOfHearts);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.threeOfAKind(evaluator.hand));
    }

    @Test public void testIsThereIsFourOfKind() {
        evaluator.hand = new Hand(KingOfClubs, AceOfSpades);
        cards.add(SixOfClubs);
        cards.add(SixOfSpades);
        cards.add(SixOfHearts);
        cards.add(SixOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.fourOfAKind(evaluator.hand));
    }

    @Test public void threeOfKindFailsIfFourOfKind() {
        evaluator.hand = new Hand(SevenOfClubs, JackOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(SixOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(false, evaluator.threeOfAKind(evaluator.hand));
    }

    @Test public void checkThereisFullHouse() {
        evaluator.hand = new Hand(SevenOfClubs, JackOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(NineOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.fullHouse(evaluator.hand));
    }

    @Test public void checkThereisNotFullHouse() {
        evaluator.hand = new Hand(SevenOfClubs, JackOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(SixOfClubs);
        cards.add(TwoOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(false, evaluator.fullHouse(evaluator.hand));
    }

    @Test public void checkTwoPair() {
        evaluator.hand = new Hand(SevenOfClubs, JackOfHearts);
        cards.add(SixOfHearts);
        cards.add(SixOfSpades);
        cards.add(TwoOfClubs);
        cards.add(TwoOfDiamonds);
        cards.add(NineOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.twoPair(evaluator.hand));
    }

    @Test public void checkHandIsFlush(){
        evaluator.hand = new Hand(AceOfDiamonds, FourOfHearts);
        cards.add(SixOfHearts);
        cards.add(SevenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TwoOfHearts);
        cards.add(KingOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.flush(evaluator.hand));
    }

    @Test public void checkHandIsRoyalFlush(){
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.royalFlush(evaluator.hand));
    }

    @Test public void checkHandIsStraightFlush(){
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(NineOfHearts);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.straightFlush(evaluator.hand));
    }

    @Test public void testStraight(){
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

    @Test public void testStraightAce() {
        evaluator.hand = new Hand(SevenOfClubs, QueenOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(TwoOfHearts);
        cards.add(ThreeOfSpades);
        cards.add(FourOfDiamonds);
        cards.add(FiveOfClubs);
        evaluator.hand.playableCards = cards;
        Assert.assertEquals(true, evaluator.aceLowStraight(evaluator.hand));
    }

    @Test public void addingPairToAllAvailableHands() {
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

    @Test public void addingThreeOfAKindToAllAvailableHands() {
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

    @Test public void addingFourOfAKindToAllAvailableHands() {
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

    @Test public void addingTwoPairToAllAvailableHands() {
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

    @Test public void addingFlushToAllAvailableHands() {
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

    @Test public void addingStraightToAllAvailableHands() {
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

    @Test public void addingStraightFlushToAllAvailableHandsMeansHandIsAddedToStraightAndFlush() {
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

    @Test public void returningTheBestHandofTwoHands(){
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

    @Test public void returningTheBestHandofTwoHandsSecondTest(){
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

    @Test public void accessBestFiveCardsInRoyalFlushArrayAndReturnArrayList(){
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(AceOfHearts);
        cards.add(KingOfHearts);
        cards.add(QueenOfHearts);
        cards.add(JackOfHearts);
        cards.add(TenOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards(evaluator.hand);
        System.out.println(evaluator.hand.bestFiveCards);
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size() );
    }

    @Test public void accessBestFiveCardsInStraightArrayAndReturnArrayList(){
        evaluator.hand = new Hand(TwoOfClubs, FiveOfDiamonds);
        cards.add(TenOfHearts);
        cards.add(NineOfDiamonds);
        cards.add(EightOfClubs);
        cards.add(SevenOfHearts);
        cards.add(SixOfClubs);
        cards.add(FiveOfClubs);
        cards.add(FourOfHearts);
        evaluator.hand.playableCards = cards;
        evaluator.categoriseAvailableHands();
        evaluator.selectBestFiveCards(evaluator.hand);
        Assert.assertEquals(TenOfHearts, evaluator.hand.bestFiveCards.get(0) );
        Assert.assertEquals(5, evaluator.hand.bestFiveCards.size() );
    }

}