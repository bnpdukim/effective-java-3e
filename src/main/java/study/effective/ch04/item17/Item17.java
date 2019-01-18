package study.effective.ch04.item17;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
public class Item17 {
    public static void main(String[] args) {
        Complex a = new Complex(1,2);
        Complex b = new Complex(3,4);

        log.info("{} plus {} = {}",a,b,a.plus(b));
        log.info("{} minus {} = {}",a,b,a.minus(b));
        log.info("{} times {}= {}",a,b,a.times(b));
        log.info("{} dividedBy {} = {}",a,b, a.dividedBy(b));

        // 기본 타입 클래스의 정적 팩토리
        Long.valueOf(1);
        BigInteger bi1 = BigInteger.valueOf(1);
        BigInteger bi2 = bi1.negate();  // BigIneger 1053 line 참고
        log.info("b1 == b2 : {}", bi1 == bi2);


        // 불변 객체는 원소로 사용하기에 적합
        Set<String> s = new TreeSet<>();
        s.add("hello"); // compare를 이용

        // 불변 클래스는 조금만 수정해도 새로운 객체 생성해야함
        BigInteger f = BigInteger.valueOf(1);
        f.flipBit(0);

        BitSet bitSet = new BitSet(1);
        bitSet.flip(0); // 가변, 상수시간걸림림
    }
}
