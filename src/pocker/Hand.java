package pocker;

import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {

    private final Set<Card> cardSet;
    private static ComparisonStrategy comparisonStrategy = new BaseStrategy();
    private Value handValue = null;

    private Hand(Set<Card> cardSet) {
        if (cardSet.size() != 5) {
            throw new IllegalArgumentException("Card hand should contain exactly 5 unique cards.Cards are: " + cardSet);
        }
        this.cardSet = Collections.unmodifiableSet(cardSet);
    }

    public static Hand fromString(String hand) {
        Set<Card> cardSet = new HashSet<>();
        String[] cards = hand.split(" ");
        for (String card : cards) {
            if (!"".equals(card) && !" ".equals(card)) {
                cardSet.add(Card.fromString(card));
            }
        }
        return new Hand(cardSet);
    }

    public Value calcHandValue() {
        if (handValue == null) {
            handValue = estimateHandValue();
        }
        return handValue;
    }

    private Value estimateHandValue() {
        Set<Suit> suits = getUniqueSuits(cardSet);
        Set<Rank> ranks = getUniqueRanks(cardSet);
        Map<Rank, List<Card>> groupedByRanks = groupCardsByRank(cardSet);
        switch (ranks.size()) {
            case 5:
                if (suits.size() == 1) {
                    return checkKindOfFlush(ranks);
                }
                if (isSequence(ranks)) {
                    return Value.STRAIGHT;
                }
                return Value.HIGH_CARD;
            case 4:
                return Value.ONE_PAIR;
            case 3:
                return checkTwoPairsOrThreeOfAKind(groupedByRanks);
            case 2:
                return checkFullHouseOrFourOfAKind(groupedByRanks);
            default:
                return Value.HIGH_CARD;
        }
    }

    private Map<Rank, List<Card>> groupCardsByRank(Set<Card> cardSet) {
        Map<Rank, List<Card>> groupedByRank = new HashMap<>();
        for (Card card : cardSet) {
            List<Card> cards = groupedByRank.get(card.getRank());
            if (cards == null) {
                List<Card> cardList = new ArrayList<>();
                cardList.add(card);
                groupedByRank.put(card.getRank(), cardList);
            } else {
                cards.add(card);
            }
        }
        return groupedByRank;
    }

    private Set<Rank> getUniqueRanks(Set<Card> cardSet) {
        Set<Rank> rankSet = new HashSet<>();
        for (Card card : cardSet) {
            rankSet.add(card.getRank());
        }
        return rankSet;
    }

    private Set<Suit> getUniqueSuits(Set<Card> cardSet) {
        Set<Suit> suitSet = new HashSet<>();
        for (Card card : cardSet) {
            suitSet.add(card.getSuit());
        }
        return suitSet;
    }

    private Value checkFullHouseOrFourOfAKind(Map<Rank, List<Card>> groupedByRanks) {
        for (Map.Entry<Rank, List<Card>> c : groupedByRanks.entrySet()) {
            if (c.getValue().size() == 2 || c.getValue().size() == 3) {
                return Value.FULL_HOUSE;
            }
            if (c.getValue().size() == 4 || c.getValue().size() == 1) {
                return Value.FOUR_OF_A_KIND;
            }
        }
        return Value.HIGH_CARD;
    }

    private Value checkKindOfFlush(Set<Rank> ranks) {
        if (isSequence(ranks)) {
            if (ranks.contains(Rank.ACE)) {
                return Value.ROYAL_FLUSH;
            } else {
                return Value.STRAIGHT_FLUSH;
            }
        }
        return Value.FLUSH;
    }

    private Value checkTwoPairsOrThreeOfAKind(Map<Rank, List<Card>> groupedByRanks) {
        for (Map.Entry<Rank, List<Card>> c : groupedByRanks.entrySet()) {
            if (c.getValue().size() == 3) {
                return Value.THREE_OF_A_KIND;
            }
            if (c.getValue().size() == 2) {
                return Value.TWO_PAIRS;
            }
        }
        return Value.HIGH_CARD;
    }

    private boolean isSequence(Set<Rank> ranks) {
        List<Integer> collectRanks = ranks.stream().map(Rank::getWeight).sorted().collect(Collectors.toList());
        for (int i = 0; i < collectRanks.size() - 1; i++) {
            if (collectRanks.get(i + 1) - collectRanks.get(i) != 1) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "<hand " + new TreeSet<>(cardSet) + " " + calcHandValue().toString() + ">";
    }

    @Override
    public int compareTo(Hand hand) {
        List<Value> values = Arrays.asList(Value.values());
        int comparisonResult = Integer.compare(values.indexOf(calcHandValue()), values.indexOf(hand.calcHandValue()));
        if (comparisonResult == 0) {
            return comparisonStrategy.compare(this, hand);
        } else {
            return comparisonResult;
        }
    }

    public static void setComparisonStrategy(ComparisonStrategy comparisonStrategy) {
        comparisonStrategy = comparisonStrategy;
    }

    public Set<Card> getCardSet() {
        return cardSet;
    }
}
