package study.effective.ch05.item26;

import java.util.*;

public class Item26 {
    static class Stamp {

    }

    static class Coin {

    }

    public static void main(String[] args) {
        final Collection stamps = new ArrayList();
        stamps.add(new Stamp());
        stamps.add(new Coin());

//        for( Iterator i = stamps.iterator(); i.hasNext(); ) {
//            Stamp stamp = (Stamp) i.next(); // ClassCastException 발생
//        }

        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(40));
        String s = strings.get(0); // ClassCastException 발생
//        unsafeAdd2(strings, Integer.valueOf(40)); // List<String>은 List<Object>로 형변환이 안됨. 컴파일 엘러

        Set<Stamp> stampSet = new HashSet<>();
        Set<Coin> cointSet = new HashSet<>();
        numElementsInCommon(stampSet, cointSet);
    }

    private static void unsafeAdd(List strings, Object o) { // raw 타입 사용,
        strings.add(o);
    }

    private static void unsafeAdd2(List<Object> strings, Object o) { // raw 타입 사용,
        strings.add(o);
    }

    private static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for(Object o1 : s1) {
            if(s2.contains(o1)) result ++;
        }
        return result;
    }
}
