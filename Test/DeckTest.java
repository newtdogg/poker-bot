import org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;

public class DeckTest {
    Deck deck;
    @Before public void initialize() {
        deck = new Deck();
    }
    @Test public void testDeckLength() {

        deck.createDeck();
        Assert.assertEquals(52, deck.cards.size());
    }
    @Test public void testDeckUnique() {
        deck = new Deck();
        deck.createDeck();
        for(int i = 0; i < deck.cardsArray.size(); i++) {
            for(int x = 0; x < deck.cardsArray.size(); x++) {
                if (deck.cardsArray.get(i) != deck.cardsArray.get(x)) {
                    Assert.assertEquals(false, deck.cardsArray.get(i) == deck.cardsArray.get(x));
                }
            }
        }
    }
}