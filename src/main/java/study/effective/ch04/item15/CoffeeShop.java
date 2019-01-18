package study.effective.ch04.item15;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoffeeShop {
    private static final String shopName = "자바커피집";

    interface Coffee {
        String license();
    }

    private static class CoffeeStatic implements Coffee {
        private final String coffeeName;

        private CoffeeStatic(String coffeeName) {
            this.coffeeName = coffeeName;
        }

        @Override
        public String license() {
            return coffeeName + " of " +shopName; // if non static field access of outer class, error
        }
    }

    private class CoffeeNonStatic implements Coffee {
        private final String coffeeName;

        private CoffeeNonStatic(String coffeeName) {
            this.coffeeName = coffeeName;
        }

        @Override
        public String license() {
            return coffeeName + " of " +shopName;
        }
    }

    public static void main(String[] args) {
        // static vs non static class
        // http://www.java67.com/2012/10/nested-class-java-static-vs-non-static-inner.html
        Coffee coffeeStatic  = new CoffeeShop.CoffeeStatic("라떼");
        log.info(coffeeStatic.license());

//        new CoffeeNonStatic("아메리카노"); // error
        Coffee coffeeNonStatic =  new CoffeeShop().new CoffeeNonStatic("아메리카노");
        log.info(coffeeNonStatic.license());
    }

    public static Coffee makeCoffee(String coffeeName, boolean staticOrNonstatic) { // staticOrNonStatic only test
        if(staticOrNonstatic)
            return new CoffeeShop.CoffeeStatic(coffeeName);
        else
            return new CoffeeShop().new CoffeeNonStatic(coffeeName);
    }
}
