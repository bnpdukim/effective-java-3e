package study.effective.ch02.item06;

import java.util.regex.Pattern;

public class Util {
    static boolean isRomanNumeralStupid(String s) {
        // 호출시마다 내부에서 Pattern 객체 만든
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralSmart(String s) {
        return ROMAN.matcher(s).matches();
    }
}
