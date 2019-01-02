package study.effective.ch02.item02;

import lombok.extern.slf4j.Slf4j;
import study.effective.ch02.item02.basic.NutritionFacts;
import study.effective.ch02.item02.basic.NutritionFacts2;

@Slf4j
public class Item02 {
    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240,8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        log.info("cocaCola : {}", cocaCola);

        NutritionFacts2 cocaCola2 = NutritionFacts2.builder()
                .servingSize(240)
                .servings(8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();
        log.info("cocaCola2 : {}", cocaCola2);
    }
}
