package study.effective.ch06.item39.sample1;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class RunTests {
    public static void main(String[] args ) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("study.effective.ch06.item39.sample1.Sample");
        for(Method m : testClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(TestCustom.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    log.warn("{} 실패 : {}", m, exc );
                } catch (Exception e) {
                    log.warn("잘못 사용한 @ExceptionTestCustom: {}", m );
                }
            }
        }
        log.info("성공 : {}, 실패 : {}", passed, tests - passed);
    }
}
