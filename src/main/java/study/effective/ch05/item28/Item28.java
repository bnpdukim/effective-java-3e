package study.effective.ch05.item28;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Item28 {

    // 배열 이용
    static class Chooser1 {
        private final Object[] choiceArray;

        public Chooser1(Collection choices) {
            choiceArray = choices.toArray();
        }

        public Object choose() {
            Random rnd = ThreadLocalRandom.current();
            return choiceArray[rnd.nextInt(choiceArray.length)];
        }
    }

    // 제네릭 변환 시도 1
    static class Chooser2<T> {
        private final T[] choiceArray;

        public Chooser2(Collection<T> choices) {
            choiceArray = (T[]) choices.toArray();  // T가 무슨 타입인지 알 수 없다는 경고 메시지 뜸
        }

        public Object choose() {
            Random rnd = ThreadLocalRandom.current();
            return choiceArray[rnd.nextInt(choiceArray.length)];
        }
    }

    // 제네릭 변환 시도 2
    static class Chooser3<T> {
        private final List<T> choiceList;

        public Chooser3(Collection<T> choices) {
            choiceList =  new ArrayList<>(choices);  // T가 무슨 타입인지 알 수 없다는 경고 메시지 뜸
        }

        public Object choose() {
            Random rnd = ThreadLocalRandom.current();
            return choiceList.get(rnd.nextInt(choiceList.size()));
        }
    }

    public static void main(String[] args) {
        // 배열 이용
        List l = new ArrayList();
        l.add("hello"); l.add("world"); l.add( "effective"); l.add( "java");
        Chooser1 chooser1 = new Chooser1(l);
        String randomString = (String) chooser1.choose();

        // 제네릭 변환 시도 1 // 컴파일 워닝 발생
        // 제네릭 변환 시도 2 // 배열을 제거하고 리스트로 대체
    }

}
