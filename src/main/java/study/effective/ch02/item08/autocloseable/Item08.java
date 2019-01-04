package study.effective.ch02.item08.autocloseable;

public class Item08 {
    public static void main(String[] args) throws Exception {
        Item08 autoCloseableBasic = new Item08();
        autoCloseableBasic.basic("basic");

        Thread.sleep(5000);  // 5s

        Item08 autoCloseableTryResource = new Item08();
        autoCloseableTryResource.tryResource("tryResouce");

        Thread.sleep(100000); // 100s
    }

    private void basic(String name) throws Exception {
        AutoCloseableImpl auto = null;
        try {
            auto = new AutoCloseableImpl(name);
            // do something
        } finally {
            auto.close();
        }
    }

    private void tryResource(String name) throws Exception {
        try(AutoCloseableImpl auto = new AutoCloseableImpl(name)) {
            // do something
        }
    }
}
