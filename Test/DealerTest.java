import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealerTest {
    @Test
    public void dealCardsTest(){

        Dealer dealer = new Dealer();

        Bot bot = new Bot();

        dealer.dealCards(bot);

        System.out.println(bot.hand);

        Assert.assertEquals(2, bot.hand.size());
    }

    @Test
    public void dealFlop(){

        Dealer dealer = new Dealer();

        Bot bot = new Bot();

        dealer.dealFlop(bot);

        Assert.assertEquals(3, dealer.board.size());
    }

    @Test
    public void dealTurn(){

        Dealer dealer = new Dealer();

        Bot bot = new Bot();

        dealer.dealFlop(bot);

        dealer.dealTurn(bot);

        Assert.assertEquals(4, dealer.board.size());
    }

    @Test
    public void dealRiver(){

        Dealer dealer = new Dealer();

        Bot bot = new Bot();

        dealer.dealFlop(bot);

        dealer.dealTurn(bot);

        dealer.dealRiver(bot);

        Assert.assertEquals(5, dealer.board.size());
    }

}