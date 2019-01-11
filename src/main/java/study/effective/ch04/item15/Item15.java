package study.effective.ch04.item15;

public class Item15 {
    private static class Coffee {
        private final String name;

        private Coffee(String name) {
            this.name = name;
        }
    }

    private class Coffee2 {
        private final String name;

        private Coffee2(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        // static vs non static class
        // http://www.java67.com/2012/10/nested-class-java-static-vs-non-static-inner.html
        new Coffee("라떼");

//        new Coffee2("아메리카노"); // error
        Item15 item15 = new Item15();
        Item15.Coffee2 coffee2 =  item15.new Coffee2("아메리카노");
    }
}
