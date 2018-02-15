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
        player.hand.playableCards.add(ThreeOfSpades);
        player.hand.playableCards.add(KingOfDiamonds);
        player.hand.playableCards.add(FourOfHearts);
        player.hand.playableCards.add(JackOfHearts);
        player.hand.playableCards.add(EightOfHearts);
        player.hand.playableCards.add(TwoOfHearts);
        player.hand.playableCards.add(AceOfHearts);
        player.passHandToEvaluator();
        player.getBestFive();
        Assert.assertEquals(5, player.hand.bestFiveCards.size());
    }
}