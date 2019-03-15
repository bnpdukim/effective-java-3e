package study.effective.ch11.item79.advanced2;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Item79_5 {
    public static void main(String[] args)  {

        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver( new SetObserver<Integer>() {

            @Override
            public void added(ObservableSet observableSet, Integer integer) {
                log.info("{}", integer);
                if(integer==23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(()->observableSet.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }

                }
            }
        });
        for(int i=0;i<100;i++) set.add(i);
    }
}
