package study.effective.ch04.item17;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Item17 {
    public static void main(String[] args) {
        Complex a = new Complex(1,2);
        Complex b = new Complex(3,4);

        log.info("{} plus {} = {}",a,b,a.plus(b));
        log.info("{} minus {} = {}",a,b,a.minus(b));
        log.info("{} times {}= {}",a,b,a.times(b));
        log.info("{} dividedBy {} = {}",a,b, a.dividedBy(b));
    }
}
