package study.effective.ch02.item07;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.stream.IntStream;

@Slf4j
public class Item07 {
    public static void main(String[] args) {
        int loopMax = 10000;

        StackStupid stupid = new StackStupid();
        IntStream.range(1,loopMax).forEach(i->stupid.push(new Date()));
        IntStream.range(1,loopMax).forEach(i->stupid.pop()); // 해제 안됨


        StackSmart smart = new StackSmart();
        IntStream.range(1,loopMax).forEach(i->smart.push(new Date()));
        IntStream.range(1,loopMax).forEach(i->smart.pop()); // 언젠가는 해제됨
    }
}
