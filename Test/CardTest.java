import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    @Test
    public void newCardSuit() {

        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADE);

        Assert.assertEquals(Card.Suit.SPADE, card.suit);
    }
    @Test
    public void newCardRank() {

        Card card = new Card(Card.Rank.TWO, Card.Suit.HEART);

        Assert.assertEquals(Card.Rank.TWO, card.rank);
    }
}

