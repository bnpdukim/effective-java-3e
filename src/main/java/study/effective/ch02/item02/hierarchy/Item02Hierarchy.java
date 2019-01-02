package study.effective.ch02.item02.hierarchy;

import lombok.extern.slf4j.Slf4j;
import study.effective.ch02.item02.basic.NutritionFacts;
import study.effective.ch02.item02.basic.NutritionFacts2;

@Slf4j
public class Item02Hierarchy {
    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM)
                .sauceInside()
                .build();

        log.info("nyPizza : {}", nyPizza);
        log.info("calzone : {}", calzone);

    }
}
