package study.effective.ch04.item18.inherit;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Item18 {
    public static void main(String[] args ) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("hello", "world", "java", "effective"));
        log.info("count : {}", s.getAddCount());
    }
}
