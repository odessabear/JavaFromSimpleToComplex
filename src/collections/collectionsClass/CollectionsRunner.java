package collections.collectionsClass;

import java.util.*;

public class CollectionsRunner {
    public static void main(String[] args) {
        List<Card> deckOfCards = new ArrayList<>();
        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                deckOfCards.add(new Card(suit, face));
            }
        }

        Collections.shuffle(deckOfCards);


        System.out.println("\n\nCards After shuffle");
        System.out.println();
        printOutput(deckOfCards);

        System.out.println();
        Collections.sort(deckOfCards);

        System.out.println("Cards after sorting");
        System.out.println();
        printOutput(deckOfCards);
        System.out.println();

        Card card = new Card(Card.Suit.SPADES, Card.Face.Queen);

        int i = Collections.binarySearch(deckOfCards, card);
        if (i >= 0) {
            System.out.println("Card was found at position " + i);
        } else {
            System.out.println("Card wasn't found!");
        }


    }

    private static void printOutput(List<Card> deckOfCards) {
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : " ");
        }
    }

}