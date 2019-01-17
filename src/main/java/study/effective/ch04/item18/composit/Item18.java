package study.effective.ch04.item18.composit;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;

@Slf4j
public class Item18 {
    public static void main(String[] args) {
        InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
        s.addAll(Arrays.asList("hello", "world", "effective"));
        log.info("count : {}",s.getAddCount());

        Properties p = new Properties();
        p.setProperty("1","a");
        p.put(new Integer(1), "a"); // hashmap api
    }
}
