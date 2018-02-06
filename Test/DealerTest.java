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

}