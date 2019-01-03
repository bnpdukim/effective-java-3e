package study.effective.ch02.item07;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackStupid {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackStupid() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    // 스택에서 꺼내진 객체들을 가비지 컬렉터가 회수하지 않음
    public Object pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    private void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2*size+1);
        }
    }
}
