package study.effective.ch02.item03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tom {
    private static final Tom INSTANCE = new Tom();
    private Tom() {

    }

    public static Tom getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        log.info("Tom leave the building");
    }
}
