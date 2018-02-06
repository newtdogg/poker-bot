import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BotTest {
    Deck deck;
    @Before
    public void initialize() {
        deck = new Deck();
    }
    @Test
    public void botCanHoldTwoCards() {

        Bot bot = new Bot();
        Dealer dealer = new Dealer();
        dealer.dealCards(bot);

        Assert.assertEquals(2, bot.hand.size());
    }

    @Test
    public void calculatingStartingHandWeight() {
        Bot bot = new Bot();
        Card card1 = new Card(Rank.TWO, Suit.SPADE);
        Card card2 = new Card(Rank.THREE, Suit.CLUB);
        bot.hand.add(card1);
        bot.hand.add(card2);
        Assert.assertEquals(10, bot.weighHand());
    }
}