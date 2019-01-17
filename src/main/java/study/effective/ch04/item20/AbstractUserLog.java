package study.effective.ch04.item20;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractUserLog implements UserLog {
    @Override
    public void print(String message) {
        log.info(hello(message));
    }
}
