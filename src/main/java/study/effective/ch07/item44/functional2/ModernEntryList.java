package study.effective.ch07.item44.functional2;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiPredicate;

@Slf4j
public class ModernEntryList<K, V> {
    LinkedList<Map.Entry<K,V>> entries = new LinkedList<>();
    BiPredicate<LinkedList<Map.Entry<K,V>>, Map.Entry<K,V>> eldestEntryRemoval;

    ModernEntryList(BiPredicate<LinkedList<Map.Entry<K,V>>, Map.Entry<K,V>> eldestEntryRemoval) {
        this.eldestEntryRemoval = eldestEntryRemoval;
    }

    boolean put( K k, V v ) {
        HashMap.Entry<K,V> e = new HashMap.SimpleEntry<>(k,v);
        boolean result = entries.add(e);
        eldestClean(entries, e);
        return result;
    }

    private void eldestClean(LinkedList<Map.Entry<K, V>> entries, Map.Entry<K, V> e) {
        if(eldestEntryRemoval.test(entries, e) ) {
            entries.removeFirst();
        }
    }

    @Override
    public String toString() {
        return entries.toString();
    }

    public static void main(String[] args) {
        int MAX = 3;
        ModernEntryList<Integer, String> modernEntryList = new ModernEntryList<>((m, e)->m.size()>MAX);
        modernEntryList.put(0, "hello");
        modernEntryList.put(1, "world");
        modernEntryList.put(2, "effetive");
        modernEntryList.put(3, "java");
        log.info("{}",modernEntryList);
        modernEntryList.put(4, "good");
        log.info("{}", modernEntryList);
        modernEntryList.put(5, "morning");
        log.info("{}", modernEntryList);
    }
}
