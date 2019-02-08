package study.effective.ch06.item39.sample4;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    @ExceptionTestCustom(IndexOutOfBoundsException.class)
    @ExceptionTestCustom(NullPointerException.class)
    public static void m1() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}
