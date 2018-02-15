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
        bot.hand.playableCards.clear();
        bot.hand.holdEm.clear();
        player.getHand().playableCards.add(ThreeOfSpades);
        player.getHand().playableCards.add(KingOfDiamonds);
        player.getHand().playableCards.add(FourOfHearts);
        player.getHand().playableCards.add(JackOfHearts);
        player.getHand().playableCards.add(EightOfHearts);
        player.getHand().playableCards.add(TwoOfHearts);
        player.getHand().playableCards.add(AceOfHearts);
        player.passHandToEvaluator();
        player.getBestFive();
        Assert.assertEquals(5, player.getHand().bestFiveCards.size());
    }
}