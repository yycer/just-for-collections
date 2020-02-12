package com.frankie.fun;

import com.frankie.fun.lambda.Apple;
import com.frankie.fun.lambda.CaloricLevel;
import com.frankie.fun.lambda.Dish;
import com.frankie.fun.lambda.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Yao Frankie
 * @date: 2020/2/12 14:21
 */
@SpringBootTest
public class CollectorTest {

    List<Apple> inventory = Arrays.asList(
            new Apple(80,  "green"),
            new Apple(155, "green"),
            new Apple(120, "red"),
            new Apple(80,  "red"));

    List<Order> orders = Arrays.asList(
            new Order(UUID.randomUUID().toString(), BigDecimal.valueOf(100.30).setScale(2, BigDecimal.ROUND_HALF_UP)),
            new Order(UUID.randomUUID().toString(), BigDecimal.valueOf(500.99).setScale(2, BigDecimal.ROUND_HALF_UP)),
            new Order(UUID.randomUUID().toString(), BigDecimal.valueOf(391.88).setScale(2, BigDecimal.ROUND_HALF_UP))
            );

    @Test
    public void countTest(){
        long greenAppleCount = inventory.stream().filter(a -> "green".equals(a.getColor())).count();
        System.out.println("greenAppleCount = " + greenAppleCount);
    }

    /**
     * 最大、小分为：
     * 最大的重量/最大重量的东西。
     */
    @Test
    public void maxTest(){
        // 最大苹果重量
        int maxWeight = inventory.stream().mapToInt(Apple::getWeight).max().orElse(0);
        System.out.println("maxWeight = " + maxWeight);

        // 最大重量的苹果信息
        Apple maxApple = inventory.stream().max(Comparator.comparingInt(Apple::getWeight)).orElse(null);
        System.out.println("maxApple = " + maxApple);
    }

    /**
     * 平均数和总和一定是数值。
     */
    @Test
    public void avgAndSumTest(){
        double aveAmountDouble = orders.stream().mapToDouble(o -> o.getAmount().doubleValue()).average().orElse(0);
        double sumAmountDouble = orders.stream().mapToDouble(o -> o.getAmount().doubleValue()).sum();

//        System.out.println("aveAmountDouble = " + aveAmountDouble);
//        System.out.println("sumAmountDouble = " + sumAmountDouble);
//        aveAmountDouble = 331.0566666666667
//        sumAmountDouble = 993.1700000000001

        BigDecimal aveBg = BigDecimal.valueOf(aveAmountDouble).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal sumBg = BigDecimal.valueOf(sumAmountDouble).setScale(2, BigDecimal.ROUND_HALF_UP);
        

        System.out.println("aveBg = " + aveBg);
        System.out.println("sumBg = " + sumBg);
//        aveBg = 331.06
//        sumBg = 993.17
    }

    @Test
    public void groupingByTest(){

        Map<Dish.Type, List<Dish>> groupingByType = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));

        System.out.println("groupingByType = " + groupingByType);

        Map<CaloricLevel, List<Dish>> groupingByCalories = Dish.menu.stream()
                .collect(Collectors.groupingBy(d -> {
                    if      (d.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (d.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else                             return CaloricLevel.FAT;
        }));
        System.out.println("groupingByCalories = " + groupingByCalories);
    }
}







