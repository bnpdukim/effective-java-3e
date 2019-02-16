package study.effective.ch07.item48;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

@Slf4j
public class Item48_2 {
    public static void main(String[] args) throws InterruptedException {
        IntStream.range(0, 10)
                .parallel()
                .forEach(index -> log.info("Starting {}, index={}, {}", Thread.currentThread().getName(), index, new Date()));
        Thread.sleep(3000);

        log.info("---------------------");

        IntStream.range(0, 10)
                .parallel()
                .forEachOrdered(index -> log.info("Starting {}, index={}, {}", Thread.currentThread().getName(), index, new Date()));
        Thread.sleep(3000);
    }
}
