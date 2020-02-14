package com.frankie.fun;

import com.frankie.fun.generic.Apple;
import com.frankie.fun.generic.MyStack;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

/**
 * @author: Yao Frankie
 * @date: 2020/2/14 14:36
 */
@SpringBootTest
public class GenericTest {

    @Test
    public void classEraseTest(){
        Apple<Integer> integerApple = new Apple<>(8);
        Integer intSize = integerApple.getSize();

        Apple<?> wildcardApple = integerApple;
        Number size = wildcardApple.getSize();

        Apple rawApple = integerApple;
        Number numSize = rawApple.getSize();
    }

    @Test
    public void wildcardTest(){
        MyStack<Number> numbers = new MyStack<>();
        Iterable<Integer> integers = Arrays.asList(1, 2, 3);

        numbers.pushAll(integers);
    }

    @Test
    public void parseTest(){
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "5");
        map.put("b", "true");
        map.put("c", "-3");

//        int a = doGet(map, "a");
//        int b = doGet(map, "b");
//        int c = doGet(map, "c");
//        int d = doGet(map, "d");


        int a = doGetOptional(map, "a");
        int b = doGetOptional(map, "b");
        int c = doGetOptional(map, "c");
        int d = doGetOptional(map, "d");
    }

    private int doGetOptional(HashMap<String, String> map, String key) {
        return Optional.ofNullable(map.get(key))
                .flatMap(GenericTest::string2Int)
                .filter(x -> x > 0)
                .orElse(0);
    }

    public static Optional<Integer> string2Int(String s){
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e){
            return Optional.empty();
        }
    }


    /**
     * 1. "a":"5"    -> 5
     * 2. "b":"true" -> 0
     * 3. "c":"-3"   -> 0
     * 4. others     -> 0
     * @param map
     * @param key
     * @return
     */
    private int doGet(HashMap<String, String> map, String key) {
        String val = map.get(key);
        if (val != null){
            try {
                int i = Integer.parseInt(val);
                if (i > 0){
                    return i;
                }
            } catch (NumberFormatException ignored){ }
        }
        return 0;
    }
}
