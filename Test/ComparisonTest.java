import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComparisonTest {

    @Test
    public void returnBestHandIfTypeOfBestHandEqual() {
        Dealer dealer = new Dealer();
        Player player = new Player();

        Bot bot1 = new Bot();
        dealer.dealHand(bot1, player);
        bot1.hand.playableCards.clear();
        bot1.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.CLUB);
        Card card3 = new Card(Rank.THREE, Suit.SPADE);
        Card card4 = new Card(Rank.THREE, Suit.DIAMOND);
        Card card5 = new Card(Rank.ACE, Suit.HEART);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.JACK, Suit.SPADE);

        bot1.hand.playableCards.add(card1);
        bot1.hand.playableCards.add(card2);
        bot1.hand.playableCards.add(card3);
        bot1.hand.playableCards.add(card4);
        bot1.hand.playableCards.add(card5);
        bot1.hand.playableCards.add(card6);
        bot1.hand.playableCards.add(card7);


        Bot bot2 = new Bot();
        dealer.dealHand(bot2, player);
        bot2.hand.playableCards.clear();
        bot2.hand.holdEm.clear();

        Card card8 = new Card(Rank.THREE, Suit.HEART);
        Card card9 = new Card(Rank.THREE, Suit.SPADE);
        Card card10 = new Card(Rank.THREE, Suit.SPADE);
        Card card11 = new Card(Rank.THREE, Suit.DIAMOND);
        Card card12 = new Card(Rank.KING, Suit.HEART);
        Card card13 = new Card(Rank.NINE, Suit.CLUB);
        Card card14 = new Card(Rank.JACK, Suit.SPADE);

        bot2.hand.playableCards.add(card8);
        bot2.hand.playableCards.add(card9);
        bot2.hand.playableCards.add(card10);
        bot2.hand.playableCards.add(card11);
        bot2.hand.playableCards.add(card12);
        bot2.hand.playableCards.add(card13);
        bot2.hand.playableCards.add(card14);


        Comparison comparison = new Comparison(bot1, bot2);

        Assert.assertEquals(bot1, comparison.compareHands());
    }

    @Test
    public void highCardComparison() {
        Dealer dealer = new Dealer();
        Player player = new Player();

        Bot bot1 = new Bot();
        dealer.dealHand(bot1, player);
        bot1.hand.playableCards.clear();
        bot1.hand.holdEm.clear();

        Card card1 = new Card(Rank.ACE, Suit.SPADE);
        Card card2 = new Card(Rank.KING, Suit.CLUB);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
        Card card6 = new Card(Rank.THREE, Suit.CLUB);
        Card card7 = new Card(Rank.TWO, Suit.SPADE);

        bot1.hand.playableCards.add(card1);
        bot1.hand.playableCards.add(card2);
        bot1.hand.playableCards.add(card3);
        bot1.hand.playableCards.add(card4);
        bot1.hand.playableCards.add(card5);
        bot1.hand.playableCards.add(card6);
        bot1.hand.playableCards.add(card7);


        Bot bot2 = new Bot();
        dealer.dealHand(bot2, player);
        bot2.hand.playableCards.clear();
        bot2.hand.holdEm.clear();

        Card card8 = new Card(Rank.ACE, Suit.HEART);
        Card card9 = new Card(Rank.KING, Suit.SPADE);
        Card card10 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card11 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card12 = new Card(Rank.SEVEN, Suit.HEART);
        Card card13 = new Card(Rank.THREE, Suit.CLUB);
        Card card14 = new Card(Rank.TWO, Suit.SPADE);

        bot2.hand.playableCards.add(card8);
        bot2.hand.playableCards.add(card9);
        bot2.hand.playableCards.add(card10);
        bot2.hand.playableCards.add(card11);
        bot2.hand.playableCards.add(card12);
        bot2.hand.playableCards.add(card13);
        bot2.hand.playableCards.add(card14);


        Comparison comparison = new Comparison(bot1, bot2);

        Assert.assertEquals(bot1, comparison.compareHands());
    }
    @Test
    public void highCardDrawComparison() {
        Dealer dealer = new Dealer();
        Player player = new Player();

        Bot bot1 = new Bot();
        dealer.dealHand(bot1, player);
        bot1.hand.playableCards.clear();
        bot1.hand.holdEm.clear();

        Card card1 = new Card(Rank.ACE, Suit.SPADE);
        Card card2 = new Card(Rank.KING, Suit.CLUB);
        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
        Card card6 = new Card(Rank.THREE, Suit.CLUB);
        Card card7 = new Card(Rank.TWO, Suit.SPADE);

        bot1.hand.playableCards.add(card1);
        bot1.hand.playableCards.add(card2);
        bot1.hand.playableCards.add(card3);
        bot1.hand.playableCards.add(card4);
        bot1.hand.playableCards.add(card5);
        bot1.hand.playableCards.add(card6);
        bot1.hand.playableCards.add(card7);


        Bot bot2 = new Bot();
        dealer.dealHand(bot2, player);
        bot2.hand.playableCards.clear();
        bot2.hand.holdEm.clear();

        Card card8 = new Card(Rank.ACE, Suit.HEART);
        Card card9 = new Card(Rank.KING, Suit.SPADE);
        Card card10 = new Card(Rank.QUEEN, Suit.SPADE);
        Card card11 = new Card(Rank.TEN, Suit.DIAMOND);
        Card card12 = new Card(Rank.EIGHT, Suit.HEART);
        Card card13 = new Card(Rank.THREE, Suit.CLUB);
        Card card14 = new Card(Rank.TWO, Suit.SPADE);

        bot2.hand.playableCards.add(card8);
        bot2.hand.playableCards.add(card9);
        bot2.hand.playableCards.add(card10);
        bot2.hand.playableCards.add(card11);
        bot2.hand.playableCards.add(card12);
        bot2.hand.playableCards.add(card13);
        bot2.hand.playableCards.add(card14);


        Comparison comparison = new Comparison(bot1, bot2);

        Assert.assertEquals(null, comparison.compareHands());
    }

    @Test
    public void fullHouseComparison() {
        Dealer dealer = new Dealer();
        Player player = new Player();

        Bot bot1 = new Bot();
        dealer.dealHand(bot1, player);
        bot1.hand.playableCards.clear();
        bot1.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.CLUB);
        Card card3 = new Card(Rank.THREE, Suit.SPADE);
        Card card4 = new Card(Rank.ACE, Suit.DIAMOND);
        Card card5 = new Card(Rank.ACE, Suit.HEART);
        Card card6 = new Card(Rank.NINE, Suit.CLUB);
        Card card7 = new Card(Rank.JACK, Suit.SPADE);

        bot1.hand.playableCards.add(card1);
        bot1.hand.playableCards.add(card2);
        bot1.hand.playableCards.add(card3);
        bot1.hand.playableCards.add(card4);
        bot1.hand.playableCards.add(card5);
        bot1.hand.playableCards.add(card6);
        bot1.hand.playableCards.add(card7);


        Bot bot2 = new Bot();
        dealer.dealHand(bot2, player);
        bot2.hand.playableCards.clear();
        bot2.hand.holdEm.clear();

        Card card8 = new Card(Rank.THREE, Suit.HEART);
        Card card9 = new Card(Rank.THREE, Suit.SPADE);
        Card card10 = new Card(Rank.THREE, Suit.SPADE);
        Card card11 = new Card(Rank.KING, Suit.DIAMOND);
        Card card12 = new Card(Rank.KING, Suit.HEART);
        Card card13 = new Card(Rank.NINE, Suit.CLUB);
        Card card14 = new Card(Rank.JACK, Suit.SPADE);

        bot2.hand.playableCards.add(card8);
        bot2.hand.playableCards.add(card9);
        bot2.hand.playableCards.add(card10);
        bot2.hand.playableCards.add(card11);
        bot2.hand.playableCards.add(card12);
        bot2.hand.playableCards.add(card13);
        bot2.hand.playableCards.add(card14);


        Comparison comparison = new Comparison(bot1, bot2);

        Assert.assertEquals(bot1, comparison.compareHands());
    }




}
