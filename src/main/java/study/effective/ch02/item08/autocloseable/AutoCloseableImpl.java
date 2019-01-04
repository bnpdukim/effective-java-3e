package study.effective.ch02.item08.autocloseable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutoCloseableImpl implements AutoCloseable{
    private boolean closed = false;
    private final String name;

    public AutoCloseableImpl(String name) {
        this.name = name;
    }


    @Override
    public void close() throws Exception {
        if(closed) {
            throw new IllegalAccessException();
        }
        log.info("{} close() - resource close", name);
        closed = true;
    }

    @Override
    protected void finalize() throws Exception {
        log.info("{} finalize() - resource close", name);
        if(!closed) {
            close();
        }
    }
}
