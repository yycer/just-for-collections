package com.frankie.fun;

import com.frankie.fun.lambda.Dish;
import com.frankie.fun.lambda.Trader;
import com.frankie.fun.lambda.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
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

    @Test
    public void streamPracticeTest(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan  = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> transactions2011 = transactions.stream()
                .filter(x -> 2011 == x.getYear())
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        // Query 2: What are all the unique cities where the traders work?
//        List<String> uniqueCities = transactions.stream()
//                .map(Transaction::getTrader)
//                .map(Trader::getCity)
//                .distinct()
//                .collect(Collectors.toList());

        // Improve1: Merge map.
        List<String> uniqueCities = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        // Improve2: Use set.
        Set<String> uniqueCitySet = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .collect(Collectors.toSet());

        // Query 3: Find all traders from Cambridge and sort them by name.
//        List<Trader> traderFromCambridge = transactions.stream()
//                .map(Transaction::getTrader)
//                .distinct()
//                .filter(x -> "Cambridge".equals(x.getCity()))
//                .sorted(Comparator.comparing(Trader::getName))
//                .collect(Collectors.toList());

        // Improve3: distinct after filter!
        List<Trader> traderFromCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(x -> "Cambridge".equals(x.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        // Query 4: Return a string of all traders’ names sorted alphabetically.
//        List<String> traderNames = transactions.stream()
//                .map(Transaction::getTrader)
//                .sorted(Comparator.comparing(Trader::getName))
//                .map(Trader::getName)
//                .distinct()
//                .collect(Collectors.toList());


        // 解题思路有误：想要的是一个字符串，它根据交易员的姓名字母顺序排列，而不是一个姓名列表！
        // 优化点：sorted、distinct尽量放在后面(数据量较小的时候)执行。
//        String allTraderName = transactions.stream()
//                .map(x -> x.getTrader().getName())
//                .distinct()
//                .sorted()
//                .reduce("", (x, y) -> x + y);

        // 更高效率的解决方案！
        String allTraderName = transactions.stream()
                .map(x -> x.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());

        // Query 5: Are there any trader based in Milan?
//        boolean anyTraderBasedInMilan = transactions.stream()
//                .map(Transaction::getTrader)
//                .anyMatch(x -> "Milan".equals(x.getCity()));

        // 尽量减少流的数量
        boolean anyTraderBasedInMilan = transactions.stream()
                .anyMatch(x -> "Milan".equals(x.getTrader().getCity()));


        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
//        transactions.stream()
//                .map(Transaction::getTrader)
//                .filter(x -> "Milan".equals(x.getCity()))
//                .forEach(x -> x.setCity("Cambridge"));

        // Query 7: What's the highest value in all the transactions?
        Integer highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(0);

        // Query 8: What's the highest value transaction in all the transactions?
        Optional<Transaction> maxTransaction = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));
        Transaction transaction = maxTransaction.get();

        // Query 9: Find all traders from Cambridge and print their value.
        transactions.stream()
                .filter(x -> "Cambridge".equals(x.getTrader().getCity()))
                .forEach(x -> System.out.println(x.getTrader().getName() + " : " + x.getValue()));

    }
}




















