package study.effective.ch06.item39.sample4;

import java.lang.annotation.*;

/**
 * 명시한 예외를 던저야만 테스트 성공
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTestCustom {
    Class<? extends Throwable> value();
}


