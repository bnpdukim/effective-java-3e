package study.effective.ch02.item02.basic;


import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class NutritionFacts2 {
    //필수
    private final int servingSize;
    private final int servings;
    //옵션
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
}