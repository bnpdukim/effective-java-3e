package study.effective.ch11.item79.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

@Slf4j
public class Item79_1 {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver((s,e) -> log.info("{}",e));
        for(int i=0;i<100;i++) set.add(i);
    }
}
