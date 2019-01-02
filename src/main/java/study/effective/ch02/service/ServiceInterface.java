package study.effective.ch02.service;

import lombok.extern.slf4j.Slf4j;

public interface ServiceInterface {
    void print();

    @Slf4j
    class Default implements ServiceInterface{

        @Override
        public void print() {
            log.info("hello wolrd, this is default service");
        }
    }

    @Slf4j
    class HappyNewYear implements ServiceInterface {

        @Override
        public void print() {
            log.info("Happy New Year");
        }
    }
}