import java.util.Hashtable;

public class Symbols {
    public Hashtable<String, String> newRankSymbol = new Hashtable<String, String>();
    public Hashtable<String, Character> newSuitSymbol = new Hashtable<String, Character>();

    public void generateSuitSymbols() {
        newSuitSymbol.put("HEART", '\u2665');
        newSuitSymbol.put("DIAMOND", '\u2666');
        newSuitSymbol.put("SPADE", '\u2660');
        newSuitSymbol.put("CLUB", '\u2663');
    }

    public void generateRankSymbols() {
        newRankSymbol.put("ACE", "A");
        newRankSymbol.put("TWO", "2");
        newRankSymbol.put("THREE", "3");
        newRankSymbol.put("FOUR", "4");
        newRankSymbol.put("FIVE", "5");
        newRankSymbol.put("SIX", "6");
        newRankSymbol.put("SEVEN", "7");
        newRankSymbol.put("EIGHT", "8");
        newRankSymbol.put("NINE", "9");
        newRankSymbol.put("TEN", "10");
        newRankSymbol.put("JACK", "J");
        newRankSymbol.put("QUEEN", "Q");
        newRankSymbol.put("KING", "K");
    }
}
