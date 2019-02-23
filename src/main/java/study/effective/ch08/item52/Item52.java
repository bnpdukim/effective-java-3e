package study.effective.ch08.item52;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Item52 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
//        service.submit(System.out::println);

        Runnable r = ()->System.out.println();
        service.submit(r);



        Callable<Integer> c = ()->{
            System.out.println();
            return 0;
        };
        service.submit(c);
    }
}
