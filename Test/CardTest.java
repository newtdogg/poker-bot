import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    @Test
    public void newCardSuit() {

        Card card = new Card(Rank.ACE, Suit.SPADE);

        Assert.assertEquals(Suit.SPADE, card.suit);
    }
    @Test
    public void newCardRank() {

        Card card = new Card(Rank.TWO, Suit.HEART);

        Assert.assertEquals(Rank.TWO, card.rank);
    }
}

