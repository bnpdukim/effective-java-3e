package study.effective.ch07.item44.functional1;

import java.util.List;
import java.util.Map;

@FunctionalInterface interface EldestEntryRemovalFunction<K,V> {
    boolean remove(List<Map.Entry<K,V>> list, Map.Entry<K,V> eldest);
}
