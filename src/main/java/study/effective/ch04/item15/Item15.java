package study.effective.ch04.item15;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Item15 {
    public static void main(String[] args) {
        // 접근 권한 없음
//        CoffeeShop.Coffee 에러커피 = new CoffeeShop.CoffeeStatic("에러커피");


        // static vs non static class
        // http://www.java67.com/2012/10/nested-class-java-static-vs-non-static-inner.html
        CoffeeShop.Coffee 라떼  = CoffeeShop.makeCoffee("라떼", true);
        log.info(라떼.license());


        CoffeeShop.Coffee 아메리카노  = CoffeeShop.makeCoffee("아메리카노", false);
        log.info(아메리카노.license());
    }
}
