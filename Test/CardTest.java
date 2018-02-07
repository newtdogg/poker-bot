import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;


public class CardTest {
    @Test
    public void newCardSuit() {

        Card card = new Card(Rank.ACE, Suit.SPADE);

        Assert.assertEquals(Suit.SPADE, card.suit);
    }
    @Test
    public void newCardRank() {

        Card card = new Card(Rank.TWO, Suit.HEART);

        Assert.assertEquals(Rank.TWO, card.rank);
    }
    @Test
    public void sortCardArrayRank() {
        Card card1 = new Card(Rank.FIVE, Suit.HEART);
        Card card2 = new Card(Rank.THREE, Suit.HEART);
        Card card3 = new Card(Rank.KING, Suit.SPADE);

        ArrayList<Card> list = new ArrayList<Card>();
        list.add(card1);
        list.add(card2);
        list.add(card3);

        Collections.sort(list, Card.CardRankComparator);

        Assert.assertEquals(card3, list.get(0));
        Assert.assertEquals(card1, list.get(1));
        Assert.assertEquals(card2, list.get(2));
    }
//    @Test
//    public void sortCardArraySuit() {
//        Card card1 = new Card(Rank.FIVE, Suit.HEART);
//        Card card2 = new Card(Rank.THREE, Suit.DIAMOND);
//        Card card3 = new Card(Rank.KING, Suit.SPADE);
//        Card card4 = new Card(Rank.FIVE, Suit.CLUB);
//        Card card5 = new Card(Rank.THREE, Suit.DIAMOND);
//        Card card6 = new Card(Rank.KING, Suit.SPADE);
//
//        ArrayList<Card> list = new ArrayList<Card>();
//        list.add(card1);
//        list.add(card2);
//        list.add(card3);
//        list.add(card4);
//        list.add(card5);
//        list.add(card6);
//
//        Collections.sort(list, Card.CardSuitComparator);
//
//        Assert.assertEquals(card1, list.get(0));
//        Assert.assertEquals(card2, list.get(1));
//        Assert.assertEquals(card5, list.get(2));
//        Assert.assertEquals(card3, list.get(3));
//        Assert.assertEquals(card6, list.get(4));
//        Assert.assertEquals(card4, list.get(5));
//    }
}

