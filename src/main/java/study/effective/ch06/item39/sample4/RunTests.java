package study.effective.ch06.item39.sample4;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class RunTests {
    public static void main(String[] args ) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("study.effective.ch06.item39.sample4.Sample");
        for(Method m : testClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(ExceptionTestCustom.class) || m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    log.warn("테스트 {} 실패 : 예외를 던지지 않음", m );
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    ExceptionTestCustom[] excTests = m.getAnnotationsByType(ExceptionTestCustom.class);
                    for(ExceptionTestCustom excType : excTests) {
                        if(excType.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if(passed == oldPassed)
                        log.warn("테스트 {} 실패 :  발생한 예외 : {}", m, exc.toString());
                } catch (Exception e) {
                    log.warn("잘못 사용한 @ExceptionTestCustom: {}", m );
                }
            }
        }
        log.info("성공 : {}, 실패 : {}", passed, tests - passed);
    }
}
