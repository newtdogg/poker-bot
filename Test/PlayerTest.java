import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void playerCanReturnBestFiveCards(){
        Bot bot = new Bot();
        Dealer dealer = new Dealer();
        Player player = new Player();

        dealer.dealHand(bot, player);
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();

        Card card1 = new Card(Rank.THREE, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.DIAMOND);
        Card card3 = new Card(Rank.JACK, Suit.SPADE);
        Card card4 = new Card(Rank.JACK, Suit.HEART);
        Card card5 = new Card(Rank.EIGHT, Suit.SPADE);
        Card card6 = new Card(Rank.KING, Suit.HEART);
        Card card7 = new Card(Rank.ACE, Suit.HEART);

        player.hand.playableCards.add(card1);
        player.hand.playableCards.add(card2);
        player.hand.playableCards.add(card3);
        player.hand.playableCards.add(card4);
        player.hand.playableCards.add(card5);
        player.hand.playableCards.add(card6);
        player.hand.playableCards.add(card7);

        player.passHandToEvaluator();
        player.getBestFive();
        Assert.assertEquals(5, player.hand.bestFiveCards.size());
    }
}