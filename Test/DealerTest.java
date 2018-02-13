import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealerTest {

    public Dealer dealer;
    public Bot bot;
    public Player player;

    @Before
    public void initialize(){
        player = new Player();
        dealer = new Dealer();
        bot = new Bot();
        dealer.dealHand(bot, player);
    }

    @Test
    public void dealCardsTest(){

        Assert.assertEquals(2, bot.hand.holdEm.size());
    }

    @Test
    public void dealFlop(){
        dealer.dealFlop(bot);
        Assert.assertEquals(3, dealer.board.size());
    }

    @Test
    public void dealTurn(){
        dealer.dealFlop(bot);
        dealer.dealTurn(bot);
        Assert.assertEquals(4, dealer.board.size());
    }

    @Test
    public void dealRiver(){
        dealer.dealFlop(bot);
        dealer.dealTurn(bot);
        dealer.dealRiver(bot);

        Assert.assertEquals(5, dealer.board.size());
    }

}