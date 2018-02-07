import java.util.Comparator;

public class Card {

    public Rank rank;
    public Suit suit;

    Card(Rank inputRank, Suit inputSuit) {
        this.rank = inputRank;
        this.suit = inputSuit;
    }

    public static Comparator<Card> CardRankComparator = new Comparator<Card>() {
        @Override
        public int compare(Card c1, Card c2) {
            int rank1 = Rank.valueOf(c1.rank.name()).ordinal();
            int rank2 = Rank.valueOf(c2.rank.name()).ordinal();

            return rank2-rank1;
        }
    };
}