package collections.queue;

import collections.collectionsClass.Card;
import collections.collectionsClass.CardComparator;

import java.util.*;

public class QueueLauncher {

    public static void main(String[] args) {

        Queue<Card> cardDeck = new PriorityQueue<>(52,new CardComparator());

        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                cardDeck.offer(new Card(suit, face));
            }
        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println(cardDeck.poll());
//        }
//
//        System.out.println("Deck size is " + cardDeck.size());
//        System.out.println(cardDeck.peek());
//        cardDeck.clear();
//        System.out.println("Deck size is " + cardDeck.size());

        Deque<Card> cards = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            cards.offerLast(cardDeck.poll());
        }

//        for (int i = 0; i < 10; i++){
//            System.out.println(cards.pollLast());
//        }

        Card card = new Card(Card.Suit.SPADES,Card.Face.Ten);
        cards.removeFirstOccurrence(card);
        cards.removeLastOccurrence(card);
    }
}
