package study.effective.ch09.item59;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Setter

@Getter
public class Item59 {

    static class Thread1 implements Runnable {
        Long longValue = Long.valueOf(5);
        @Override
        public void run() {
            Random r = new Random();
            // random한 시간 잠
            try {
                Thread.sleep(r.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            longValue = Thread.currentThread().getId();

            // random한 시간 잠
            try {
                Thread.sleep(r.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info("t1 {} : {}", Thread.currentThread().getId(),longValue);
        }
    }


    static class Thread2 implements Runnable {
        ThreadLocal<Long> threadLocal = new ThreadLocal<>();
        @Override
        public void run() {
            Random r = new Random();
            // random한 시간 잠
            try {
                Thread.sleep(r.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(Thread.currentThread().getId());

            // random한 시간 잠
            try {
                Thread.sleep(r.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info("t2 {} : {}", Thread.currentThread().getId(),threadLocal.get());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Executor executor1 = Executors.newFixedThreadPool(5);
        Thread1 t1 = new Thread1();
        executor1.execute(t1);
        executor1.execute(t1);
        executor1.execute(t1);

        Thread.sleep(5000);

        Executor executor2 = Executors.newFixedThreadPool(5);
        Thread2 t2 = new Thread2();
        executor2.execute(t2);
        executor2.execute(t2);
        executor2.execute(t2);

        ((ExecutorService) executor1).shutdown();
        ((ExecutorService) executor2).shutdown();
//        executor.execute(() -> {
//            ThreadLocal<Long> localVariable = new ThreadLocal<>();
//            // random한 시간 잠
//            try {
//                Thread.sleep(r.nextInt(10));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            localVariable.set(Thread.currentThread().getId());
//            log.info("{}", localVariable.get());
//        });

        int n = 2*(Integer.MAX_VALUE / 3);
        int low = 0;
        for(int i=0;i<100000;i++)
            if(random(n) < n/2)
                low++;
        log.info("{}",low);
    }

    static Random rnd = new Random();
    private static int random(int n) {

        ThreadLocal l;
        return Math.abs(rnd.nextInt()) % n;
//        return rnd.nextInt(n);
    }
}
