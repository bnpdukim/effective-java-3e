package study.effective.ch03.item10.symmetry;

import lombok.extern.slf4j.Slf4j;
import study.effective.ch03.item10.transitivity.ColorPoint;
import study.effective.ch03.item10.transitivity.Point;

import java.awt.*;

@Slf4j
public class Item10 {
    public static void main(String[] args ) {
        // symmetry -
        CaseInsensitiveString cs = new CaseInsensitiveString("hello");
        String s = "hello";
        log.info("cs.equals(s) : {}",cs.equals(s)); // true
        log.info("s.equals(cs) : {}", s.equals(cs)); // false

        ColorPoint cp = new ColorPoint(1,2, Color.RED);
        Point p = new Point(1,2);
        log.info("p1.equals(p2) : {}",cp.equals(p)); // false
        log.info("p2.equals(p1) : {}", p.equals(cp)); // true

    }
}
