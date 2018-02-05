public class Card {

    public Rank rank;
    public Suit suit;

    public enum Suit {
        HEART, DIAMOND, SPADE, CLUB
    }

    public enum Rank {
        ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING
    }

    Card(Rank inputRank, Suit inputSuit) {
        this.rank = inputRank;
        this.suit = inputSuit;
    }
}