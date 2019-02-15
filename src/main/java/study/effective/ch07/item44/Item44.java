package study.effective.ch07.item44;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class Item44 {
    public static void main(String[] args ) {
        int MAX = 4;
        LinkedHashMap<Integer, String> li_hash_map =
                new LinkedHashMap<Integer, String>() {
                    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                        return size() > MAX;
                    }
                };

        li_hash_map.put(0, "hello");
        li_hash_map.put(1, "world");
        li_hash_map.put(2, "effetive");
        li_hash_map.put(3, "java");
        log.info("{}",li_hash_map);
        li_hash_map.put(4, "good");
        log.info("{}", li_hash_map);
        li_hash_map.put(5, "morning");
        log.info("{}", li_hash_map);
    }
}
