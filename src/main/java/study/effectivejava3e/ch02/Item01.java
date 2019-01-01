package study.effectivejava3e.ch02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Item01 {
    public static Boolean valueOf(boolean b) {
        return b?Boolean.TRUE:Boolean.FALSE;
    }
}
