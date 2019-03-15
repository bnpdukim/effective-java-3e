package study.effective.ch11.item79.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

@Slf4j
public class Item79_2 {
    public static void main(String[] args) {

        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver( new SetObserver<Integer>() {

            @Override
            public void added(ObservableSet observableSet, Integer integer) {
                log.info("{}", integer);
                if(integer==23) observableSet.removeObserver(this);
            }
        });
        for(int i=0;i<100;i++) set.add(i);
    }
}
