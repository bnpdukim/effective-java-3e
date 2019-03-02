package study.effective.ch09.item58;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Item58 {
    enum Suit {CLUB, DIAMOND, HEART, SPACE}
    enum Rank{ACE,DEUCE, THREE, FOUR, FIVE, SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN, KING}

    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    enum Face { ONE, TWO, THREE, FOUR, FIVE, SIX}
    public static void main(String[] args) {
        //code 58-4 - runtime error
        List<Map.Entry<Suit,Rank>> entryList = new ArrayList<>();
        for(Iterator<Suit> i = suits.iterator(); i.hasNext();)
            for(Iterator<Rank> j = ranks.iterator(); j.hasNext();)
                entryList.add(new HashMap.SimpleEntry<>(i.next(),j.next())); // i.next()가 너무 많이 호출됨

        // code 58-5 - not expected result
        Collection<Face> faces = EnumSet.allOf(Face.class);
        for(Iterator<Face> i = faces.iterator(); i.hasNext();)
            for(Iterator<Face> j = faces.iterator(); j.hasNext();)
                log.info("{} {}", i.next(), j.next());

        // code 58-7 - good
        List<Map.Entry<Suit,Rank>> entryList2 = new ArrayList<>();
        for(Suit s : suits)
            for(Rank r : ranks)
                entryList2.add(new HashMap.SimpleEntry<>(s,r));

    }
}
