//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//public class ComparisonTest {
//
//    Bot bot1;
//    Player player;
//    Comparison comparison;
//
//    @Before
//    public void initialize() {
//        Dealer dealer = new Dealer();
//        Player player = new Player();
//        Bot bot1 = new Bot();
//        dealer.dealHand(bot1, player);
//        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////        player.hand.playableCards.clear();
//        player.hand.holdEm.clear();
//        Comparison comparison = new Comparison(bot1, player);
//    }
//
//    @Test
//    public void returnBestHandIfTypeOfBestHandEqual() {
//
//        Card card1 = new Card(Rank.THREE, Suit.SPADE);
//        Card card2 = new Card(Rank.THREE, Suit.CLUB);
//        Card card3 = new Card(Rank.THREE, Suit.SPADE);
//        Card card4 = new Card(Rank.THREE, Suit.DIAMOND);
//        Card card5 = new Card(Rank.ACE, Suit.HEART);
//        Card card6 = new Card(Rank.NINE, Suit.CLUB);
//        Card card7 = new Card(Rank.JACK, Suit.SPADE);
//        Card card8 = new Card(Rank.FOUR, Suit.HEART);
//        Card card9 = new Card(Rank.NINE, Suit.SPADE);
//
//        bot1.hand.playableCards.add(card1);
//        bot1.hand.playableCards.add(card2);
//        bot1.hand.playableCards.add(card3);
//        bot1.hand.playableCards.add(card4);
//        bot1.hand.playableCards.add(card5);
//        bot1.hand.playableCards.add(card6);
//        bot1.hand.playableCards.add(card7);
//
//        player.hand.playableCards.add(card3);
//        player.hand.playableCards.add(card4);
//        player.hand.playableCards.add(card5);
//        player.hand.playableCards.add(card6);
//        player.hand.playableCards.add(card7);
//        player.hand.playableCards.add(card8);
//        player.hand.playableCards.add(card9);
//
//
//        Assert.assertEquals("Bot 1 wins!", comparison.compareHands());
//    }
//
//    @Test
//    public void highCardComparison() {
//
//        Card card1 = new Card(Rank.ACE, Suit.SPADE);
//        Card card2 = new Card(Rank.KING, Suit.CLUB);
//        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
//        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
//        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
//        Card card6 = new Card(Rank.THREE, Suit.CLUB);
//        Card card7 = new Card(Rank.TWO, Suit.SPADE);
//
//        bot1.hand.playableCards.add(card1);
//        bot1.hand.playableCards.add(card2);
//        bot1.hand.playableCards.add(card3);
//        bot1.hand.playableCards.add(card4);
//        bot1.hand.playableCards.add(card5);
//        bot1.hand.playableCards.add(card6);
//        bot1.hand.playableCards.add(card7);
//
//        Card card8 = new Card(Rank.ACE, Suit.HEART);
//        Card card9 = new Card(Rank.KING, Suit.SPADE);
//
//        player.hand.playableCards.add(card3);
//        player.hand.playableCards.add(card4);
//        player.hand.playableCards.add(card5);
//        player.hand.playableCards.add(card6);
//        player.hand.playableCards.add(card7);
//        player.hand.playableCards.add(card8);
//        player.hand.playableCards.add(card9);
//
//        Comparison comparison = new Comparison(bot1, player);
//
//        Assert.assertEquals("Bot 1 wins!", comparison.compareHands());
//    }
//
////    @Test
////    public void highCardDrawComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.ACE, Suit.SPADE);
////        Card card2 = new Card(Rank.KING, Suit.CLUB);
////        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card6 = new Card(Rank.THREE, Suit.CLUB);
////        Card card7 = new Card(Rank.TWO, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.ACE, Suit.HEART);
////        Card card9 = new Card(Rank.KING, Suit.SPADE);
////        Card card10 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card11 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card12 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card13 = new Card(Rank.THREE, Suit.CLUB);
////        Card card14 = new Card(Rank.TWO, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("It's a draw!", comparison.compareHands());
////    }
////
////    @Test
////    public void pairComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.ACE, Suit.SPADE);
////        Card card2 = new Card(Rank.ACE, Suit.CLUB);
////        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card6 = new Card(Rank.THREE, Suit.CLUB);
////        Card card7 = new Card(Rank.TWO, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.KING, Suit.HEART);
////        Card card9 = new Card(Rank.KING, Suit.SPADE);
////        Card card10 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card11 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card12 = new Card(Rank.SEVEN, Suit.HEART);
////        Card card13 = new Card(Rank.THREE, Suit.CLUB);
////        Card card14 = new Card(Rank.TWO, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("Bot 1 wins!", comparison.compareHands());
////    }
////
////    @Test
////    public void pairDrawComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.KING, Suit.SPADE);
////        Card card2 = new Card(Rank.KING, Suit.CLUB);
////        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card6 = new Card(Rank.THREE, Suit.CLUB);
////        Card card7 = new Card(Rank.TWO, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.KING, Suit.HEART);
////        Card card9 = new Card(Rank.KING, Suit.SPADE);
////        Card card10 = new Card(Rank.JACK, Suit.SPADE);
////        Card card11 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card12 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card13 = new Card(Rank.THREE, Suit.CLUB);
////        Card card14 = new Card(Rank.TWO, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("Bot 1 wins!", comparison.compareHands());
////    }
////
////    @Test
////    public void pairTotalDrawComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.KING, Suit.SPADE);
////        Card card2 = new Card(Rank.KING, Suit.CLUB);
////        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card6 = new Card(Rank.THREE, Suit.CLUB);
////        Card card7 = new Card(Rank.TWO, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.KING, Suit.HEART);
////        Card card9 = new Card(Rank.KING, Suit.SPADE);
////        Card card10 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card11 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card12 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card13 = new Card(Rank.THREE, Suit.CLUB);
////        Card card14 = new Card(Rank.TWO, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("It's a draw!", comparison.compareHands());
////    }
////
////    @Test
////    public void twoPairHighPairComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.ACE, Suit.SPADE);
////        Card card2 = new Card(Rank.ACE, Suit.CLUB);
////        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card4 = new Card(Rank.QUEEN, Suit.DIAMOND);
////        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card6 = new Card(Rank.THREE, Suit.CLUB);
////        Card card7 = new Card(Rank.TWO, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.KING, Suit.HEART);
////        Card card9 = new Card(Rank.KING, Suit.SPADE);
////        Card card10 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card11 = new Card(Rank.QUEEN, Suit.DIAMOND);
////        Card card12 = new Card(Rank.SEVEN, Suit.HEART);
////        Card card13 = new Card(Rank.THREE, Suit.CLUB);
////        Card card14 = new Card(Rank.TWO, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("Bot 1 wins!", comparison.compareHands());
////    }
////
////    @Test
////    public void twoPairLowPairComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.KING, Suit.SPADE);
////        Card card2 = new Card(Rank.KING, Suit.CLUB);
////        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card4 = new Card(Rank.QUEEN, Suit.DIAMOND);
////        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card6 = new Card(Rank.THREE, Suit.CLUB);
////        Card card7 = new Card(Rank.TWO, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.KING, Suit.HEART);
////        Card card9 = new Card(Rank.KING, Suit.SPADE);
////        Card card10 = new Card(Rank.JACK, Suit.SPADE);
////        Card card11 = new Card(Rank.JACK, Suit.DIAMOND);
////        Card card12 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card13 = new Card(Rank.THREE, Suit.CLUB);
////        Card card14 = new Card(Rank.TWO, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("Bot 1 wins!", comparison.compareHands());
////    }
////
////    @Test
////    public void twoPairDrawComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.KING, Suit.SPADE);
////        Card card2 = new Card(Rank.KING, Suit.CLUB);
////        Card card3 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card4 = new Card(Rank.QUEEN, Suit.DIAMOND);
////        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card6 = new Card(Rank.THREE, Suit.CLUB);
////        Card card7 = new Card(Rank.TWO, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.KING, Suit.HEART);
////        Card card9 = new Card(Rank.KING, Suit.SPADE);
////        Card card10 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card11 = new Card(Rank.QUEEN, Suit.DIAMOND);
////        Card card12 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card13 = new Card(Rank.THREE, Suit.CLUB);
////        Card card14 = new Card(Rank.TWO, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("It's a draw!", comparison.compareHands());
////    }
////
////    @Test
////    public void threeOfComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.ACE, Suit.SPADE);
////        Card card2 = new Card(Rank.ACE, Suit.CLUB);
////        Card card3 = new Card(Rank.ACE, Suit.SPADE);
////        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card6 = new Card(Rank.THREE, Suit.CLUB);
////        Card card7 = new Card(Rank.TWO, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.QUEEN, Suit.HEART);
////        Card card9 = new Card(Rank.QUEEN, Suit.DIAMOND);
////        Card card10 = new Card(Rank.QUEEN, Suit.SPADE);
////        Card card11 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card12 = new Card(Rank.SEVEN, Suit.HEART);
////        Card card13 = new Card(Rank.THREE, Suit.CLUB);
////        Card card14 = new Card(Rank.TWO, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("Bot 1 wins!", comparison.compareHands());
////    }
////
////    @Test
////    public void threeOfDrawComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.KING, Suit.SPADE);
////        Card card2 = new Card(Rank.KING, Suit.CLUB);
////        Card card3 = new Card(Rank.KING, Suit.SPADE);
////        Card card4 = new Card(Rank.JACK, Suit.DIAMOND);
////        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card6 = new Card(Rank.THREE, Suit.CLUB);
////        Card card7 = new Card(Rank.TWO, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.KING, Suit.HEART);
////        Card card9 = new Card(Rank.KING, Suit.SPADE);
////        Card card10 = new Card(Rank.KING, Suit.SPADE);
////        Card card11 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card12 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card13 = new Card(Rank.THREE, Suit.CLUB);
////        Card card14 = new Card(Rank.TWO, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("Bot 1 wins!", comparison.compareHands());
////    }
////
////    @Test
////    public void threeOfTotalDrawComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.KING, Suit.SPADE);
////        Card card2 = new Card(Rank.KING, Suit.CLUB);
////        Card card3 = new Card(Rank.KING, Suit.SPADE);
////        Card card4 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card5 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card6 = new Card(Rank.THREE, Suit.CLUB);
////        Card card7 = new Card(Rank.TWO, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.KING, Suit.HEART);
////        Card card9 = new Card(Rank.KING, Suit.SPADE);
////        Card card10 = new Card(Rank.KING, Suit.SPADE);
////        Card card11 = new Card(Rank.TEN, Suit.DIAMOND);
////        Card card12 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card13 = new Card(Rank.THREE, Suit.CLUB);
////        Card card14 = new Card(Rank.TWO, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("It's a draw!", comparison.compareHands());
////    }
////
////
////    @Test
////    public void fullHouseComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.THREE, Suit.SPADE);
////        Card card2 = new Card(Rank.THREE, Suit.CLUB);
////        Card card3 = new Card(Rank.THREE, Suit.SPADE);
////        Card card4 = new Card(Rank.ACE, Suit.DIAMOND);
////        Card card5 = new Card(Rank.ACE, Suit.HEART);
////        Card card6 = new Card(Rank.NINE, Suit.CLUB);
////        Card card7 = new Card(Rank.JACK, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.THREE, Suit.HEART);
////        Card card9 = new Card(Rank.THREE, Suit.SPADE);
////        Card card10 = new Card(Rank.THREE, Suit.SPADE);
////        Card card11 = new Card(Rank.KING, Suit.DIAMOND);
////        Card card12 = new Card(Rank.KING, Suit.HEART);
////        Card card13 = new Card(Rank.NINE, Suit.CLUB);
////        Card card14 = new Card(Rank.JACK, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("Bot 1 wins!", comparison.compareHands());
////    }
////
////    @Test public void differentHandComparison() {
////        Dealer dealer = new Dealer();
////        Player player = new Player();
////
////        Bot bot1 = new Bot();
////        dealer.dealHand(bot1, player);
////        bot1.hand.playableCards.clear();
////        bot1.hand.holdEm.clear();
////
////        Card card1 = new Card(Rank.ACE, Suit.SPADE);
////        Card card2 = new Card(Rank.THREE, Suit.CLUB);
////        Card card3 = new Card(Rank.THREE, Suit.SPADE);
////        Card card4 = new Card(Rank.THREE, Suit.DIAMOND);
////        Card card5 = new Card(Rank.ACE, Suit.HEART);
////        Card card6 = new Card(Rank.NINE, Suit.CLUB);
////        Card card7 = new Card(Rank.JACK, Suit.SPADE);
////
////        bot1.hand.playableCards.add(card1);
////        bot1.hand.playableCards.add(card2);
////        bot1.hand.playableCards.add(card3);
////        bot1.hand.playableCards.add(card4);
////        bot1.hand.playableCards.add(card5);
////        bot1.hand.playableCards.add(card6);
////        bot1.hand.playableCards.add(card7);
////
////
////        Bot player = new Bot();
////        dealer.dealHand(player, player);
////        player.hand.playableCards.clear();
////        player.hand.holdEm.clear();
////
////        Card card8 = new Card(Rank.EIGHT, Suit.HEART);
////        Card card9 = new Card(Rank.THREE, Suit.SPADE);
////        Card card10 = new Card(Rank.THREE, Suit.SPADE);
////        Card card11 = new Card(Rank.THREE, Suit.DIAMOND);
////        Card card12 = new Card(Rank.KING, Suit.HEART);
////        Card card13 = new Card(Rank.NINE, Suit.CLUB);
////        Card card14 = new Card(Rank.JACK, Suit.SPADE);
////
////        player.hand.playableCards.add(card8);
////        player.hand.playableCards.add(card9);
////        player.hand.playableCards.add(card10);
////        player.hand.playableCards.add(card11);
////        player.hand.playableCards.add(card12);
////        player.hand.playableCards.add(card13);
////        player.hand.playableCards.add(card14);
////
////
////        Comparison comparison = new Comparison(bot1, player);
////
////        Assert.assertEquals("Bot 1 wins!", comparison.compareHands());
////    }
//
//
//}
