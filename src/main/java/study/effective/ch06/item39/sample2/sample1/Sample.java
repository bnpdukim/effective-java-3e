package study.effective.ch06.item39.sample2.sample1;

public class Sample {
    @ExceptionTestCustom(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i/i;
    }

    @ExceptionTestCustom(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTestCustom(ArithmeticException.class)
    public static void m3() {
    }
}
