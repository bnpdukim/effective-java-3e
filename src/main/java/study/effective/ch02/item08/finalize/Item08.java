package study.effective.ch02.item08.finalize;

public class Item08 {
    public static void main(String[] args) throws InterruptedException {
        Item08 finalizeObject = new Item08();
        finalizeObject.test();

        Thread.sleep(100000); // 100초
    }

    private void test() {
        FinalizeImpl finalize = new FinalizeImpl();
    }
}
