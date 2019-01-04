package study.effective.ch02.item03;

import java.util.function.Supplier;

public class Item03 {
    public static void main(String[] args ) {
        // static member
        Elvis.INSTANCE.leaveTheBuilding();

        // static factory method
        Tom.getInstance().leaveTheBuilding();

        // supplier
        doSomething(Tom::getInstance);
        doSomething(()->Tom.getInstance());
        doSomething(new Supplier<Tom>() {
            @Override
            public Tom get() {
                return Tom.getInstance();
            }
        });
    }

    private static void doSomething(Supplier<Tom> tom) {
        tom.get().leaveTheBuilding();
    }
}
