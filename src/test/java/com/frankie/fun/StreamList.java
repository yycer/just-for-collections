package com.frankie.fun;

import com.frankie.fun.lambda.Dish;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Yao Frankie
 * @date: 2020/2/9 09:08
 */
@SpringBootTest
public class StreamList {

    @Test
    public void streamPartTest(){
        List<String> result = Dish.menu.stream()
                .filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void filterAndDistinctTest(){
        List<Integer> nums = Arrays.asList(1, 2, 1, 2, 3, 4, 3);

        nums.stream()
                .filter(x -> x % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void flatMapTest(){
//        List<String> words = Arrays.asList("Hello", "World");
//
//        List<String> collect = words.stream()
//                .map(x -> x.split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList());
//
//        System.out.println(collect.toString());

        List<String> words = Arrays.asList("Hello", "World");

        List<Stream<String>> collect = words.stream()
                .map(x -> x.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect.toString());
    }

    @Test
    public void mapTest(){
//      Step1: First question
        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result1 = nums1.stream().map(x -> (int)Math.pow(x, 2)).collect(Collectors.toList());
//        System.out.println(result1);

//      Step2: Second question
        List<Integer> nums2 = Arrays.asList(1, 2, 3);
        List<Integer> nums3 = Arrays.asList(3, 4);

        List<int[]> result2 = nums2.stream()
                .flatMap(x -> nums3.stream().map(y -> new int[]{x, y}))
                .collect(Collectors.toList());
        System.out.println(result2);
    }

    @Test
    public void reduceTest(){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        // Answer 1
//        int count = 0;
//        for (int num: nums){
//            count += num;
//        }
//        System.out.println(count);

        // Answer 2
//        Integer result = nums.stream().reduce(0, (x, y) -> x + y);
//        System.out.println(result);

        // Answer 3
//        Integer result = nums.stream().reduce(0, Integer::sum);
//        System.out.println(result);

//        How many dish in the stream?
//        long count = Dish.menu.stream().map(Dish::getName).count();
//        System.out.println(count);

        Integer count = Dish.menu.stream().map(x -> 1).reduce(0, Integer::sum);
        System.out.println(count);
    }
}




















