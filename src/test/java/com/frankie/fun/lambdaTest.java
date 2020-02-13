package com.frankie.fun;

import com.frankie.fun.lambda.Apple;
import com.frankie.fun.predicates.AppleConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Yao Frankie
 * @date: 2020/2/13 14:47
 */
@SpringBootTest
public class lambdaTest {

    public final List<Apple> inventory = Arrays.asList(
            new Apple(80,"green"));

    public final String name = "yyc";
    public int NUM = 24;

    @Test
    public void thisTest(){
        printApple(inventory, new AppleConsumer() {
            @Override
            public void accept(Apple a) {
                System.out.println(this.print()); // l am in AppleConsumer interface.
                System.out.println(a.getWeight());
            }
        });

        printApple(inventory, a -> {
            System.out.println(this.justForTest()); // l am in lambdaTest class.
            System.out.println(a.getWeight());
        });
    }

    @Test
    public void classVariableTest(){
        printApple(inventory, new AppleConsumer() {
            @Override
            public void accept(Apple a) {
                System.out.println(NUM);
                System.out.println(a.getWeight());
            }
        });

        printApple(inventory, a -> {
            System.out.println(NUM);
            System.out.println(a.getWeight());
        });

    }

    public String justForTest(){
        return "l am in lambdaTest class.";
    }

    public void printApple(List<Apple> apples, AppleConsumer consumer){
        for (Apple a: apples){
            consumer.accept(a);
        }
    }
}
