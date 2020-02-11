package com.frankie.fun;

import com.frankie.fun.lambda.Apple;
import com.frankie.fun.predicates.ApplePredicate;
import com.frankie.fun.predicates.GreenApplePredicate;
import com.frankie.fun.predicates.HeavyApplePredicate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @author: Yao Frankie
 * @date: 2020/2/11 20:30
 */
@SpringBootTest
public class BehavioralParamProcessTest {

    List<Apple> inventory = Arrays.asList(
            new Apple(80,"green"),
            new Apple(155, "green"),
            new Apple(120, "red"));

    @Test
    public void test(){
        // Step1: 筛选绿苹果
//        List<Apple> greenApples = filterGreenApple(inventory);
//        System.out.println("greenApples: " + greenApples);
//        greenApples: [Apple{color='green', weight=80}, Apple{color='green', weight=155}]


        // Step2: 把颜色作为参数
//        List<Apple> redApples = filterAppleByColor(inventory, "red");
//        List<Apple> greenApples = filterAppleByColor(inventory, "green");
//        System.out.println("redApples: "  + redApples);
//        System.out.println("greenApples: " + greenApples);

//        redApples  : [Apple{color='red', weight=120}]
//        greenApples: [Apple{color='green', weight=80}, Apple{color='green', weight=155}]


        // Step3: 根据多个属性筛选
//        List<Apple> heavyApples = filterAppleByWeight(inventory, 150);
//        System.out.println("heavyApples: " + heavyApples);
//        heavyApples: [Apple{color='green', weight=155}]

//        List<Apple> greenApples = filterApple(inventory, "green", 0, true);
//        List<Apple> heavyApples = filterApple(inventory, "", 150, false);
//        System.out.println("greenApples: " + greenApples);
//        System.out.println("heavyApples: " + heavyApples);

//        greenApples: [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
//        heavyApples: [Apple{color='green', weight=155}]


        // Step4: 根据抽象条件筛选
//        List<Apple> greenApples = filterApple(inventory, new GreenApplePredicate());
//        List<Apple> heavyApples = filterApple(inventory, new HeavyApplePredicate());
//        System.out.println("greenApples: " + greenApples);
//        System.out.println("heavyApples: " + heavyApples);

//        greenApples: [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
//        heavyApples: [Apple{color='green', weight=155}]



        // Step5: 使用匿名类


        // Step6: 使用Lambda表达式


        // Step7: 将List类型抽象化

    }

    /**
     * 根据谓词筛选数据源，做到行为参数化。
     * @param inventory：数据源
     * @param predicate：谓词
     */
    private List<Apple> filterApple(List<Apple> inventory, ApplePredicate predicate) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple a: inventory){
           if (predicate.test(a)){
                result.add(a);
            }
        }
        return result;
    }

    /**
     * 根据多个条件筛选数据源
     * @param inventory：数据源
     * @param color：颜色属性
     * @param weight：重量属性
     * @param flag：true[颜色]、false[重量]
     */
    private List<Apple> filterApple(List<Apple> inventory, String color, int weight, boolean flag) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple a: inventory){
            if ((flag  && color.equals(a.getColor()) ||
                (!flag && a.getWeight() > weight))){
                result.add(a);
            }
        }
        return result;
    }

    private List<Apple> filterAppleByWeight(List<Apple> inventory, int weight) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple a: inventory){
            if (a.getWeight() > weight){
                result.add(a);
            }
        }
        return result;
    }

    private List<Apple>  filterAppleByColor(List<Apple> inventory, String color) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple a: inventory){
            if (color.equals(a.getColor())){
                result.add(a);
            }
        }
        return result;
    }

    private List<Apple> filterGreenApple(List<Apple> inventory) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple a: inventory){
            if ("green".equals(a.getColor())){
                result.add(a);
            }
        }
        return result;
    }
}
