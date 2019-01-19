package study.effective.ch03.item12;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class Item12 {

    public static void main(String[] args) {
        log.info(UUID.randomUUID().toString());

    }
}
