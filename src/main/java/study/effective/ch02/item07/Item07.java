package study.effective.ch02.item07;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.stream.IntStream;

@Slf4j
public class Item07 {
    public static void main(String[] args) {

        StackStupid stupid = new StackStupid();
        stupid.push(new Date());
        stupid.pop(); // 해제 안됨


        StackSmart smart = new StackSmart();
        smart.push(new Date());
        smart.pop(); // 언젠가는 해제됨
    }
}
