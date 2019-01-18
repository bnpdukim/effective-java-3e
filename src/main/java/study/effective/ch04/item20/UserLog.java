package study.effective.ch04.item20;

import lombok.extern.slf4j.Slf4j;

public interface UserLog {
    void print(String msg);
    String hello(String username);

    // skeletal
    @Slf4j
    abstract class AbstractUserLog implements UserLog {
        @Override
        public void print(String message) {
            log.info(hello(message));
        }
    }

    class Wrapper implements UserLog {
        private final AbstractUserLog abstractUserLog = new WrappedObject();

        // 실제구현체
        private class WrappedObject extends AbstractUserLog {
            @Override
            public String hello(String username) {
                return "hello " + username;
            }
        }

        // forwarding
        @Override
        public void print(String msg) {
            abstractUserLog.print(msg);
        }

        // forwarding
        @Override
        public String hello(String username) {
            return abstractUserLog.hello(username);
        }
    }
}
