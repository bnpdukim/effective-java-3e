package study.effective.ch07.item45;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Code45_4 {
    enum Suit {

    }

    enum Rank {

    }

    private static List<Card> newDeck() {
        return Stream.of(Suit.values())
                .flatMap(suit->
                    Stream.of(Rank.values())
                            .map(rank ->new Card(suit,rank))
                ).collect(toList());
    }

    private static class Card {
        public Card(Suit suit, Rank rank) {

        }
    }
}
