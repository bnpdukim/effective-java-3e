package study.effective.ch06.item39.sample1;

public class Sample {
    @TestCustom
    public static void m1() {
    }

    public static void m2() {
    }

    @TestCustom
    public static void m3() {
        throw new RuntimeException("failed");
    }

    public static void m4() {
    }

    @TestCustom
    public void m5() {
    }

    public static void m6() {
    }

    @TestCustom
    public static void m7() {
        throw new RuntimeException("failed");
    }

    public static void m8() {
    }
}
