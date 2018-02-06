import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EvaluatorTest {
    @Test
    public void highCardOnePlayer() {

        Evaluator evaluator = new Evaluator();
        Card card1 = new Card(Rank.JACK, Suit.HEART);
        Card card2 = new Card(Rank.FOUR, Suit.HEART);
        evaluator.hand = [card1, card2];

        Assert.assertEquals(card1, evaluator.highCard());
    }
}