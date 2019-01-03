package study.effective.ch02.item06;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Item06 {
    public static void main(String[] args ) {
        // 문자열 리터럴은 문자열을 불변객체이다.
        String s1 = new String("helloworld");
        String s2 = new String("helloworld");
        String s3 = "helloworld";
        String s4 = "helloworld";
        log.info("s1==s2 : {}", s1==s2);
        log.info("s3==s4 : {}", s3==s4);

        // 생성자를 이용하면 불필요한 객체 생성을 막는다.
        Boolean b1 = new Boolean("true");
        Boolean b2 = new Boolean("true");
        Boolean b3 = Boolean.valueOf("true");
        Boolean b4 = Boolean.valueOf("true");
        log.info("b1==b2 : {}", b1==b2);
        log.info("b3==b4 : {}", b3==b4);

        // 매번 비싼 객체인 Pattern 객체를 만든다.
        Util.isRomanNumeralStupid("test");
        // 클래스 초기화시 Pattern 객체를 만들고 재사용한다
        Util.isRomanNumeralSmart("test");

        // 어댑터(뷰)는 재사용 가능하다.
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value");
        Set<String> keys1 = map.keySet();
        map.put("key2", "value");
        Set<String> keys2 = map.keySet();

        log.info("{}", keys1==keys2);
        log.info("{}", keys1.equals(keys2));

        keys2.remove("key1"); // 주의 요망, key1을 사용하는 개발자는 빡칠수 있음
        log.info("remove in keys2, then keys1 : {}", keys1);


        // 오토박싱 주의하자.
        Long sum = 0L;
        for(long i= 0 ; i<=Integer.MAX_VALUE; i++) {
            sum+=i; // 매번 오토박싱이 일어남
        }
    }
}
