package study.effective.ch04.item18.inherit;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Getter
@NoArgsConstructor
public class SecurityHashSet<E> extends HashSet {

    public SecurityHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(Object o) {
        // o를 검새하는 로직 추가
        if(o == null || !(o instanceof Integer)) {
            return false;
        } else {
            return super.add(o);
        }
    }
}
