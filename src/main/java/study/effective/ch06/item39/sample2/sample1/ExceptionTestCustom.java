package study.effective.ch06.item39.sample2.sample1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 명시한 예외를 던저야만 테스트 성공
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTestCustom {
    Class<? extends Throwable> value();
}
