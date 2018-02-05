import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {
    @Test
    public void testDeckLength() {

        Deck deck = new Deck();

        Assert.assertEquals(52, deck.cards.length);
    }
}