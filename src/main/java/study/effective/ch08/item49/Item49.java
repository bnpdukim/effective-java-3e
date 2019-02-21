package study.effective.ch08.item49;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

/**
 * (현재 값 mod m) 값을 반환한다.
 * 이 메서드는 항상 음이 아닌 BigInteger를 반환하는 점에서 remainder 메서드와 다르다.
 *
 * @param  m m
 * @retrun mod m
 * @throws ArithmeticException 0 or negative
 */
@Slf4j
public class Item49 {
    public BigInteger mod(BigInteger m) {
        if(m.signum() <= 0 ) {
            throw new ArithmeticException("계수(m)은 양수여야 합니다. " + m);
        }
//        ...
        return m.mod(m);
    }

    public static void main(String[] args) {
        log.info("{}",new Item49().mod(BigInteger.ONE));
        sort(null, -1,2);
    }

    private static void sort(long a[], int offset, int length) {
        assert a!=null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
    }
}
