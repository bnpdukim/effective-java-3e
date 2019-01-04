package study.effective.ch03.item10.transitivity;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;

@Slf4j
public class Item10 {
    public static void main(String[] args) {

        // 상속 - 위반
        ColorPoint p1 = new ColorPoint(1,2, Color.RED);
        Point p2 = new Point(1,2);
        ColorPoint p3 = new ColorPoint(1,2, Color.BLUE);

        log.info("p1.equals(p2) : {}", p1.equals(p2));
        log.info("p2.equals(p3) : {}", p2.equals(p3));
        log.info("p1.equals(p3) : {}", p1.equals(p3));


        // composition
        ColorPointComposition p4 = new ColorPointComposition(1,2, Color.RED);
        Point p5 = new Point(1,2);
        ColorPointComposition p6 = new ColorPointComposition(1,2, Color.BLUE);

        log.info("p4.equals(p5) : {}", p4.equals(p5));
        log.info("p5.equals(p6) : {}", p5.equals(p6));
        log.info("p6.equals(p4) : {}", p6.equals(p4));
    }
}
