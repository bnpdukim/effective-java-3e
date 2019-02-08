package study.effective.ch06.item39.sample3;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    @ExceptionTestCustom({IndexOutOfBoundsException.class, NullPointerException.class})
    public static void m1() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}
