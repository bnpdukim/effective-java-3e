package study.effective.ch09.item62;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Item62 {

    static void delayFrom0ToMS(int delayInTimeMs) {
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(delayInTimeMs));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class LocalVariableThread implements Runnable {
        Long longValue = Long.valueOf(5);
        @Override
        public void run() {
            delayFrom0ToMS(5000);
            longValue = Thread.currentThread().getId();
            delayFrom0ToMS(1000);

            log.info("t1 {} : {}", Thread.currentThread().getId(),longValue);
        }
    }


    static class ThreadLocalThread implements Runnable {
        ThreadLocal<Long> threadLocal = new ThreadLocal<>();
        @Override
        public void run() {
            delayFrom0ToMS(5000);
            threadLocal.set(Thread.currentThread().getId());
            delayFrom0ToMS(1000);

            log.info("t2 {} : {}", Thread.currentThread().getId(),threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Executor executor1 = Executors.newFixedThreadPool(5);
        LocalVariableThread t1 = new LocalVariableThread();
        executor1.execute(t1);
        executor1.execute(t1);
        executor1.execute(t1);

        Thread.sleep(5000);

        Executor executor2 = Executors.newFixedThreadPool(5);
        ThreadLocalThread t2 = new ThreadLocalThread();
        executor2.execute(t2);
        executor2.execute(t2);
        executor2.execute(t2);

        ((ExecutorService) executor1).shutdown();
        ((ExecutorService) executor2).shutdown();
    }
}
