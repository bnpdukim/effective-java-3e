package study.effective.ch02.item03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {

    }

    public void leaveTheBuilding() {
        log.info("Elvis leave the building");
    }
}
