import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest extends DeckHelper {
    @Test
    public void playerCanReturnBestFiveCards(){
        Bot bot = new Bot();
        Dealer dealer = new Dealer();
        Player player = new Player();
        dealer.dealHand(bot, player);
        bot.hand.getPlayableCards().clear();
        bot.hand.getHoldEm().clear();
        player.getHand().getPlayableCards().add(ThreeOfSpades);
        player.getHand().getPlayableCards().add(KingOfDiamonds);
        player.getHand().getPlayableCards().add(FourOfHearts);
        player.getHand().getPlayableCards().add(JackOfHearts);
        player.getHand().getPlayableCards().add(EightOfHearts);
        player.getHand().getPlayableCards().add(TwoOfHearts);
        player.getHand().getPlayableCards().add(AceOfHearts);
        player.passHandToEvaluator();
        player.getBestFive();
        Assert.assertEquals(5, player.getHand().getBestFiveCards().size());
    }
}