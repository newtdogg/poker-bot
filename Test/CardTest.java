import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    @Test
    public void newCard() {

        Card card = new Card(Card.Rank.ACE, Card.Suit.SPADE);

        Assert.assertEquals(Card.Suit.SPADE, card.suit);
    }
}