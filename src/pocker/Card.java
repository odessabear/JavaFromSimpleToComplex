package pocker;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Card implements Comparable<Card> {

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public static Card fromString(String str) {
        char[] chars = str.toCharArray();
        return new Card(Suit.fromSymbol(chars[1]), Rank.fromSymbol(chars[0]));
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                rank == card.rank;
    }

    public String toString() {
        return rank.getSymbol() + String.valueOf(suit.getSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public int compareTo(Card card) {
        Rank[] values = Rank.values();
        List<Rank> ranks = Arrays.asList(values);
        if (ranks.indexOf(this.rank) < ranks.indexOf(card.getRank())) {
            return -1;
        } else if (ranks.indexOf(this.rank) > ranks.indexOf(card.rank)) {
            return +1;
        } else if (ranks.indexOf(this.rank) == ranks.indexOf(card.rank)) {
            return String.valueOf(suit).compareTo(String.valueOf(card.getSuit()));
        }
        return 0;
    }
}
