import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.Assert.*;

public class HandTest {

    @Test
    public void groupHandByRank() {
        Card card1 = new Card(Rank.JACK, Suit.HEART);
        Card card3 = new Card(Rank.SIX, Suit.SPADE);
        Card card4 = new Card(Rank.SIX, Suit.HEART);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card3);
        cards.add(card4);

        Hand hand = new Hand(card1, card3);

        hand.playableCards = cards;

        Hashtable<String, ArrayList<Card>> groupByRankTest = hand.groupByRank(hand.playableCards);

        Assert.assertEquals(card1, groupByRankTest.get(Rank.JACK.name()).get(0));
        Assert.assertEquals(card4, groupByRankTest.get(Rank.SIX.name()).get(0));
        Assert.assertEquals(card3, groupByRankTest.get(Rank.SIX.name()).get(1));
        Assert.assertEquals(1, groupByRankTest.get(Rank.JACK.name()).size());
        Assert.assertEquals(2, groupByRankTest.get(Rank.SIX.name()).size());

    }

    @Test public void groupHandBySuit() {
        Card card1 = new Card(Rank.SIX, Suit.HEART);
        Card card3 = new Card(Rank.SIX, Suit.SPADE);
        Card card4 = new Card(Rank.JACK, Suit.HEART);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card3);
        cards.add(card4);

        Hand hand = new Hand(card1, card3);

        hand.playableCards = cards;

        Hashtable<String, ArrayList<Card>> groupBySuitTest = hand.groupBySuit(hand.playableCards);

        Assert.assertEquals(card4, groupBySuitTest.get(Suit.HEART.name()).get(0));
        Assert.assertEquals(card1, groupBySuitTest.get(Suit.HEART.name()).get(1));
        Assert.assertEquals(card3, groupBySuitTest.get(Suit.SPADE.name()).get(0));
        Assert.assertEquals(2, groupBySuitTest.get(Suit.HEART.name()).size());
        Assert.assertEquals(1, groupBySuitTest.get(Suit.SPADE.name()).size());
    }

}