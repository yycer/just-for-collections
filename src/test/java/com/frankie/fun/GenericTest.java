package com.frankie.fun;

import com.frankie.fun.generic.Apple;
import com.frankie.fun.generic.MyStack;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

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
}
