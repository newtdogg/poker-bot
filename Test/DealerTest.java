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
        dealer = new Dealer();
        player = new Player();
        bot = new Bot();
        dealer.dealHand(bot, player);
    }

    @Test
    public void dealCardsTest(){

        Assert.assertEquals(2, bot.getHand().getHoldEm().size());
    }

    @Test
    public void dealFlop(){
        dealer.dealFlop(bot, player);
        Assert.assertEquals(3, dealer.board.size());
    }

    @Test
    public void dealTurn(){
        dealer.dealFlop(bot, player);
        dealer.dealTurn(bot, player);
        Assert.assertEquals(4, dealer.board.size());
    }

    @Test
    public void dealRiver(){
        dealer.dealFlop(bot, player);
        dealer.dealTurn(bot, player);
        dealer.dealRiver(bot, player);

        Assert.assertEquals(5, dealer.board.size());
    }

}