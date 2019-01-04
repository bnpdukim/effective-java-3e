package study.effective.ch02.item08.finalize;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FinalizeImpl {
    @Override
    protected void finalize() {
        log.info("finalize() - resource close");
    }
}
