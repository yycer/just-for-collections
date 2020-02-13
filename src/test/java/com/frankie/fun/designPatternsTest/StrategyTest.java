package com.frankie.fun.designPatternsTest;

import com.frankie.fun.designPatterns.strategy.ValidAppleStrategy;
import com.frankie.fun.designPatterns.strategy.ValidGreenAppleStrategy;
import com.frankie.fun.designPatterns.strategy.ValidHeavyAppleStrategy;
import com.frankie.fun.lambda.Apple;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 15:37
 */
@SpringBootTest
public class StrategyTest {
    @Test
    public void test(){
        ValidGreenAppleStrategy greenAppleStrategy = new ValidGreenAppleStrategy();
        boolean isGreen1 = validApple(greenAppleStrategy, new Apple(120, "green")); // true
        boolean isGreen2 = validApple(greenAppleStrategy, new Apple(120, "red"));   // false

        ValidHeavyAppleStrategy heavyAppleStrategy = new ValidHeavyAppleStrategy();
        boolean isHeavy1 = validApple(heavyAppleStrategy, new Apple(180, "green")); // true
        boolean isHeavy2 = validApple(heavyAppleStrategy, new Apple(120, "green")); // false


    }

    @Test
    public void lambdaTest(){

        boolean isGreen1 = validApple(a -> "green".equals(a.getColor()), new Apple(120, "green")); // true
        boolean isGreen2 = validApple(a -> "green".equals(a.getColor()), new Apple(120, "red"));   // false

        boolean isHeavy1 = validApple(a -> a.getWeight() > 150, new Apple(180, "green")); // true
        boolean isHeavy2 = validApple(a -> a.getWeight() > 150, new Apple(120, "green")); // false

        System.out.println(isGreen1);
        System.out.println(isGreen2);
        System.out.println(isHeavy1);
        System.out.println(isHeavy2);
    }

    public boolean validApple(ValidAppleStrategy strategy, Apple a) {
        return strategy.valid(a);
    }
}
