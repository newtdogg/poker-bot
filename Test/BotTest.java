import org.junit.Assert;
import org.junit.Test;

public class BotTest {
    @Test public void botCanHoldTwoCards() {
        Bot bot = new Bot();

        Assert.assertEquals(2, bot.hand.size());
    }
}